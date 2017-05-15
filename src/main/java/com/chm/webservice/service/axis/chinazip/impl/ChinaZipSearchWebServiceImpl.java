package com.chm.webservice.service.axis.chinazip.impl;//package webservice.impl;

import com.chm.webservice.base.OMElementPaser;
import com.chm.webservice.base.WebServiceClient;
import com.chm.webservice.service.axis.chinazip.ChinaZipSearchWebService;
import com.chm.webservice.service.axis.chinazip.dataobject.BizCity;
import org.apache.axiom.om.OMElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public class ChinaZipSearchWebServiceImpl implements ChinaZipSearchWebService {

    String url = "http://www.webxml.com.cn/WebServices/ChinaZipSearchWebService.asmx";
    @Override
    public List<BizCity> getZipCodeByAddress() {

        List<BizCity> list = new ArrayList<BizCity>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("theProvinceName","上海");
        map.put("theCityName","宝山区");
        map.put("theAddress","");
        map.put("userID","");
        OMElement omElement = WebServiceClient.sendReceive(url,"getZipCodeByAddress",map);

        OMElementPaser.paser(list,omElement,"ZipInfo",4,BizCity.class);
        return list;
    }

}
