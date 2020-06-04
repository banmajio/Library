package cn.xh.service.impl;

import java.util.List;
import java.util.UUID;

import cn.xh.dao.ManagerDao;
import cn.xh.dao.impl.ManagerDaoImpl;
import cn.xh.domain.Administrator;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.User;
import cn.xh.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao dao = new ManagerDaoImpl();

	@Override
	public Administrator login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public void managerInformation(String username, String name, String sex, String tel) {
		Administrator admin = new Administrator(username, null, name, sex, tel);
		dao.managerInformation(admin);
	}

	@Override
	public void managerPassword(String username, String password) {
		Administrator admin = new Administrator(username, password, null, null, null);
		dao.managerPassword(admin);
	}

	@Override
	public List<Category> findAllCategory() {
		return dao.findAllCategory();
	}

	@Override
	public Category findCategoryById(String categoryid) {
		return dao.findCategoryById(categoryid);
	}

	@Override
	public void addBook(Book book) {
		book.setBook_id(UUID.randomUUID().toString());
		dao.addBook(book);

	}

	@Override
	public void addCategory(Category category) {
		category.setCategory_id(UUID.randomUUID().toString());
		dao.addCategory(category);
	}

	@Override
	public List<Book> xsys() {
		return dao.xsys();
	}

	@Override
	public List<Book> rwsk() {
		return dao.rwsk();
	}

	@Override
	public List<Book> sets() {
		return dao.sets();
	}

	@Override
	public List<Book> jjjr() {
		return dao.jjjr();
	}

	@Override
	public List<Book> kxjs() {
		return dao.kxjs();
	}

	@Override
	public List<Book> jyks() {
		return dao.jyks();
	}

	@Override
	public Book findBookById(String book_id) {
		return dao.findBookById(book_id);
	}

	@Override
	public void delBook(String book_id) {
		dao.delBook(book_id);
	}

	@Override
	public void editBook(String book_id, String book_name, String book_author, String book_press, String book_desc,
			double book_price, String book_kunumber) {
		dao.editBook(book_id, book_name, book_author, book_press, book_desc, book_price, book_kunumber);
	}

	@Override
	public void editCategory(Category category) {
		dao.editCategory(category);
	}

	@Override
	public void delCategory(String category_id) {
		dao.delCategory(category_id);
	}

	@Override
	public List<User> findUsers() {
		return dao.findUsers();
	}

	@Override
	public void addAdmin(Administrator admin) {
		dao.addAdmin(admin);
	}

	@Override
	public List<Book> sales() {
		return dao.sales();
	}

}
