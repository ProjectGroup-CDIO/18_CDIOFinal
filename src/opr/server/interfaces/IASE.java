package opr.server.interfaces;

import java.io.IOException;
import java.net.UnknownHostException;

public interface IASE {
	
	void setWeightDisplay(String msg);
	void connect() throws UnknownHostException, IOException;
	double getSWeight() throws IOException;
	double getSIWeight() throws IOException;
	void tara() throws Exception;
	void start();
	
}
