package opr.test;

import static org.junit.Assert.*;

import java.util.List;

import opr.server.impl.BatchDAO;
import opr.shared.BatchDTO;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BatchDAOTest {
	BatchDAO BDAO;
	
	@Before
	public void setUpBefore() throws Exception {
		BDAO = new BatchDAO();
	}

	@Test
	public void testGetBatch() throws Exception {
		BatchDTO bDTO =	BDAO.getBatch(1);
		assertTrue(bDTO.getBatchweight() == 1);
	}

	@Test
	public void testGetBatchList() throws Exception {
		List<BatchDTO> bListDTO = BDAO.getBatchList();
		assertTrue(bListDTO.get(0).getBatchweight() == 1);
	}

	

}
