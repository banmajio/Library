package cn.xh.dao;

import java.util.List;

import cn.xh.domain.Book;
import cn.xh.domain.Favorite;
import cn.xh.domain.User;

public interface ClientDao {

	User login(String username, String password);

	boolean register(User user);

	List<Book> xsys();

	List<Book> rwsk();

	List<Book> sets();

	List<Book> jjjr();

	List<Book> kxjs();

	List<Book> jyks();

	void personInformation(User user);

	void personPassword(User user);

	List<Book> search(String search);

	Book findBookById(String book_id);

	void addfavorite(String string, String user_id, String book_id);

	List<Favorite> findFavoriteByUserId(User user);

	boolean findFavorite(String user_id, String book_id);

	void delFavorite(String book_id);

}
