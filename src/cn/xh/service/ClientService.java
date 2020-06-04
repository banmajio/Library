package cn.xh.service;

import java.util.List;

import cn.xh.domain.Book;
import cn.xh.domain.Favorite;
import cn.xh.domain.User;

public interface ClientService {

	public User login(String username, String password);

	public boolean register(String username, String password, String name, String sex, String tel, String address);

	public List<Book> xsys();

	public List<Book> rwsk();

	public List<Book> sets();

	public List<Book> jjjr();

	public List<Book> kxjs();

	public List<Book> jyks();

	public void personInformation(String username, String name, String sex, String tel, String address);

	public void personPassword(String password, String username);

	public List<Book> search(String search);

	public Book findBookById(String book_id);

	public void addfavorite(String user_id, String book_id);

	public List<Favorite> findFavoriteByUserId(User user);

	public boolean findFavorite(String user_id, String book_id);

	public void delFavorite(String book_id);


}
