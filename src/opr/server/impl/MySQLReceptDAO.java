package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.server.Connector;
import opr.server.interfaces.ReceptDAO;
import opr.shared.DALException;
import opr.shared.ReceptDTO;


public class MySQLReceptDAO implements ReceptDAO {

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recept WHERE recept_id = " + receptId);
		try {
			if (!rs.first()) throw new DALException("Recept med recept_id: " + receptId + " findes ikke");
			return new ReceptDTO(rs.getInt("recept_id"),rs.getString("recept_navn"));
		} catch (SQLException e) {
			throw new DALException("SQL Error");
		}	
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recept");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptDTO(rs.getInt("recept_id"),rs.getString("recept_navn")));
			}
		}
		catch (SQLException e) { throw new DALException(e.getMessage()); }
		return list;

	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(
				"INSERT INTO recept(recept_id, recept_navn) VALUES " +
				"("+recept.getReceptId()+", '"+recept.getReceptNavn()+"')"
			);
		
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(
				"UPDATE recept SET  recept_id = " + recept.getReceptId() + ", recept_navn = "+recept.getReceptNavn()+
				" WHERE recept_id = "+recept.getReceptId()
		);
	}
	

}
