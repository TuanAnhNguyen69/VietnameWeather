package com.anhnt.vietnamweather.weatherUtil;

import android.os.AsyncTask;

import com.anhnt.vietnamweather.weatherUtil.model.City;
import com.anhnt.vietnamweather.weatherUtil.model.Weather;

import org.json.JSONException;

public class WeatherUtil {

    Weather weather;
    WeatherInterface weatherInterface;

    private String api;

    private static WeatherUtil instance;

    public static WeatherUtil getInstance() {
        if (instance == null) {
            instance = new WeatherUtil();
        }

        return instance;
    }

    public void initialize(WeatherInterface weatherInterface, String api) {
        this.weatherInterface = weatherInterface;
        this.api = api;
    }

    public void getWeatherInformation(String cityCode) {
        if (cityCode == null) {
            return;
        }

        JSONWeatherTask jsonWeatherTask = new JSONWeatherTask();
        jsonWeatherTask.execute(City.getCityByCode(cityCode));
    }


    private class JSONWeatherTask extends AsyncTask<City, Void, Weather> {

        @Override
        protected Weather doInBackground(City... params) {
            Weather weather = new Weather();
            String data = ((new WeatherHttpClient()).getWeatherData(params[0], api));

            try {
                weather = JSONWeatherParser.getWeather(data);
                weather.iconLink = ((new WeatherHttpClient()).getImageURL(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return weather;

        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            if (weather == null || weatherInterface == null) {
                return;
            }

            weatherInterface.onWeatherInformation(weather);

        }
    }
}
