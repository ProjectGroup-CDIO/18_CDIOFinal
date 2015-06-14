package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import opr.server.Connector;
import opr.server.interfaces.ICoinDAO;
import opr.shared.CoinDTO;
import opr.shared.DALException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CoinDAO extends RemoteServiceServlet implements ICoinDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6897819696675555317L;

	public CoinDAO(){
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

	public CoinDTO getCoinInfo(double value) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM coins WHERE value = " + value);
		try {
			if (!rs.first()) throw new DALException("Mønt med værdi " + value + " findes ikke");
			return new CoinDTO(rs.getDouble("value"), rs.getDouble("weight"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }	
	}

	
}
