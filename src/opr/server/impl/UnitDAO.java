package opr.server.impl;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.client.service.IDBService;
import opr.server.Connector;
import opr.server.interfaces.IUnitDAO;
import opr.shared.DALException;
import opr.shared.UnitDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UnitDAO extends RemoteServiceServlet implements IUnitDAO, IDBService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6897819696675555317L;

	public UnitDAO(){
		try {
			new Connector();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UnitDTO getCoin(double value) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM coins WHERE value = " + value);
		try {
			if (!rs.first()) throw new DALException("Mønt med værdi " + value + " findes ikke");
			return new UnitDTO(rs.getDouble("weight"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }	
	}

	public List<String> getTables() throws DALException {
		List<String> list = new ArrayList<String>();
		try{
			DatabaseMetaData md = Connector.getConnection().getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
				list.add(rs.getString(3));
			}
		}catch(SQLException e) {throw new DALException(e.getMessage()); }
		return list;  
	}

}

