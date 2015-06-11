package opr.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.UnknownHostException;

import opr.server.impl.ASE;
import opr.server.interfaces.IASE;

import org.junit.Before;
import org.junit.Test;

public class Tester {
	
	IASE ase = new ASE();

	@Before
	public void setUp() {
		try {
			ase.connect();
			System.out.println("Connection established");
		} catch (UnknownHostException e) {
			System.out.println("fejl1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("fejl2");
			e.printStackTrace();
		}
	}

	
//	@Test
//	public void testGetSWeight() throws IOException{
//		assertEquals(0.000, ase.getSWeight(), 0.001);
//	}
	
	@Test
	public void testSIWeight() throws IOException {
		assertEquals(0.000, ase.getSIWeight(), 6.000);
	}

}
