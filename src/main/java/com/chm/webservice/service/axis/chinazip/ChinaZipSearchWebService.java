package com.chm.webservice.service.axis.chinazip;//package webservice;

import com.chm.webservice.service.axis.chinazip.dataobject.BizCity;

import java.util.List;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public interface ChinaZipSearchWebService {


    List<BizCity> getZipCodeByAddress();
}
