package com.chm.webservice.service.axis.chinazip.dataobject;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public class BizCity {

    private String CITY;
    private String PROVINCE;
    private String ADDRESS;
    private String ZIP;

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

    public String getADDRESS() {

        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {

        this.ADDRESS = ADDRESS;
    }

    public String getZIP() {

        return ZIP;
    }

    public void setZIP(String ZIP) {

        this.ZIP = ZIP;
    }

    @Override
    public String toString() {

        return "BizCity{" + "CITY='" + CITY + '\'' + ", PROVINCE='" + PROVINCE + '\'' + ", ADDRESS='" + ADDRESS + '\'' + ", ZIP='" + ZIP + '\'' + '}';
    }
}
