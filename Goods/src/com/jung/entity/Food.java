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
		return "Food [merchant_id=" + merchant_id + ", name=" + name + ", price=" + price + ", info=" + info + ", pic="
				+ pic + "]";
	}
	public Food(String merchant_id, String name, String price, String info, String pic) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.price = price;
		this.info = info;
		this.pic = pic;
	}
	public Food() {
		super();
	}
	
	
}
