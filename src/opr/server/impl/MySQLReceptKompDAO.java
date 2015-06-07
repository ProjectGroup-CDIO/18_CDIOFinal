package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.server.Connector;
import opr.server.interfaces.ReceptKompDAO;
import opr.shared.DALException;
import opr.shared.ReceptKompDTO;


public class MySQLReceptKompDAO implements ReceptKompDAO {

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recept WHERE recept_id = " + receptId + " AND raavare_id = "+raavareId);
		try {
			if (!rs.first()) throw new DALException("Receptkomponent med recept_id: " + receptId + " og raavare_id: " + raavareId + " findes ikke");
			return new ReceptKompDTO(rs.getInt("recept_id"),rs.getInt("raavare_id"),
					rs.getDouble("nom_netto"),rs.getDouble("tolerance"));
		} catch (SQLException e) {
			throw new DALException("SQL Error");
		}	
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = "+receptId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("recept_id"),rs.getInt("raavare_id"),
						rs.getDouble("nom_netto"),rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e.getMessage()); }
		return list;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("recept_id"),rs.getInt("raavare_id"),
						rs.getDouble("nom_netto"),rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e.getMessage()); }
		return list;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent)	throws DALException {
		Connector.doUpdate(
				"INSERT INTO receptkomponent(recept_id, raavare_id, nom_netto, tolerance) VALUES " +
				"("+receptkomponent.getReceptId()+", "+receptkomponent.getRaavareId()+", "
						+receptkomponent.getNomNetto()+", "+receptkomponent.getTolerance()
			);
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent)	throws DALException {
		Connector.doUpdate(
				"UPDATE receptkomponent SET  recept_id = " + receptkomponent.getReceptId() + ", raavare_id = "+receptkomponent.getRaavareId()+
				", nom_netto = "+receptkomponent.getNomNetto()+", tolerance = "+receptkomponent.getTolerance()+
				" WHERE recept_id = "+receptkomponent.getReceptId()+" AND raavare_id = "+receptkomponent.getRaavareId()
		);
	}

}
