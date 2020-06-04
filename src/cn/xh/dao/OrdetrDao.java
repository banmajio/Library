package cn.xh.dao;

import java.util.List;

import cn.xh.domain.Order;

public interface OrdetrDao {

	/**
	 * 保存订单的基本信息 还要保存订单关联的订单项信息
	 * 
	 * @param o
	 */
	void save(Order o);

	/**
	 * 根据订单号查找订单
	 * 
	 * @param ordernum
	 * @return 订单的基本信息
	 */
	Order findOrderByNum(String ordernum);

	/**
	 * 根据客户的id查询订单，按照日期排序排列
	 * 
	 * @param id
	 * @return
	 */
	List<Order> findOrdersByUser(String userId);

	List<Order> findOrders();

	void faHuo(String ordernum);

}
