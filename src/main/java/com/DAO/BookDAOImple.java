package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.entity.BookDetailes;

public class BookDAOImple implements BookDAO{
	
	private Connection conn;
	
	
	public BookDAOImple(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addBooks(BookDetailes b) {
		boolean f=false;
		try {
			
			String sql="insert into book_details(bookname,author,price,bookCategory,status,photo,user_email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookCategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhoto());
			ps.setString(7, b.getEmail());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public List<BookDetailes> getAllBooks() {
		
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		
		
		try {
			
			String sql="select * from book_details";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			BookDetailes b=new BookDetailes();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getString(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setEmail(rs.getString(8));
			list.add(b);
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public BookDetailes getBookById(int id) {
		
		BookDetailes b=null;
		try {
			
			String sql="select * from book_details where bookId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			    b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));	
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return b;
	}


	@Override
	public boolean updateEditBooks(BookDetailes b) {
		boolean f=false;
		try {
		
			String sql="update book_details set bookname=?,author=?,price=?,status=? where bookId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBookId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}


	@Override
	public boolean deleteBooks(int id) {
		boolean f=false;
		try {
			String sql="delete from book_details where bookId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<BookDetailes> getNewBook() {
		
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;;
			while(rs.next()&&i<=4) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}


	@Override
	public List<BookDetailes> getRecentBooks() {
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;;
			while(rs.next()&&i<=4) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<BookDetailes> getOldBooks() {
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;;
			while(rs.next()&&i<=4) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<BookDetailes> getAllRecentBook() {
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<BookDetailes> getAllNewBook() {

		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}


	@Override
	public List<BookDetailes> getAllOldBook() {
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<BookDetailes> getBookByOld(String email, String Cate) {
		
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where user_email=? and bookCategory=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Cate);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public boolean oldBookDelete(String email, String Cate,int id) {
		boolean f=false;
		try {
			String sql="delete from book_details where user_email=? and bookCategory=? and bookId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Cate);
			ps.setInt(3,id);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}


	@Override
	public List<BookDetailes> getBookBySearch(String ch) {
		List<BookDetailes> list=new ArrayList<BookDetailes>();
		BookDetailes b=null;
		try {
			String sql="select * from book_details where bookname like ? or author like ? or bookCategory like ? and status=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2,"%"+ch+"%");
			ps.setString(3,"%"+ch+"%");
			ps.setString(4,"Active");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new BookDetailes();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
}
