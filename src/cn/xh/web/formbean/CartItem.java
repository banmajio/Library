package cn.xh.web.formbean;

import java.io.Serializable;

import cn.xh.domain.Book;

//购物项
public class CartItem implements Serializable {
	private Book book;
	private int quantity;// 本项数量
	private float money;// 本项小计

	public CartItem(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMoney() {
		return book.getBook_price() * quantity;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Book getBook() {
		return book;
	}

}
