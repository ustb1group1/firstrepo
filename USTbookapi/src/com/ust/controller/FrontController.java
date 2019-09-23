package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.BookDAOImpl;
import com.ust.model.Book;
import com.ust.model.Employee;
import com.ust.model.Role;

//@CrossOrgin("*")
@RestController
public class FrontController {
	
	@Autowired
	BookDAOImpl bookDaoImpl =new BookDAOImpl ();
	
	@RequestMapping(value="/api/book",method=RequestMethod.GET)
	@ResponseBody
	public List<Book>getAllBooks()
	{
		List list=bookDaoImpl.getBook();
		return list;
	}
	
	@RequestMapping(value="/api/book/{id}")
	@ResponseBody
	public Book getBookById(@PathVariable("id") long id)
	{
		return bookDaoImpl.get(id);
	}
	
	//insert
	@RequestMapping(value="/api/insertbook",method=RequestMethod.POST)
	public void insertBook(@RequestBody Book b)
	{
		bookDaoImpl.save(b);
	}
	
	@RequestMapping(value="/api/updatebook",method=RequestMethod.PUT)
	public void updateBook(@RequestBody Book b)
	{
		bookDaoImpl.update(b);
	}
	
	@RequestMapping(value="/api/deletebook/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id")long id)
	{
		bookDaoImpl.delete(id);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/api/employee/{username}/{userpassword}",method=RequestMethod.GET)
	@ResponseBody
	public Role selectRole(@PathVariable("username") String username,
			@PathVariable("userpassword") String password)
	{
		return bookDaoImpl.selectRole(username,password);
	}
	
	@RequestMapping(value="/api/employee",method=RequestMethod.GET)
	@ResponseBody
	public List<Role> selectRoleList()
	{
		List list= bookDaoImpl.selectRoleList();
		return list;
	}
	
	

}
