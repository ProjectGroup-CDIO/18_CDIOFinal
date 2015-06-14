package opr.client.service;

import java.util.List;

import opr.shared.DALException;
import opr.shared.UnitDTO;

>>>>>>> branch 'master' of https://github.com/ProjectGroup-CDIO/18_CDIOFinal.git
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dbservice")
public interface IDBService extends RemoteService {
	
	UnitDTO getCoin(double value) throws DALException;
	List<String> getTables() throws DALException;

}
