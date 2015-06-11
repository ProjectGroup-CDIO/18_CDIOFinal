package opr.test;

import java.io.IOException;
import java.net.UnknownHostException;

import opr.server.impl.ASE;
import opr.server.interfaces.IASE;

public class TesterNotJUnit {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		IASE ase = new ASE();
		ase.connect();
		ase.start();
	}
}
