package opr.server.interfaces;

import java.sql.SQLException;
import java.util.List;

import opr.shared.DALException;

public interface IMetaDAO {
	List<String> getTables() throws DALException, SQLException;
	
}
