package opr.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import opr.server.impl.MySQLOperatoerDAO;
import opr.shared.DALException;
import opr.shared.OperatoerDTO;

import org.junit.Before;
import org.junit.Test;

public class MySQLOperatoerDAOTest {
	MySQLOperatoerDAO oprDAO;
	OperatoerDTO oprDTO;
	
	@Before
	public void setUpBefore() throws Exception {
		oprDAO = new MySQLOperatoerDAO();
	}

	@Test
	public void testGetOperatoer() throws DALException {
	oprDTO = oprDAO.getOperatoer(2);
	assertTrue(oprDTO.getOprNavn().equals("Thomas Liljegren"));
	}

	@Test
	public void testCreateOperatoer() throws DALException {
		oprDAO.createOperatoer(new OperatoerDTO(12,"Peter Petersen", "PP",
				"0611921234","PeterErSej",1));
		
		oprDTO = oprDAO.getOperatoer(12);
		assertTrue(oprDTO.getOprNavn().equals("Peter Petersen"));
		assertTrue(oprDTO.getPassword().equals("PeterErSej"));
		
	}

	@Test
	public void testUpdateOperatoer() throws DALException {
		oprDTO = oprDAO.getOperatoer(2);
		oprDTO.setOprNavn("Tohomas Liljegren");
		
		oprDAO.updateOperatoer(oprDTO);
		assertTrue(oprDAO.getOperatoer(2).getOprNavn().equals("Tohomas Liljegren"));
		oprDTO.setOprNavn("Thomas Liljegren");
		
		oprDAO.updateOperatoer(oprDTO);
	}

	@Test
	public void testGetOperatoerList() throws DALException {
		List<OperatoerDTO> oprDTOList = oprDAO.getOperatoerList();
		assertTrue(oprDTOList.get(1).getOprNavn().equals("Thomas Liljegren"));
	}

	@Test
	public void testLoginVerify() throws DALException {
		oprDTO = oprDAO.getOperatoer(2);
		oprDTO.setActive(1);
		oprDAO.updateOperatoer(oprDTO);
		
		assertTrue(oprDAO.loginVerify(2, "1234567").getOprNavn().equals(oprDTO.getOprNavn())); 
		
	}

	@Test
	public void testDeleteOperatoer() throws DALException {
		oprDTO = oprDAO.getOperatoer(2);
		oprDAO.deleteOperatoer(oprDTO);
		assertTrue(oprDAO.getOperatoer(2).getActive()==0);
		
	}

}
