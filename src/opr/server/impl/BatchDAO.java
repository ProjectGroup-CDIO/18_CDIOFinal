package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.client.service.IBatchService;
import opr.server.Connector;
import opr.server.interfaces.IBatchDAO;
import opr.shared.BatchDTO;
import opr.shared.CoinDTO;
import opr.shared.DALException;
import opr.shared.LogDTO;
import opr.shared.OperatoerDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BatchDAO extends RemoteServiceServlet implements IBatchDAO, IBatchService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5147045543911648126L;

	public BatchDAO() {
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

	@Override
	public BatchDTO getBatch(int batchid) throws Exception {
		ResultSet rs = Connector.doQuery("SELECT * FROM batch WHERE batch_id = " + batchid);
		try {
			if (!rs.first()) throw new DALException("Batch med id " + batchid + " findes ikke");
			return new BatchDTO(rs.getInt("batch_id"), rs.getInt("raavare_id"), rs.getString("raavare_navn"),
					rs.getDouble("batchweight"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException(e.getMessage()); }
	}

	@Override
	public List<BatchDTO> getBatchList() throws Exception {
		List<BatchDTO> list = new ArrayList<BatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM batch");
		try {
			while (rs.next()) 
			{
				list.add(new BatchDTO(rs.getInt("batch_id"), rs.getInt("raavare_id"), rs.getString("raavare"),
						rs.getDouble("batchweight"), rs.getDouble("tolerance")));
			}
		} catch(SQLException e) {
			throw new DALException("Kunne ikke få BatchList: " + e.getMessage());
		}
		return list;
	}

	@Override
	public void updateLog(LogDTO logDTO) throws Exception {
		Connector.doUpdate(
				"INSERT INTO vejelog (log_id, opr_id, batch_id, afvigelse) VALUES " +
						"("+logDTO.getLog_id()+", "+logDTO.getOpr_id()+", "+logDTO.getBatch_id()+", "+logDTO.getAfvigelse()+")"
				);
	}

	public void createOperatoer(OperatoerDTO opr) throws DALException {		
		Connector.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, aktiv) VALUES " +
						"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
						opr.getCpr() + "', '" + opr.getPassword() + "', "+opr.getActive()+")"
				);
	}

}
