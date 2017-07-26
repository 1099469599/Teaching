package com.gs.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.dom.DOMAttribute;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4J {

	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new FileInputStream(new File("schema/car.xml")));
			Element root = doc.getRootElement(); // ��ȡ��Ԫ��
			System.out.println(root.getName()); // ��ȡ��ǩ������
			Namespace ns = root.getNamespace(); // ��ȡ�����ռ�
			System.out.println(ns.getName() + ":" + ns.getStringValue()); // �����ռ�����ƺ�ֵ
			getCarsElement(root);
			save(doc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) { // Doucment�����쳣   xml�ļ���Document����ʱ�������쳣
			e.printStackTrace();
		}
	}
	
	private static void getCarsElement(Element root) {
		@SuppressWarnings("unchecked")
		List<Element> eles = root.elements();
		for (Element e : eles) {
			System.out.println(e.getName());
			getCarElement(e);
			getCarAttribute(e);
		}
	}
	
	private static void getCarElement(Element car) {
		setCarElement(car);
		@SuppressWarnings("unchecked")
		List<Element> els = car.elements();
		for (Element e : els) {
			System.out.println(e.getName());
		}
		System.out.println("********************");
		System.out.println(car.element("wheels").element("count").getText()); // ֱ����ĳ������ǩ�¸����ӱ�ǩ������ֱ�ӻ�ȡ�ӱ�ǩ��
		System.out.println(car.elementText("test_e")); // ��ȡָ����ǩ������
	}
	
	private static void getCarAttribute(Element car) {
		setCarAttribute(car);
		@SuppressWarnings("unchecked")
		List<Attribute> attrs = car.attributes();
		for (Attribute a : attrs) {
			System.out.println(a.getName() + ": " + a.getStringValue() + ", " + a.getText()); // getName()��ȡ���Ե����ƣ�getStringValue()��ȡ���Ե�ֵ��getText()��ȡ����ֵ��Ҳ�������ڻ�ȡԪ���ڲ�������
		}
		System.out.println("**************************");
		Attribute idAttr = car.attribute("id");
		System.out.println(idAttr.getStringValue());
	}
	
	private static void setCarAttribute(Element car) {
		car.attribute("id").setValue("new 001");
		car.add(new DOMAttribute(new QName("test"), "test value")); // DOMAttribute(QName, String); ��һ��������ʾ���Ե����ƣ��ڶ������������Ե�ֵ
	}
	
	private static void setCarElement(Element car) {
		Element e = new DOMElement("test_e");
		e.setText("�ı�"); // ����ǩ�����ı�����
		car.add(e); // ���Ԫ��
		car.add(new DOMElement(new QName("test_ee")));
	}
	
	private static void save(Document doc) {
		OutputFormat format = OutputFormat.createPrettyPrint(); // �ÿ��ĸ�ʽ
		try {
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("schema/test_1.xml"), "utf-8"), format);
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
