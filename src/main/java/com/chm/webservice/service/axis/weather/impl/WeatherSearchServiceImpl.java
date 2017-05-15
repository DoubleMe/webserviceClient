package com.chm.webservice.service.axis.weather.impl;

import com.chm.webservice.base.OMElementPaser;
import com.chm.webservice.base.WebServiceClient;
import com.chm.webservice.service.axis.chinazip.dataobject.BizCity;
import com.chm.webservice.service.axis.weather.WeatherSearchService;
import com.chm.webservice.service.axis.weather.dataobject.WeatherCity;
import org.apache.axiom.om.OMElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen-hongmin on 2017/5/15.
 */
public class WeatherSearchServiceImpl implements WeatherSearchService{

    String url = "http://www.webservicex.net/globalweather.asmx?WDSL.";
    @Override
    public List<WeatherCity> getWeatherCity() {

        List<BizCity> list = new ArrayList<BizCity>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("CountryName","Canada");
        map.put("CityName","Canada");

        OMElement omElement = WebServiceClient.sendReceive(url,"http://www.webserviceX.NET","GetWeather",map);

        OMElementPaser.paser(list,omElement,"ZipInfo",4,BizCity.class);
        return null;
    }

    @Override
    public List<WeatherCity> GetCitiesByCountry() {

        List<WeatherCity> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("CountryName","Canada");
//        map.put("CityName","Canada");

        OMElement omElement = WebServiceClient.sendReceive(url,"http://www.webserviceX.NET","GetCitiesByCountry",map);

        System.out.println(omElement);
        OMElementPaser.paser(list,omElement,"Table",2,WeatherCity.class);
        return list;
    }
}
