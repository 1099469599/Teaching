package com.gs.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaXML {
	
	/**
	 * ʲô�нڵ㣿
	 * ����xml�ĵ���˵��Ԫ�أ�Ԫ�ص����ݣ����Զ���֮Ϊ�ڵ�
	 * �ڵ���������ƣ�ֵ������
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ����������˵�����췽����˽�еģ�����ͨ�����췽���������������ʵ��
		// ��������ר�����������������͵Ķ�������ͨ��ֱ���ṩstatic�ķ�������������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new FileInputStream(new File("schema/car.xml"))); // Document��xml����Ӧ���ĵ������󣬰�����xml�ļ������е�Ԫ�أ�Ԫ�ص�����
			Element cars = getRootElement(doc);
			System.out.println(cars.getTagName()); // ��ȡԪ�ص�����
			System.out.println(cars.getAttribute("xmlns:xsi")); // �������Ե����ƻ�ȡ����ֵ
			getRootElementAttrs(cars);
			getCarElement(doc, cars);
			
			saveNewFile(cars);
		} catch (ParserConfigurationException e) { // ���������쳣
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) { // �ڶ�ȡ�ض���xml�ļ�ʱ���������쳣
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	private static Element getRootElement(Document doc) {
		return doc.getDocumentElement(); // ��ȡ��Ԫ��
	}
	
	private static void getRootElementAttrs(Element cars) {
		NamedNodeMap attrs = cars.getAttributes();
		for (int i = 0, len = attrs.getLength(); i < len; i++) {
			Node node = attrs.item(i); // ���������ƺ�ֵ��һ���ڵ����
			System.out.println("cars attr: " + node.getNodeName()); // �ڵ������
			System.out.println("cars attr value: " + node.getNodeValue()); // �ڵ��ֵ
			System.out.println("cars attr type: " + node.getNodeType()); // ����2����ʾ�˽ڵ�Ϊ���Խڵ�   2   ATTRIBUTE_NODE   1    ELEMENT_NODE 3    TEXT_NODE    8   COMMENT_NODE
		}
	}
	
	private static void getCarElement(Document doc, Element cars) {
		NodeList carList = cars.getChildNodes(); // ��ȡĳ��Ԫ���µ������ӽڵ㣨��һ��������ӽڵ㣩
		for (int i = 0, len = carList.getLength(); i < len; i++) {
			Node car = carList.item(i);
			if (car.getNodeType() == Node.ELEMENT_NODE) { // ����ڵ�������Ԫ�ؽڵ㣬�����Ԫ�ص����ơ����û���жϣ���Ԫ����Ԫ�ؼ���ı��ڵ�Ҳ�����
				System.out.println("car" + i + ": " + car.getNodeName());
				getCarElementAttrs(doc, car);
				getCarEngineBrand(car);
			}
		}
	}
	
	private static void getCarElementAttrs(Document doc, Node car) {
		NamedNodeMap carAttrs = car.getAttributes();
		Element ele = doc.createElement("test"); // ����һ��Ԫ��
		car.appendChild(ele); // ��ָ��Ԫ�غ���׷��һ����Ԫ��
		for (int ii = 0, len1 = carAttrs.getLength(); ii < len1; ii++) {
			Node attrNode = carAttrs.item(ii);
			attrNode.setNodeValue("aaaaaaaaaaaaaaaaaaaaa");
			System.out.println(attrNode.getNodeName() + ":" + attrNode.getNodeValue());
		}
	}
	
	private static void getCarEngineBrand(Node car) {
		NodeList nodeList = car.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// 
			}
		}
	}
	
	private static void saveNewFile(Element root) {
		try {
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer(); // transformer�ǰ�dom��Դת�����ļ������һ������
			DOMSource source = new DOMSource(root); // ���ݸ�Ԫ������ȡ����Dom��Դ
			File file = new File("schema/test.xml");
			StreamResult result = new StreamResult(file); // ���������
			transformer.transform(source, result); // ��DomSourceת��Ϊ�ļ���StreamResultָ��������
		} catch (TransformerException e) {

		}
	}

}
