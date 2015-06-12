package opr.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import opr.server.impl.UnitDAO;
import opr.server.interfaces.IUnitDAO;
import opr.shared.DALException;
import opr.shared.UnitDTO;

public class TesterNotJUnit {
	
	public static void main(String[] args) throws UnknownHostException, IOException, DALException, SQLException {
//		IASE ase = new ASE();
//		ase.connect();
//		ase.start();
		
		
		IUnitDAO coin = new UnitDAO();
		UnitDTO unit = coin.getCoin(0.50);
		System.out.println("weight per unit: "+unit.getWeightPerUnit());
		System.out.println("tolerance: "+unit.getTolerance());
		
		List<String> list;
		list = coin.getTables();
		
		for(String line : list) {
			System.out.println(line);
		}
	}
}
