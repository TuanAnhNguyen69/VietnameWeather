# VietnameWeather

Get weather of Vietnam provinces using https://openweathermap.org/

# Install
  Step 1. Add the JitPack repository to your build file
  
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.TuanAnhNguyen69:VietnameWeather:Tag'
	}
  
 # Usage
   
   Step 1. Get an openweathermap current weather API key
   
   Step 2. Initialize 
   
      WeatherUtil.getInstance().initialize(this, API_KEY);
      
   Step 3. Implement WeatherInterface in your activity
   
      @Override
      public void onWeatherInformation(Weather weather) {
          // Do something
      }
   
   Step 4. Get weather
   
      WeatherUtil.getInstance().getWeatherInformation(CITY_CODE);
      
 
 # City code
    
    Update later (Short form of province in Upper case)

      
    

  
