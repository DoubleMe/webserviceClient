package com.chm.webservice.service.axis.chinazip.dataobject;

/**
 * Created by chen-hongmin on 2017/5/13.
 */
public class City {

    private String CITY;
    private String PROVINCE;

    public String getCITY() {

        return CITY;
    }

    public void setCITY(String CITY) {

        this.CITY = CITY;
    }

    public String getPROVINCE() {

        return PROVINCE;
    }

    public void setPROVINCE(String PROVINCE) {

        this.PROVINCE = PROVINCE;
    }

    @Override
    public String toString() {

        return "City{" + "CITY='" + CITY + '\'' + ", PROVINCE='" + PROVINCE + '\'' + '}';
    }
}
