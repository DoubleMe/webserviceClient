package com.chm.webservice;

import com.chm.webservice.service.axis.chinazip.dataobject.BizCity;
import com.chm.webservice.service.axis.chinazip.impl.ChinaZipSearchWebServiceImpl;
import com.chm.webservice.service.axis.weather.WeatherSearchService;
import com.chm.webservice.service.axis.weather.dataobject.WeatherCity;
import com.chm.webservice.service.axis.weather.impl.WeatherSearchServiceImpl;

import java.util.List;

/**
 * Created by chen-hongmin on 2017/5/15.
 */
public class TestService {


    public static void main(String[] args) {

        weatherSearchService();
    }

    public static void chinaZipSearchWebService(){

        ChinaZipSearchWebServiceImpl searchWebService = new ChinaZipSearchWebServiceImpl();

        List<BizCity> list = searchWebService.getZipCodeByAddress();
        System.out.println(list);
    }

    public static void weatherSearchService(){

        WeatherSearchServiceImpl weatherSearchService = new WeatherSearchServiceImpl();

        List<WeatherCity> list = weatherSearchService.GetCitiesByCountry();
        System.out.println(list);
    }
}
