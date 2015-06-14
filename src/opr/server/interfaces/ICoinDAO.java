package opr.server.interfaces;

import opr.shared.CoinDTO;
import opr.shared.DALException;

public interface ICoinDAO {
	CoinDTO getCoinInfo(double value) throws DALException;
}
