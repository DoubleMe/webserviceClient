package com.chm.webservice.base.dataobject;

import java.io.Serializable;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public class Header implements Serializable {

    private String SendSystemId;

//    private String OrganizationId;
//
//    private String DocumentID;
//
//    private String UserId;
//
////    private String Pwd;
//
//    private String RequestTime;
//
//    private String Client_IP;
////
//    private String Client_Mac;

    public Header() {

    }

    public String getSendSystemId() {

        return SendSystemId;
    }

    public void setSendSystemId(String sendSystemId) {

        SendSystemId = sendSystemId;
    }
}
