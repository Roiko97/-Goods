package com.jung.entity;

/**
 *  ʳ���� ���ڴ洢ʳ����Ϣ
 * @author jung
 *
 */
public class Food {
	String merchant_id; // ���̵�Ψһָ��id
	String  name; //ʳ�������
	String price; //ʳ��ļ۸�
	String info ; //ʳ��Ľ�����Ϣ
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Food [merchant_id=" + merchant_id + ", name=" + name + ", price=" + price + ", info=" + info + "]";
	}
	public Food(String merchant_id, String name, String price, String info) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.price = price;
		this.info = info;
	}
	public Food() {
		super();
	}
	
	
}
