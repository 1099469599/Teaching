package com.gs.two;

public class PersonTest {
	
	public static void main(String[] args) {
		Person person = new Person();
		person.read();
		Worker worker = new Worker();
		// worker.company = "ABC"; // company��private�ģ�ֻ����Worker����ʹ��
		worker.read();
		worker.work();
		Teacher teacher = new Teacher();
		teacher.salary = 3000;
		teacher.read();
		// teacher.teachPlan(); // teachPlan()��private�ģ�ֻ����Teacher����ʹ��
		teacher.teach();
		TransferWorker tWorker = new TransferWorker();
		tWorker.transfer();
	}

}
