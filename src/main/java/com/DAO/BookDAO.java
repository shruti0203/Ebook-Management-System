package com.DAO;

import com.entity.BookDetailes;
import java.util.List;
import java.util.ArrayList;

public interface BookDAO {
	public boolean addBooks(BookDetailes b);
	
	public List<BookDetailes> getAllBooks();
	
	public BookDetailes getBookById(int id);
	
	public boolean updateEditBooks(BookDetailes b);
	
	public boolean deleteBooks(int id);
	
	public List<BookDetailes> getNewBook();
	
	public List<BookDetailes> getRecentBooks();
	
	public List<BookDetailes> getOldBooks();
	
	public List<BookDetailes> getAllRecentBook();
	
	public List<BookDetailes> getAllNewBook();
	
	public List<BookDetailes> getAllOldBook();
	
	public List<BookDetailes> getBookByOld(String email,String Cate);
	
	public boolean oldBookDelete(String email,String Cate,int id);
	
	public List<BookDetailes> getBookBySearch(String ch);
}
