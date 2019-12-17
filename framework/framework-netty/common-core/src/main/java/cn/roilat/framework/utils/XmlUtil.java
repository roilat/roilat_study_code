package cn.roilat.framework.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XmlUtil {
	

	
	@SuppressWarnings("unchecked")
	public static <T> T xml2JavaBean(String xml, Class<T> clazz) {
		T t = null;
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static String javaBean2Xml(Object obj, String encoding) {
		String result = "";
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			//设置是否需要报文头。如：<?xml version="1.0" encoding="utf-8" standalone="yes"?>
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		String str = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
		System.out.println(xml2JavaBean(str, Xml.class));
	}
	
	@XmlRootElement(name="xml")
	static class Xml{
		@XmlElement(name="ToUserName")
		private String toUserName;
		@XmlElement(name="FromUserName")
		private String fromUserName;
		@XmlElement(name="CreateTime")
		private String createTime;
		@XmlElement(name="MsgType")
		private String msgType;
		@XmlElement(name="Content")
		private String content;
		@XmlElement(name="MsgId")
		private String msgId;
		@Override
		public String toString() {
			return "Xml [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
					+ ", msgType=" + msgType + ", content=" + content + ", msgId=" + msgId + "]";
		}
		
	}

}
