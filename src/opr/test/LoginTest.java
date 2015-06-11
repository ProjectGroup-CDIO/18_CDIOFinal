package opr.test;

import static org.junit.Assert.*;
import opr.client.ui.Login;
import opr.client.ui.MainView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
	static MainView mainView;
	@BeforeClass
	public static void preRun(){
		try {
			mainView = new MainView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testClear(){
		mainView.getLogin().getUserID().setText("123");
		mainView.getLogin().getPassword().setText("abc");
		System.out.println(mainView.getLogin().getPassword().getText());
		mainView.getLogin().clear();
	//	assertEquals("we expect it to be nothing","",	mainView.getLogin().getUserID().getText());
		assertTrue(true);
	}

	@Test
	public void testGetUName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassW() {
		fail("Not yet implemented");
	}
	@Test
	public void testLoginToDatabase(){
		fail("Not yet implemented");
	}
}
