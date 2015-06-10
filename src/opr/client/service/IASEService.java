package opr.client.service;

import java.io.IOException;
import java.net.UnknownHostException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("aseservice")
public interface IASEService extends RemoteService{
	
	void setWeightDisplay(String msg);
	void connect() throws UnknownHostException, IOException;
	int getSWeight();
	int getSIWeight();
	void tara();

}
