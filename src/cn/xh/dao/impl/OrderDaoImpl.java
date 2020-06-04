package cn.xh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Or;

import cn.xh.dao.OrdetrDao;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.Order;
import cn.xh.domain.Orderitem;
import cn.xh.domain.User;
import cn.xh.util.JDBCUtil;
import sun.net.www.content.text.plain;

public class OrderDaoImpl implements OrdetrDao {

	Connection connection = JDBCUtil.getConnection();

	@Override
	public void save(Order o) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"insert into orders (ordernum,quantity,money,time,status,userId) values (?,?,?,?,?,?)");
			prepareStatement.setString(1, o.getOrdernum());
			prepareStatement.setInt(2, o.getQuantity());
			prepareStatement.setDouble(3, o.getMoney());
			prepareStatement.setString(4, o.getTime());
			prepareStatement.setInt(5, o.getStatus());
			prepareStatement.setString(6, o.getUser().getId());
			prepareStatement.executeUpdate();

			// 保存订单项信息
			List<Orderitem> items = o.getItems();
			for (Orderitem item : items) {
				PreparedStatement preparedStatement2 = connection.prepareStatement(
						"insert into orderitems (id,quantity,price,book_id,ordernum) values(?,?,?,?,?)");
				preparedStatement2.setString(1, item.getId());
				preparedStatement2.setInt(2, item.getQuantity());
				preparedStatement2.setDouble(3, item.getPrice());
				preparedStatement2.setString(4, item.getBook().getBook_id());
				preparedStatement2.setString(5, item.getOrdernum());
				preparedStatement2.executeUpdate();
				addXiaonumber(item.getBook().getBook_id());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addXiaonumber(String book_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(
					"update bookdb set book_xiaonumber = book_xiaonumber+1,book_kunumber=book_kunumber-1 where book_id=?");
			prepareStatement.setString(1, book_id);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Order findOrderByNum(String ordernum) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from orders where ordernum=?");
			prepareStatement.setString(1, ordernum);
			ResultSet rs = prepareStatement.executeQuery();
			Order order = new Order();
			if (rs.next()) {
				order.setOrdernum(rs.getString("ordernum"));
				order.setQuantity(rs.getInt("quantity"));
				order.setMoney(rs.getDouble("money"));
				order.setTime(rs.getString("time"));
				order.setStatus(rs.getInt("status"));
				User user = findUserByid(rs.getString("userId"));
				order.setUser(user);
				List<Orderitem> items = finOrdersItemsByNum(rs.getString("ordernum"));
				order.setItems(items);
			}
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	// 根据订单id找到订单项
	private List<Orderitem> finOrdersItemsByNum(String ordernum) {
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from orderitems where ordernum=?");
			prepareStatement.setString(1, ordernum);
			ResultSet rs = prepareStatement.executeQuery();
			List<Orderitem> list = new ArrayList<Orderitem>();
			while (rs.next()) {
				Orderitem item = new Orderitem();
				item.setOrdernum(ordernum);
				Book book = findBookById(rs.getString("book_id"));
				item.setBook(book);
				item.setId(rs.getString("id"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				list.add(item);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	// 根据书籍id找到书籍信息
	private Book findBookById(String book_id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from bookdb where book_id=?");
			prepareStatement.setString(1, book_id);
			ResultSet rs = prepareStatement.executeQuery();
			Book book = new Book();
			if (rs.next()) {
				book.setBook_id(rs.getString("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				book.setCategory(category);
				book.setFilename(rs.getString("filename"));
				book.setPath(rs.getString("path"));
				book.setBook_desc(rs.getString("book_desc"));
				book.setBook_kunumber(rs.getInt("book_kunumber"));
				book.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				book.setBook_price(rs.getDouble("book_price"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	// 根据书籍分类的id找到书籍分类信息
	private Category findCategoryById(String category_id) {
		Category category = new Category();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from category where category_id=?");
			preparedStatement.setString(1, category_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				category.setCategory_id(resultSet.getString("category_id"));
				category.setCategory_name(resultSet.getString("category_name"));
				category.setCategory_desc(resultSet.getString("category_desc"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	// 根据id找到用户信息
	private User findUserByid(String user_id) {
		try {
			User user = new User();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from user where user_id=?");
			prepareStatement.setString(1, user_id);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("user_id"));
				user.setUsername(rs.getString("user_username"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	@Override
	public List<Order> findOrdersByUser(String userId) {
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from orders where userId = ? order by ordernum desc");
			prepareStatement.setString(1, userId);
			ResultSet rs = prepareStatement.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				List<Orderitem> items = finOrdersItemsByNum(rs.getString("ordernum"));
				order.setItems(items);
				order.setMoney(rs.getDouble("money"));
				order.setOrdernum(rs.getString("ordernum"));
				order.setQuantity(rs.getInt("quantity"));
				order.setStatus(rs.getInt("status"));
				order.setTime(rs.getString("time"));
				order.setUser(findUserByid(userId));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	@Override
	public List<Order> findOrders() {
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from orders order by ordernum desc");
			ResultSet rs = prepareStatement.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				List<Orderitem> items = finOrdersItemsByNum(rs.getString("ordernum"));
				order.setItems(items);
				order.setMoney(rs.getDouble("money"));
				order.setOrdernum(rs.getString("ordernum"));
				order.setQuantity(rs.getInt("quantity"));
				order.setStatus(rs.getInt("status"));
				order.setTime(rs.getString("time"));
				order.setUser(findUserByid(rs.getString("userId")));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("");
	}

	@Override
	public void faHuo(String ordernum) {
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("update orders set status = 1 where ordernum=?");
			prepareStatement.setString(1, ordernum);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
