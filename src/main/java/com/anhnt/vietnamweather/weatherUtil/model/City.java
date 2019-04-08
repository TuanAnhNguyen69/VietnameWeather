package com.anhnt.vietnamweather.weatherUtil.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {
    private static HashMap<String, City> cityHashMap;
    static {
        cityHashMap = new HashMap<>();
        Gson gson = new Gson();
        ArrayList<City> cities = gson.fromJson(CityData.CITY_JSON, new TypeToken<List<City>>(){}.getType());
        for (City city : cities) {
            cityHashMap.put(city.code, city);
        }
    }

    private String id;
    private String name;
    private String country;
    private Location coord;
    private String code;

    public String getId() {
        return id;
    }

    public Location getCoord() {
        return coord;
    }

    public void setCoord(Location coord) {
        this.coord = coord;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public City(String id, String name, String country, Location coord, String code) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coord = coord;
        this.code = code;
    }

    public City() {
        this.coord = new Location();
    }

    public static void createVNJson() {
        Gson gson = new Gson();
    }


    public static City getCityByCode(String code) {
        return cityHashMap.get(code);
    }
}
