package ir.maktab.test;

import org.junit.Test;

import ir.maktab.DAO.LoginDAO;
import ir.maktab.model.User;

import static org.junit.Assert.*;

public class TestCase {

	@Test
	public void testUser() {
		
		User u = new User(10,"ali","12345");
		assertEquals("ali",u.getUserName());
	}
	
	@Test
	public void testLoginDAO() {
		
		User u = new User(1,"bab","bab");
		assertEquals(u.getId(), new LoginDAO().getUser("bab","bab").getId());
	}
}
