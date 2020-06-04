package cn.xh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.xh.dao.ClientDao;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.Favorite;
import cn.xh.domain.User;
import cn.xh.util.JDBCUtil;
import jdk.nashorn.internal.objects.annotations.Where;

public class ClientDaoImpl implements ClientDao {

	// 登录
	@Override
	public User login(String username, String password) {
		User user = new User();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user where user_username=? and user_password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet executeQuery = preparedStatement.executeQuery();
			if (executeQuery.next()) {
				user.setUsername(executeQuery.getString("user_username"));
				user.setPassword(executeQuery.getString("user_password"));
				user.setName(executeQuery.getString("user_name"));
				user.setSex(executeQuery.getString("user_sex"));
				user.setTel(executeQuery.getString("user_tel"));
				user.setAddress(executeQuery.getString("user_address"));
				user.setId(executeQuery.getString("user_id"));
			} else {
			}
		} catch (Exception e) {
		}
		return user;
	}

	// 注册
	@Override
	public boolean register(User user) {
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from user where user_username='" + user.getUsername() + "'");
			if (resultSet.next() == true) {
				return true;
			} else {
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(
							"insert into user (user_id,user_username,user_password,user_name,user_sex,user_tel,user_address) values(?,?,?,?,?,?,?)");
					preparedStatement.setString(1, user.getId());
					preparedStatement.setString(2, user.getUsername());
					preparedStatement.setString(3, user.getPassword());
					preparedStatement.setString(4, user.getName());
					preparedStatement.setString(5, user.getSex());
					preparedStatement.setString(6, user.getTel());
					preparedStatement.setString(7, user.getAddress());

					// 提交
					preparedStatement.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 文学艺术类书籍
	@Override
	public List<Book> xsys() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '文学艺术')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 通过书籍分类id得到书籍分类对象信息
	private Category findCategoryById(String book_category) {
		Category category = new Category();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from category where category_id=?");
			preparedStatement.setString(1, book_category);
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

	// 人文社科类书籍列表
	@Override
	public List<Book> rwsk() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '人文社科')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 少儿童书类书籍列表
	@Override
	public List<Book> sets() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '少儿童书')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 经济金融类书籍列表
	@Override
	public List<Book> jjjr() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '经济金融')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 科学技术类书籍列表
	@Override
	public List<Book> kxjs() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '科学技术')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 教育考试类书籍列表
	@Override
	public List<Book> jyks() {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bookdb where book_category = (select category_id from category where category_name = '教育考试')");
			ResultSet rs = preparedStatement.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				list.add(books);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("查询出异常！");
	}

	// 个人信息修改
	@Override
	public void personInformation(User user) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(
					"update user set user_name=?,user_sex=?,user_tel=?,user_address=? where user_username=?");
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getSex());
			prepareStatement.setString(3, user.getTel());
			prepareStatement.setString(4, user.getAddress());
			prepareStatement.setString(5, user.getUsername());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改密码
	@Override
	public void personPassword(User user) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("update user set user_password=? where user_username=?");
			prepareStatement.setString(1, user.getPassword());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 搜索框
	@Override
	public List<Book> search(String search) {
		List<Book> lists = new ArrayList<Book>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from bookdb where book_name like ?");
			preparedStatement.setString(1, "%" + search + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Book books = new Book();
				books.setBook_id(rs.getString("book_id"));
				books.setBook_name(rs.getString("book_name"));
				books.setBook_author(rs.getString("book_author"));
				books.setBook_press(rs.getString("book_press"));
				Category category = findCategoryById(rs.getString("book_category"));
				books.setCategory(category);
				books.setFilename(rs.getString("filename"));
				books.setPath(rs.getString("path"));
				books.setBook_desc(rs.getString("book_desc"));
				books.setBook_kunumber(rs.getInt("book_kunumber"));
				books.setBook_xiaonumber(rs.getInt("book_xiaonumber"));
				books.setBook_price(rs.getDouble("book_price"));
				lists.add(books);
			}
			return lists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 通过书籍id找到书籍信息
	@Override
	public Book findBookById(String book_id) {
		try {
			Book book = new Book();
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from bookdb where book_id = ?");
			prepareStatement.setString(1, book_id);
			ResultSet rs = prepareStatement.executeQuery();
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
			}
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加收藏夹
	@Override
	public void addfavorite(String favorite_id, String user_id, String book_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into favorite (favorite_id,user_id,book_id) values (?,?,?)");
			prepareStatement.setString(1, favorite_id);
			prepareStatement.setString(2, user_id);
			prepareStatement.setString(3, book_id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 显示收藏夹
	@Override
	public List<Favorite> findFavoriteByUserId(User user) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from favorite where user_id = ?");
			prepareStatement.setString(1, user.getId());
			ResultSet rs = prepareStatement.executeQuery();
			List<Favorite> list = new ArrayList<Favorite>();
			while (rs.next()) {
				Favorite favorite = new Favorite();
				favorite.setUser(user);
				favorite.setFavorite_id(rs.getString("favorite_id"));
				Book book = findBookById(rs.getString("book_id"));
				favorite.setBook(book);
				list.add(favorite);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean findFavorite(String user_id, String book_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from favorite where user_id=? and book_id=?");
			prepareStatement.setString(1, user_id);
			prepareStatement.setString(2, book_id);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	@Override
	public void delFavorite(String book_id) {
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("delete from favorite where book_id=?");
			prepareStatement.setString(1, book_id);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
