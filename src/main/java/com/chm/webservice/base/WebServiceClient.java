package com.chm.webservice.base;//package webservice.base;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import java.util.Map;
import java.util.Set;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public class WebServiceClient {

    public static String defaultNameSpace = "http://WebXml.com.cn/";

    /**
     * 发送请求
     *
     * @param url
     * @param nameSpace
     * @param action
     * @param param
     * @return
     */
    public static OMElement sendReceive(String url, String nameSpace, String action, Map<String, Object> param) {

        try {
            //客户端
            ServiceClient serviceClient = new ServiceClient();
            //什么意思还没明白
            Options opts = new Options();
            EndpointReference end = new EndpointReference(url);
            opts.setTo(end);
            // action 一定要加上namespace 才可以通是什么原理？
            opts.setAction(nameSpace + "/" + action);
            serviceClient.setOptions(opts);
            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMNamespace omNs = fac.createOMNamespace(nameSpace, "");
            OMElement method = fac.createOMElement(action, omNs);

            addParam(fac, method, omNs, param);
            System.out.println(method);

            OMElement res = serviceClient.sendReceive(method);
            System.out.println(res.getAllAttributes());
            return res;
        } catch (AxisFault e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 发送请求
     *
     * @param url
     * @param action
     * @param param
     * @return
     */
    public static OMElement sendReceive(String url, String action, Map<String, Object> param) {

        return sendReceive(url, defaultNameSpace, action, param);
    }
    //
    //    /**
    //     * 添加header 信息
    //     * @param omFactory
    //     * @param header
    //     * @param omNamespace
    //     */
    //    public static void addHeader(OMFactory omFactory,OMElement header,OMNamespace omNamespace){
    //
    //        Map<String,Object> param = new HashMap<>();
    //        param.put("SendSystemId","APP0001");
    //        param.put("OrganizationId","33030200700");
    //        param.put("DocumentID","00_00_00_01");
    //        param.put("UserId","0033719");
    ////        param.put("Pwd","0033719"); 报错是什么意思啊
    //        param.put("RequestTime","2015-11-23 09:30:52");
    //        param.put("Client_IP","192.168.4.123");
    //        param.put("Client_Mac","00-FF-08-32-83-C1");
    //
    //        addParam(omFactory,header,omNamespace,param);
    //    }
    //    /**
    //     * 添加header 信息
    //     * @param omFactory
    //     * @param body
    //     * @param omNamespace
    //     * @param param
    //     */
    //    public static void addBody(OMFactory omFactory,OMElement body,OMNamespace omNamespace,Map<String,Object> param){
    //        Map<String,Object> p = new HashMap<>();
    //        p.put("name","192.168.4.123");
    //        p.put("user","00-FF-08-32-83-C1");
    //        addParam(omFactory,body,omNamespace,p);
    //    }

    /**
     * 添加参数
     *
     * @param omFactory
     * @param omElement
     * @param omNamespace
     * @param param
     */
    private static void addParam(OMFactory omFactory, OMElement omElement, OMNamespace omNamespace, Map<String, Object> param) {

        if (param == null || param.isEmpty()) {
            return;
        }
        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            buildParamElement(omFactory, omElement, omNamespace, entry.getKey(), entry.getValue());
        }

    }

    /**
     * 构建参数
     *
     * @param omFactory
     * @param omElement
     * @param omNamespace
     * @param key
     * @param value
     */
    private static void buildParamElement(OMFactory omFactory, OMElement omElement, OMNamespace omNamespace, String key, Object value) {

        OMElement param = omFactory.createOMElement(key, omNamespace);
        if (value instanceof String) {
            param.setText((String) value);
        } else {
            param = OMElementPaser.paserTOOMElement(value);
        }
        omElement.addChild(param);
    }

}
