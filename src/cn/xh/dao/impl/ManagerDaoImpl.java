package cn.xh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;

import cn.xh.dao.ManagerDao;
import cn.xh.domain.Administrator;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.User;
import cn.xh.util.JDBCUtil;

public class ManagerDaoImpl implements ManagerDao {

	// 管理员登录
	@Override
	public Administrator login(String username, String password) {
		Administrator admin = new Administrator();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from administrator where admin_username=? and admin_password=?");
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, password);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				admin.setUsername(rs.getString("admin_username"));
				admin.setPassword(rs.getString("admin_password"));
				admin.setName(rs.getString("admin_name"));
				admin.setSex(rs.getString("admin_sex"));
				admin.setTel(rs.getString("admin_tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	// 管理员信息修改
	@Override
	public void managerInformation(Administrator admin) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(
					"update administrator set admin_name=?, admin_sex=?, admin_tel=? where admin_username=? ");
			prepareStatement.setString(1, admin.getName());
			prepareStatement.setString(2, admin.getSex());
			prepareStatement.setString(3, admin.getTel());
			prepareStatement.setString(4, admin.getUsername());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 管理员登录密码修改
	@Override
	public void managerPassword(Administrator admin) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("update administrator set admin_password=? where admin_username=?");
			prepareStatement.setString(1, admin.getPassword());
			prepareStatement.setString(2, admin.getUsername());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获得所有书籍分类信息
	@Override
	public List<Category> findAllCategory() {
		List<Category> list = new ArrayList<Category>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_id(rs.getString("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				category.setCategory_desc(rs.getString("category_desc"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过分类id找到分类信息
	@Override
	public Category findCategoryById(String categoryid) {
		Category category = new Category();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from category where category_id = ?");
			prepareStatement.setString(1, categoryid);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {

				category.setCategory_id(rs.getString("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				category.setCategory_desc(rs.getString("category_desc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	// 添加图书
	@Override
	public void addBook(Book book) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into bookdb values(?,?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setString(1, book.getBook_id());
			prepareStatement.setString(2, book.getBook_name());
			prepareStatement.setString(3, book.getBook_author());
			prepareStatement.setString(4, book.getBook_press());
			prepareStatement.setString(5, book.getCategory().getCategory_id());
			prepareStatement.setString(6, book.getFilename());
			prepareStatement.setString(7, book.getPath());
			prepareStatement.setString(8, book.getBook_desc());
			prepareStatement.setDouble(9, book.getBook_price());
			prepareStatement.setInt(10, book.getBook_kunumber());
			prepareStatement.setInt(11, 0);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加书籍分类
	@Override
	public void addCategory(Category category) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("insert into category values(?,?,?)");
			prepareStatement.setString(1, category.getCategory_id());
			prepareStatement.setString(2, category.getCategory_name());
			prepareStatement.setString(3, category.getCategory_desc());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 文学艺术类书籍
	@Override
	public List<Book> xsys() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.xsys();
	}

	// 人文社科类书籍列表
	@Override
	public List<Book> rwsk() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.rwsk();
	}

	// 少儿童书类书籍列表
	@Override
	public List<Book> sets() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.sets();
	}

	// 经济金融类书籍列表
	@Override
	public List<Book> jjjr() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.jjjr();
	}

	// 科学技术类书籍列表
	@Override
	public List<Book> kxjs() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.kxjs();
	}

	// 教育考试类书籍列表
	@Override
	public List<Book> jyks() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		return clientDaoImpl.jyks();
	}

	// 根据书籍id找到书籍信息
	@Override
	public Book findBookById(String book_id) {
		Book book = new Book();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from bookdb where book_id = ?");
			prepareStatement.setString(1, book_id);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				book.setBook_id(book_id);
				book.setBook_name(rs.getString("book_name"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				book.setCategory(category);
				book.setFilename(rs.getString("filename"));
				book.setPath(rs.getString("path"));
				book.setBook_desc(rs.getString("book_desc"));
				book.setBook_price(rs.getDouble("book_price"));
				book.setBook_kunumber(rs.getInt("book_kunumber"));
				book.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// 删除书籍
	@Override
	public void delBook(String book_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(" delete from bookdb where book_id=?");
			prepareStatement.setString(1, book_id);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editBook(String book_id, String book_name, String book_author, String book_press, String book_desc,
			double book_price, String book_kunumber) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(
					"update bookdb set book_name=?,book_author=?,book_press=?,book_desc=?,book_price=?,book_kunumber=? where book_id=?");
			prepareStatement.setString(1, book_name);
			prepareStatement.setString(2, book_author);
			prepareStatement.setString(3, book_press);
			prepareStatement.setString(4, book_desc);
			prepareStatement.setDouble(5, book_price);
			prepareStatement.setString(6, book_kunumber);
			prepareStatement.setString(7, book_id);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editCategory(Category category) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("update category set category_name=?,category_desc=? where category_id=?");
			prepareStatement.setString(1, category.getCategory_name());
			prepareStatement.setString(2, category.getCategory_desc());
			prepareStatement.setString(3, category.getCategory_id());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delCategory(String category_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("delete from category where category_id=?");
			prepareStatement.setString(1, category_id);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> findUsers() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from user");
			ResultSet rs = prepareStatement.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setAddress(rs.getString("user_address"));
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setSex(rs.getString("user_sex"));
				user.setTel(rs.getString("user_tel"));
				user.setUsername(rs.getString("user_username"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	// 添加管理人员
	@Override
	public void addAdmin(Administrator admin) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into administrator values(?,?,?,?,?)");
			prepareStatement.setString(1, admin.getUsername());
			prepareStatement.setString(2, admin.getPassword());
			prepareStatement.setString(3, admin.getName());
			prepareStatement.setString(4, admin.getSex());
			prepareStatement.setString(5, admin.getTel());

			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 书籍销售情况
	@Override
	public List<Book> sales() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from bookdb where book_xiaonumber>0 order by book_xiaonumber desc");
			ResultSet rs = prepareStatement.executeQuery();
			List<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getString("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				book.setCategory(category);
				book.setFilename(rs.getString("filename"));
				book.setPath(rs.getString("path"));
				book.setBook_desc(rs.getString("book_desc"));
				book.setBook_price(rs.getDouble("book_price"));
				book.setBook_kunumber(rs.getInt("book_kunumber"));
				book.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

}
