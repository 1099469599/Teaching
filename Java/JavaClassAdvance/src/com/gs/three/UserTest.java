package com.gs.three;

public class UserTest {
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("��ʯ������");
		
		Address address = new Address();
		address.setProvice("����");
		address.setCity("����");
		user.setAddress(address);
		
		Car bmw = new Car();
		bmw.setName("����");
		CarEngine carEngine = new CarEngine();
		carEngine.setTopSpeed(400);
		bmw.setCarEngine(carEngine);
		
		Car benz = new Car();
		benz.setName("����");
		CarEngine carEngine1 = new CarEngine();
		carEngine1.setTopSpeed(400);
		benz.setCarEngine(carEngine1);
		
		Car[] cars = {bmw, benz};
		
		user.setCars(cars);
		
		System.out.println("������" + user.getAddress().getProvice() + user.getAddress().getCity()
				+ "��" + user.getName() + "��" + cars.length + "����");
		System.out.println("���£�");
		for (int i = 0, length = cars.length; i < length; i++) {
			System.out.println(cars[i].getName() + ", top speed: " + cars[i].getCarEngine().getTopSpeed());
		}
	}

}
