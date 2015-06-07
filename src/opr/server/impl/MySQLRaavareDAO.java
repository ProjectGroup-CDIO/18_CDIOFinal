package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.server.Connector;
import opr.server.interfaces.RaavareDAO;
import opr.shared.DALException;
import opr.shared.RaavareDTO;


public class MySQLRaavareDAO implements RaavareDAO{

	@Override
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavare WHERE raavare_id = " + raavareId);
		try {
			if (!rs.first()) throw new DALException("Raavaren " + raavareId + " findes ikke");
			return new RaavareDTO (rs.getInt("raavre_id"), rs.getString("raavare_navn"), rs.getString("leverandoer"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }

	}

	@Override
	public List<RaavareDTO> getRaavareList() throws DALException {
		List<RaavareDTO> list = new ArrayList<RaavareDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavare");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareDTO(rs.getInt("raavre_id"), rs.getString("raavare_navn"), rs.getString("leverandoer")));
			}
		}
		catch (SQLException e) { throw new DALException(e.getMessage()); }
		return list;
	}


	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException {
		Connector.doUpdate(
				"INSERT INTO raavare(raavare_id, raavare_navn, leverandoer) VALUES " +
				"(" + raavare.getRaavareId() + ", '" + raavare.getRaavareNavn() + "', '" + raavare.getLeverandoer() + "')");
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {
		Connector.doUpdate(
				"UPDATE raavare SET  raavare_id = " + raavare.getRaavareId() + ", raavare_navn =  '" + raavare.getRaavareNavn() + 
				"', leverandoer = '" + raavare.getLeverandoer() + "',  WHERE raavare_id = " + raavare.getRaavareId());
	}
}
