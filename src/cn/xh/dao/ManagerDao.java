package cn.xh.dao;

import java.util.List;

import cn.xh.domain.Administrator;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.User;

public interface ManagerDao {

	Administrator login(String username, String password);

	void managerInformation(Administrator admin);

	void managerPassword(Administrator admin);

	List<Category> findAllCategory();

	Category findCategoryById(String categoryid);

	void addBook(Book book);

	void addCategory(Category category);

	List<Book> xsys();

	List<Book> rwsk();

	List<Book> sets();

	List<Book> jjjr();

	List<Book> kxjs();

	List<Book> jyks();

	Book findBookById(String book_id);

	void delBook(String book_id);

	void editBook(String book_id, String book_name, String book_author, String book_press, String book_desc,
			double book_price, String book_kunumber);

	void editCategory(Category category);

	void delCategory(String category_id);

	List<User> findUsers();

	void addAdmin(Administrator admin);

	List<Book> sales();

}
