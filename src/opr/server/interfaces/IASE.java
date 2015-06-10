package opr.server.interfaces;

import java.io.IOException;
import java.net.UnknownHostException;

public interface IASE {
	
	void setWeightDisplay(String msg);
	void connect() throws UnknownHostException, IOException;
	int getSWeight();
	int getSIWeight();
	void tara();
	
}
