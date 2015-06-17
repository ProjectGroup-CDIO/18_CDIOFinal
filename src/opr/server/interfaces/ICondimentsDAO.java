package opr.server.interfaces;

import java.util.List;

import opr.shared.CondimentsDTO;
import opr.shared.DALException;

public interface ICondimentsDAO {
	CondimentsDTO getCondimentsInfo(String name) throws DALException;
	List<CondimentsDTO> getCondimentsList() throws DALException;
}
