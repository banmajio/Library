package cn.xh.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//订单
public class Order implements Serializable {
	private String ordernum;// 订单号
	private int quantity;// 购物项数量
	private double money;// 总金额
	private String time;// 订单创建时间
	private int status;// 订单状态：0未付款，1已付款，2未发货，3已发货
	private User user;// 客户

	private List<Orderitem> items = new ArrayList<Orderitem>();// 订单项

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderitem> getItems() {
		return items;
	}

	public void setItems(List<Orderitem> items) {
		this.items = items;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String ordernum, int quantity, double money, String time, int status, User user,
			List<Orderitem> items) {
		super();
		this.ordernum = ordernum;
		this.quantity = quantity;
		this.money = money;
		this.time = time;
		this.status = status;
		this.user = user;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [ordernum=" + ordernum + ", quantity=" + quantity + ", money=" + money + ", time=" + time
				+ ", status=" + status + ", user=" + user + ", items=" + items + "]";
	}

}
