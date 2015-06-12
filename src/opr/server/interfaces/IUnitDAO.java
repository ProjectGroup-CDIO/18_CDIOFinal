package opr.server.interfaces;

import java.sql.SQLException;
import java.util.List;

import opr.shared.DALException;
import opr.shared.UnitDTO;

public interface IUnitDAO {
	UnitDTO getCoin(double value) throws DALException;
	List<String> getTables() throws DALException, SQLException;
}
