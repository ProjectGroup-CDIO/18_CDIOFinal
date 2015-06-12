package opr.test;

import java.io.IOException;
import java.net.UnknownHostException;

import opr.server.impl.ASE;
import opr.server.impl.UnitDAO;
import opr.server.interfaces.IASE;
import opr.server.interfaces.IUnitDAO;
import opr.shared.DALException;
import opr.shared.UnitDTO;

public class TesterNotJUnit {
	
	public static void main(String[] args) throws UnknownHostException, IOException, DALException {
//		IASE ase = new ASE();
//		ase.connect();
//		ase.start();
		
		
		IUnitDAO coin = new UnitDAO();
		UnitDTO unit = coin.getCoin(0.50);
		System.out.println("weight per unit: "+unit.getWeightPerUnit());
		System.out.println("tolerance: "+unit.getTolerance());
	}
}
