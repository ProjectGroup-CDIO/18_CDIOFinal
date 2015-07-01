package opr.test;

import static org.junit.Assert.*;

import java.util.List;

import opr.server.impl.BatchDAO;
import opr.server.impl.CondimentsDAO;
import opr.shared.CondimentsDTO;
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
	CondimentsDTO cDTO = cDAO.getCondimentsInfo("Salt");
		assertTrue(cDTO.getName().equals("Salt"));
		assertTrue(cDTO.getTolerance() == 0.02);
	}

	@Test
	public void testGetCondimentsList() throws DALException {
	List<CondimentsDTO> ListCDTO = cDAO.getCondimentsList();
	assertTrue(ListCDTO.get(0).getId() == 7);
	assertTrue(ListCDTO.get(0).getName().equals("Salt"));
	assertTrue(ListCDTO.get(0).getTolerance() == 0.02);
	}

}
