package com.xk.bean;

import java.io.Serializable;


/**
 * QQ�û��˺��࣬���ڴ洢QQ�û��Ļ�����Ϣ
 *
 */
public class Account implements Serializable{

	@Override
	public String toString() {
		return "Account [number=" + number + ", pwd=" + pwd + ", nickname=" + nickname + ", autograph=" + autograph
				+ ", gender=" + gender + ", age=" + age + ", adres=" + adres + ", contact=" + contact + ", birthday="
				+ birthday + ", state=" + state + ", headicon=" + headicon + "]";
	}
	private static final long serialVersionUID = 2561898798853320870L;
	
	private String number;		// �˺�
	private String pwd;	// ����
	private String nickname;	// �ǳ�
	private String autograph; 	// ����ǩ��
	private String gender;		// �Ա�
	private int age; 			// ����
	private String adres; 	// ʡ-��-��
	private String contact;  	// �ֻ���
	private String birthday;  // ����
	private String state;	// ״̬
	private String headicon; // ͷ��

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHeadIcon() {
		return headicon;
	}
	public void setHeadIcon(String headicon) {
		this.headicon = headicon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
