package opr.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import opr.server.impl.ASE;
import opr.server.interfaces.IASE;
import opr.shared.DALException;

public class TesterNotJUnit {
	
	public static void main(String[] args) throws UnknownHostException, IOException, DALException, SQLException {
		ASE ase = new ASE();
		System.out.println(ase.getSWeight());
		
		
//		IUnitDAO coin = new UnitDAO();
//		UnitDTO unit = coin.getCoinInfo(0.50);
//		System.out.println("weight per unit: "+unit.getWeightPerUnit());
//		System.out.println("tolerance: "+unit.getTolerance());
//		
//		List<String> list;
//		list = coin.getTables();
//		
//		for(String line : list) {
//			System.out.println(line);
//		}
	}
}
