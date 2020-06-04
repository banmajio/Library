package cn.xh.service.impl;

import java.util.List;
import java.util.UUID;

import cn.xh.dao.ClientDao;
import cn.xh.dao.impl.ClientDaoImpl;
import cn.xh.domain.Book;
import cn.xh.domain.Favorite;
import cn.xh.domain.User;
import cn.xh.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientDao dao = new ClientDaoImpl();

	@Override
	public User login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public boolean register(String username, String password, String name, String sex, String tel, String address) {
		User user = new User(UUID.randomUUID().toString(), username, password, name, sex, tel, address);
		return dao.register(user);
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
	public void personInformation(String username, String name, String sex, String tel, String address) {
		User user = new User(null, username, null, name, sex, tel, address);
		dao.personInformation(user);
	}

	@Override
	public void personPassword(String password, String username) {
		User user = new User(null, username, password, null, null, null, null);
		dao.personPassword(user);
	}

	@Override
	public List<Book> search(String search) {
		return dao.search(search);
	}

	@Override
	public Book findBookById(String book_id) {
		return dao.findBookById(book_id);
	}

	@Override
	public void addfavorite(String user_id, String book_id) {
		dao.addfavorite(UUID.randomUUID().toString(), user_id, book_id);
	}

	@Override
	public List<Favorite> findFavoriteByUserId(User user) {
		return dao.findFavoriteByUserId(user);
	}

	@Override
	public boolean findFavorite(String user_id, String book_id) {
		return dao.findFavorite(user_id, book_id);
	}

	@Override
	public void delFavorite(String book_id) {
		dao.delFavorite(book_id);

	}

}
