package com.sq580.pzh580.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
/**
 * ClassName: JavaToXMLUtil<br/>
 * Function: java 与 xml 的转换<br/>
 * Date: 2018-08-02 11:26<br/>
 *
 * @author chensh
 */
public class XmlConvertUtil {
    public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        //格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF_8");
        // 不生成报文头
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }
}
