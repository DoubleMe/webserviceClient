package com.chm.webservice.service.soap.weather;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen-hongmin on 2017/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-support.xml")
public class GlobalWeatherSoapTest {

    @Autowired
    private GlobalWeatherSoap globalWeatherSoap;

    @Test
    public void testGlobalWeatherSoap() {

        String str = globalWeatherSoap.getCitiesByCountry("China");
        System.out.println(str);
    }
}