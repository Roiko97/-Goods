package com.jung.entity;

import java.util.List;

/**
 *  �̻��� ���� �ܱߡ��̻����
 * @author jung
 *
 */
public class Merchant {
	String merchant_id; //�̻�Ψһ��ʶid
	String name; //�̻�����
	String address; //�̻���ַ
	String phone; //�̻��绰
	String info;//���̽���
	List<Food> food;  //�̻���Ӫʳ��
	String pic;
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Merchant() {
		super();
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Merchant(String merchant_id, String name, String address, String phone, String info, List<Food> food,String pic) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.info = info;
		this.food = food;
		this.pic = pic;
	}
	

	
}
