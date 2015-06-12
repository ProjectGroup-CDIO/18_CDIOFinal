package opr.client.service;

import java.sql.SQLException;
import java.util.List;

import opr.shared.DALException;
import opr.shared.UnitDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dbservice")
public interface IDBService extends RemoteService {
	
	UnitDTO getCoin(double value) throws DALException;
	List<String> getTables() throws DALException, SQLException;

}
