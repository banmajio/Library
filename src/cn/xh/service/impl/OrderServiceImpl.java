package cn.xh.service.impl;

import java.util.List;

import cn.xh.dao.OrdetrDao;
import cn.xh.dao.impl.OrderDaoImpl;
import cn.xh.domain.Order;
import cn.xh.domain.Orderitem;
import cn.xh.domain.User;
import cn.xh.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrdetrDao dao = new OrderDaoImpl();

	@Override
	public void genOrder(Order o) {
		if (o.getUser() == null) {
			throw new IllegalArgumentException("订单所属的客户信息没有");
		}
		if (o.getItems() == null || o.getItems().size() == 0) {
			throw new IllegalArgumentException("订单中没有订单项");
		}
		dao.save(o);
	}

	@Override
	public Order findOrderByNum(String ordernum) {
		return dao.findOrderByNum(ordernum);
	}

	@Override
	public List<Order> findUserOrders(User user) {
		return dao.findOrdersByUser(user.getId());
	}

	@Override
	public List<Order> findOrders() {
		// TODO Auto-generated method stub
		return dao.findOrders();
	}

	@Override
	public void faHuo(String ordernum) {
		// TODO Auto-generated method stub
		dao.faHuo(ordernum);
	}
}
