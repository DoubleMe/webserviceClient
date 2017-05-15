package com.chm.webservice.base;//package webservice.base;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.apache.axis2.util.StreamWrapper;

import java.util.Iterator;
import java.util.List;

/**
 * Created by chen-hongmin on 2017/5/14.
 */
public class OMElementPaser {

    /**
     * 将OMElement 解析成java对象
     * @param target 返回的对象集合
     * @param element 目标element
     * @param localName localname
     * @param targetLevel 目标层级
     * @param clazz
     * @param <T>
     */
    public static <T> void paser(List<T> target, OMElement element, String localName, int targetLevel,Class clazz){

        paser(target,element,localName,1,targetLevel,clazz);
    }

    /**
     * 将OMElement 解析成java对象
     * @param target 返回的对象集合
     * @param element 目标element
     * @param localName localname
     * @param level 当前层级
     * @param targetLevel 目标层级
     * @param clazz
     * @param <T>
     */
    public static <T> void paser(List<T> target, OMElement element, String localName, int level, int targetLevel,Class clazz){

        if (element == null) {
            return;
        }
        Iterator<OMElement> iterator = element.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement = iterator.next();
            System.out.println(omElement.getLocalName());
            if (targetLevel != level){
                paser(target,omElement,localName,level + 1,targetLevel,clazz);
            }else if (localName.equals(omElement.getLocalName())){
                try {
                    T value = (T) BeanUtil.processObject(omElement,clazz, null, true, new DefaultObjectSupplier(), null);
                    target.add(value);
                } catch (AxisFault e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static<T> OMElement paserTOOMElement(T t){

        javax.xml.stream.XMLStreamReader reader = BeanUtil.getPullParser(t);
        StreamWrapper parser = new StreamWrapper(reader);
        OMXMLParserWrapper stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder(OMAbstractFactory.getOMFactory(), parser);
        OMElement element = stAXOMBuilder.getDocumentElement();
        return element;
    }
}
