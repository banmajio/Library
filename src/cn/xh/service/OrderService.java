package cn.xh.service;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Or;

import cn.xh.domain.Order;
import cn.xh.domain.Orderitem;
import cn.xh.domain.User;

public interface OrderService {
	/**
	 * 生成订单
	 * 
	 * @param o
	 */
	void genOrder(Order o);

	/**
	 * 根据订单号查询订单
	 * 
	 * @param ordernum
	 * @return
	 */
	Order findOrderByNum(String ordernum);

	/**
	 * 查询客户的订单
	 * 
	 * @param user
	 * @return
	 */
	List<Order> findUserOrders(User user);

	List<Order> findOrders();

	void faHuo(String ordernum);
}
