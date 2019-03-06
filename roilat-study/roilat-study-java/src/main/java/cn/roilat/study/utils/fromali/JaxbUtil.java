package cn.roilat.study.utils.fromali;


import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

import cn.roilat.study.utils.copybak.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * xml和java bean相互转换工具类
 *
 * @author roilat-J
 * @version $Id: JaxbUtil.java, v 0.1 2018年8月31日 下午5:43:53 roilat-J Exp $
 */
public class JaxbUtil {

    /**
     * xml字符串转java对象
     * @param xml   xml内容
     * @param clazz 要转换成的jav类
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T xml2JavaBean(String xml,Class<T> clazz) throws JAXBException {
        if (StringUtils.isEmpty(xml) || clazz == null) {
            return null;
        }
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        JAXBElement<T> jaxbElement = unmarshaller.unmarshal(source, clazz);
        return jaxbElement.getValue();
    }

    /**
     *  Java对象转xml字符串
     * @param javaBean
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> String javaBean2Xml(T javaBean) throws JAXBException {
        if(javaBean == null){
            return null;
        }
        JAXBContext jc = JAXBContext.newInstance(javaBean.getClass());
        Marshaller marshaller = jc.createMarshaller();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(javaBean,baos);
        return baos.toString();
    }
}
