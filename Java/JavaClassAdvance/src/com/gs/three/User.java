package com.gs.three;

public class User {

	private String name;
	private Address address; // һ��һ������ϵ��һ���û���Ӧһ����ַ
	private Car[] cars; // һ�Զ������ϵ
	
	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}
	
}
