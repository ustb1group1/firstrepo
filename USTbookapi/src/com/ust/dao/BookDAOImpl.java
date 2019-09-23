package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Book;
import com.ust.model.Employee;
import com.ust.model.Role;


public class BookDAOImpl {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//insert 
	public long save(Book b) {
		String sql = "insert into Book(title,author) values('"
				+ b.getTitle()+"','"+b.getAuthor()+ "')";
		return template.update(sql);

	}
	
	//get by id
	public Book get(long id) {
		String sql = "select id,title,author from Book where id=?";
		return template.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Book>(Book.class));

	}

	//get all
	public List<Book> getBook() {
		return template
				.query("select * from Book",
						new RowMapper<Book>() {
							@Override
							public Book mapRow(ResultSet rs, int row)
									throws SQLException {
								Book b= new Book();
								b.setId(rs.getLong(1));
								b.setTitle(rs.getString(2));
								b.setAuthor(rs.getString(3));
								return b;
							}
						});

	}
	
	public List<Role> selectRoleList() {
		return template
				.query("select * from roleTbl",
						new RowMapper<Role>() {
							@Override
							public Role mapRow(ResultSet rs, int row)
									throws SQLException {
								Role r= new Role();
								r.setRoleid(rs.getInt(1));
								r.setRolename(rs.getString(2));
								return r;
							}
						});

	}
	
	
	
	//update
	public int update(Book b) {
		String sql = "update Book set title='" + b.getTitle()
				+ "',author='" + b.getAuthor()
				+ "'  where id=" + b.getId();
		return template.update(sql);
	}

	//delete
	public int delete(Long id) {
		String sql = "delete from Book where id=" +id+"";
		return template.update(sql);
	}
	
/////////////////////////////////////////////////////////////////////////////////////
	
	/*public String selectRole(String username ,String password)
	{
		String rolename="";
		String sql ="select rolename from roleTbl where roleid=(select roleid from"
				+ " userTbl where username='"+username+"' and password='"+password+"')";
		try{
	    rolename=template.queryForObject(sql, new Object[]{},String.class);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return rolename;
	}*/
	
	public Role selectRole(String username ,String password)
	{
		String sql ="select roleid,rolename from roleTbl where roleid=(select roleid from"
				+ " userTbl where username='"+username+"' and password='"+password+"')";
		
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Role>(Role.class));
	}

}
