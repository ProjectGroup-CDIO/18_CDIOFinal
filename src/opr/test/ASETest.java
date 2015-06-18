package opr.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.UnknownHostException;

import opr.server.impl.ASE;
import opr.shared.DALException;

import org.junit.BeforeClass;
import org.junit.Test;

public class ASETest {

	static ASE ase;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ase = new ASE();
		ase.connect();
	}


	@Test
	public void testConnect() throws UnknownHostException, IOException {
		assertTrue(ase.getSock().isConnected());
	}


	@Test
	public void testGetSWeight() throws IOException {
		double weight = ase.getSWeight();
		boolean weightBoo = false;
		
		if(weight >= 0){
			weightBoo = true;
		}
		
		assertTrue(weightBoo);
	}

	@Test
	public void testGetSIWeight() throws IOException, DALException {
		double weight = ase.getSIWeight();
		boolean weightBoo = false;
		
		if(weight >= 0){
			weightBoo = true;
		}
		
		assertTrue(weightBoo);
	}

	@Test
	public void testTara() throws Exception {
		boolean taraBoo = false;
		ase.getSWeight();
		ase.tara();
		
		if(ase.getNetto() == 0){
			taraBoo = true;
		}
		
		assertTrue(taraBoo);
	}

	
	@Test
	public void testReturnNetto() throws Exception {
		boolean nettoBoo = false;
		ase.setBrutto(4.75);
		ase.tara();
		double nettoTest = ase.returnNetto();
		
		if(nettoTest == 0){
			nettoBoo = true;
		}
		
		assertTrue(nettoBoo);
	}
}
