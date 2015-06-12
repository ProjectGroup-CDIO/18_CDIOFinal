package opr.server.interfaces;

import opr.shared.DALException;
import opr.shared.UnitDTO;

public interface IUnitDAO {
	UnitDTO getCoin(double value) throws DALException;
}
