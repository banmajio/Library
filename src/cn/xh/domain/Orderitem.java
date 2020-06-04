package cn.xh.domain;

import java.io.Serializable;

//订单项
public class Orderitem implements Serializable {
	private String id;// 订单项id
	private int quantity;// 订单项得数量
	private double price;// 订单项小计
	private Book book;// 书籍信息
	private String ordernum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public Orderitem(String id, int quantity, double price, Book book, String ordernum) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.book = book;
		this.ordernum = ordernum;
	}

	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", book=" + book + ", ordernum="
				+ ordernum + "]";
	}

	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
