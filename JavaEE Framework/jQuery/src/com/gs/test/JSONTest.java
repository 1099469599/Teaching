package com.gs.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gs.bean.Product;

public class JSONTest {
	
	public static void main(String[] args) {
		JSONObject jsonObj = (JSONObject) JSON.parse("{'name':'test','age':20}"); // JSON.parseObject
		System.out.println(jsonObj.get("name"));
		System.out.println(jsonObj.getInteger("age"));
		JSONArray jsonObjArray = (JSONArray) JSON.parse("[{'name':'test','age':20},{'name':'test1','age':22},{'name':'test2','age':25}]"); // JSON.parseArray
		for (int i = 0, len = jsonObjArray.size(); i < len; i++) {
			JSONObject obj = jsonObjArray.getJSONObject(i);
			System.out.println(obj.get("name") + ": " + obj.getIntValue("age"));
		}
		
		Product product = JSON.parseObject("{'title':'�ֻ�','price':18.5}", Product.class);
		System.out.println(product);
		
		List<Product> products = JSON.parseArray("[{'title':'�ֻ�','price':18.5},{'title':'����','price':185},{'title':'����','price':1850}]", Product.class);
		for (Product p : products) {
			System.out.println(p);
		}
		System.out.println("======================================================");
		Product p1 = new Product("���", 1000);
		String jsonP1 = JSON.toJSONString(p1); // �ѵ�������ת����JSON�ַ���
		System.out.println(jsonP1);
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("��Ʒ1", 20));
		productList.add(new Product("��Ʒ2", 200));
		productList.add(new Product("��Ʒ3", 2000));
		Product[] productArray = {new Product("��Ʒ1", 20), new Product("��Ʒ2", 200), new Product("��Ʒ3", 2000)};
		String jsonPS = JSON.toJSONString(productList); // ��Listת����JSON�ַ���
		System.out.println(jsonPS);
		System.out.println(JSON.toJSONString(productArray));// �Ѷ�������ת����JSON�ַ���
	}
 
}
