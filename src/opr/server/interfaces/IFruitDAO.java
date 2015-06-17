package opr.server.interfaces;

import java.util.List;

import opr.shared.FruitDTO;
import opr.shared.DALException;

public interface IFruitDAO {
	FruitDTO getFruitInfo(String name) throws DALException;
	List<FruitDTO> getFruitList() throws DALException;
}
