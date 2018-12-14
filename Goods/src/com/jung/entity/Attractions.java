package com.jung.entity;

/**
 *  ���ڴ洢������Ϣ
 * @author jung
 *
 */
public class Attractions {
	String name; // �������� 
	String address; //�����ַ
	String price; //����۸�
	String info ;//�������
	String pic;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return "Attractions [name=" + name + ", address=" + address + ", price=" + price + ", info=" + info + ", pic="
				+ pic + "]";
	}
	public Attractions(String name, String address, String price, String info, String pic) {
		super();
		this.name = name;
		this.address = address;
		this.price = price;
		this.info = info;
		this.pic = pic;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Attractions() {
		super();
	}
	
}
