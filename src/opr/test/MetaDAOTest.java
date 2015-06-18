package opr.test;

import static org.junit.Assert.*;

import java.util.List;

import opr.server.impl.MetaDAO;
import opr.shared.DALException;

import org.junit.BeforeClass;
import org.junit.Test;

public class MetaDAOTest {

	static MetaDAO mDAO; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mDAO = new MetaDAO();
	}

	@Test
	public void testGetTables() throws DALException {
		List<String> testArray = mDAO.getTables();
		
		assertTrue(testArray.get(2).equals("condiments"));
		assertTrue(testArray.get(4).equals("operatoer"));
	}

}
