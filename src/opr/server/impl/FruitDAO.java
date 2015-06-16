package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.client.service.IFruitService;
import opr.server.Connector;
import opr.server.interfaces.IFruitDAO;
import opr.shared.DALException;
import opr.shared.FruitDTO;
import opr.shared.OperatoerDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FruitDAO extends RemoteServiceServlet implements IFruitDAO, IFruitService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6897819696675555317L;

	public FruitDAO(){
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

	public FruitDTO getFruitInfo(String name) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM fruits WHERE name = '"+name+"'");
		try {
			if (!rs.first()) throw new DALException("frugten " + name + " findes ikke");
			return new FruitDTO(rs.getDouble("id"),rs.getString("name"), rs.getDouble("weight"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }	
	}
	
	public List<FruitDTO> getFruitList() throws DALException {
		List<FruitDTO> list = new ArrayList<FruitDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM fruits");
		try {
			while (rs.next()) 
			{
				list.add(new FruitDTO(rs.getDouble("id"),rs.getString("name"), rs.getDouble("weight"), rs.getDouble("tolerance")));
			}
		} catch(SQLException e) {
			throw new DALException("Kunne ikke få FruitList");
		}
		return list;
	}	
}
