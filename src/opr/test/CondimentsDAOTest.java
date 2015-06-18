package opr.test;

import static org.junit.Assert.*;
import opr.server.impl.BatchDAO;
import opr.server.impl.CondimentsDAO;
import opr.shared.DALException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CondimentsDAOTest {
	CondimentsDAO cDAO;

	@Before
	public void setUpBefore() throws Exception {
		cDAO = new CondimentsDAO();
	}


	@Test
	public void testGetCondimentsInfo() throws DALException {
		cDAO.getCondimentsInfo("Salt");
	}

	@Test
	public void testGetCondimentsList() {
		fail("Not yet implemented");
	}

}
