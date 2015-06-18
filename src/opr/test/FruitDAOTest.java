package opr.test;

import static org.junit.Assert.*;

import java.util.List;

import opr.server.impl.CondimentsDAO;
import opr.server.impl.FruitDAO;
import opr.shared.DALException;
import opr.shared.FruitDTO;

import org.junit.Before;
import org.junit.Test;

public class FruitDAOTest {

	FruitDAO fDAO;

	@Before
	public void setUpBefore() throws Exception {
		fDAO = new FruitDAO();
	}

	@Test
	public void testGetFruitInfo() throws DALException {
		FruitDTO fDTO = fDAO.getFruitInfo("Apple");
		assertTrue(fDTO.getId() == 1);
		assertTrue(fDTO.getWeightPerUnit() == 0.12);
	}

	@Test
	public void testGetFruitList() throws DALException {
		List<FruitDTO> listFDTO = fDAO.getFruitList();
		assertTrue(listFDTO.get(0).getId() ==1);
		assertTrue(listFDTO.get(1).getName().equals("Pear"));
	}

}
