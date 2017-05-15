package com.chm.webservice.service.axis.weather;

import com.chm.webservice.service.axis.weather.dataobject.WeatherCity;

import java.util.List;

/**
 * Created by chen-hongmin on 2017/5/15.
 */
public interface WeatherSearchService {


    List<WeatherCity> getWeatherCity();

    List<WeatherCity> GetCitiesByCountry();
}
