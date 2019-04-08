package com.anhnt.vietnamweather.weatherUtil.model;

import java.io.Serializable;

public class Location implements Serializable {

	private float lon;
	private float lat;
	
	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
}
