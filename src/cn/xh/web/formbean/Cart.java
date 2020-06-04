package cn.xh.web.formbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.xh.domain.Book;

//购物车
public class Cart implements Serializable {
	// CartItem是购物项
	private Map<String, CartItem> itmes = new HashMap<String, CartItem>();
	private int totalQuantity;// 总数量
	private float totalMoney;// 总金额

	public int getTotalQuantity() {
		totalQuantity = 0;
		for (Map.Entry<String, CartItem> me : itmes.entrySet()) {
			totalQuantity += me.getValue().getQuantity();
		}
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalMoney() {
		totalMoney = 0;
		for (Map.Entry<String, CartItem> me : itmes.entrySet()) {
			totalMoney += me.getValue().getMoney();
		}
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Map<String, CartItem> getItmes() {
		return itmes;
	}

	// 向购物车中添加一本书
	public void addBook(Book book) {
		if (itmes.containsKey(book.getBook_id())) {
			// 有对应的购物项
			CartItem item = itmes.get(book.getBook_id());
			item.setQuantity(item.getQuantity() + 1);
		} else {
			CartItem item = new CartItem(book);
			item.setQuantity(1);
			itmes.put(book.getBook_id(), item);
		}
	}

}
