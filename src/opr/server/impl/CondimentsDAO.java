package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.client.service.ICondimentsService;
import opr.server.Connector;
import opr.server.interfaces.ICondimentsDAO;
import opr.shared.DALException;
import opr.shared.CondimentsDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CondimentsDAO extends RemoteServiceServlet implements ICondimentsDAO, ICondimentsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6897819696675555317L;

	public CondimentsDAO(){
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

	public CondimentsDTO getCondimentsInfo(String name) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM condiments WHERE name = '"+name+"'");
		try {
			if (!rs.first()) throw new DALException("frugten " + name + " findes ikke");
			return new CondimentsDTO(rs.getDouble("id"),rs.getString("name"), rs.getDouble("weight"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }	
	}
	
	public List<CondimentsDTO> getCondimentsList() throws DALException {
		List<CondimentsDTO> list = new ArrayList<CondimentsDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM condiments");
		try {
			while (rs.next()) 
			{
				list.add(new CondimentsDTO(rs.getDouble("id"),rs.getString("name"), rs.getDouble("weight"), rs.getDouble("tolerance")));
			}
		} catch(SQLException e) {
			throw new DALException("Kunne ikke få CondimentsList");
		}
		return list;
	}	
}
