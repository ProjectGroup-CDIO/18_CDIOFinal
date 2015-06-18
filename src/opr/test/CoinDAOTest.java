package opr.test;

import static org.junit.Assert.*;

import java.util.List;

import opr.server.impl.BatchDAO;
import opr.server.impl.CoinDAO;
import opr.shared.CoinDTO;
import opr.shared.DALException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinDAOTest {
	CoinDAO cDAO;
	@Before
	public void setUpBefore() throws Exception {
		cDAO = new CoinDAO();
	}

	@Test
	public void testGetCoinInfo() throws DALException {
		CoinDTO cDTO=cDAO.getCoinInfo(1);
		assertTrue(cDTO.getWeightPerUnit()> 0);
	}

	@Test
	public void testGetCoinList() throws DALException {
		List<CoinDTO> cDTO=cDAO.getCoinList();
		assertTrue(cDTO.get(0).getWeightPerUnit()> 0);
	}

}
