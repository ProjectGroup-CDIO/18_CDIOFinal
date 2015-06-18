package opr.server.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import opr.client.service.IASEService;
import opr.server.Connector;
import opr.server.interfaces.IASE;
import opr.shared.DALException;

public class ASE extends RemoteServiceServlet implements IASE, IASEService, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3486195199860414450L;
	
	private Socket sock;
	private BufferedReader in;
	private DataOutputStream out;
	private double brutto;
	private double tara;
	private double netto;
	

	//------------------------------------
	//Vægtens globale IP
	//62.79.16.17
	//
	//Vægtens lokale IP
	//169.254.2.2
	//
	//localhost IP
	//127.0.0.1
	//------------------------------------
	


	private static String host = "127.0.0.1";
	private static int port = 8000;
	
	public ASE() throws UnknownHostException, IOException {
//		connect();
	}
		
	@Override
	public void connect() throws UnknownHostException, IOException {
		
		if(sock!=null) return;
		
		sock = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new DataOutputStream(sock.getOutputStream());
		
	}

	@Override
	public void setWeightDisplay(String msg) {
		// løl	
	}

	@Override
	public double getSWeight() throws IOException {
		out.writeBytes("S\r\n");
		String response = in.readLine();
		brutto = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return returnNetto();
	}

	@Override
	public double getSIWeight() throws IOException, DALException {
		out.writeBytes("SI\r\n");
		String response = in.readLine();
		if(response.startsWith("ES")) {
			return -1;
		}else if(response.startsWith("S +")){
			throw new DALException("Weight Overload");
			
		}
		double weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return weight;
		
	}

	@Override
	public void tara() throws Exception {
		tara = brutto;	
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public double getBrutto() {
		return brutto;
	}

	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}

	public double getNetto() {
		return netto;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}
	
	public double returnNetto() {
		netto = (brutto - tara);
		return netto;
	}

	

	@Override
	public void run() {
		try {
			out.writeBytes("SIR\r\n");
			String response;
			double weight;
			while((response = in.readLine()) != null) {
				weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
				System.out.println(weight);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}




	@Override
	public void changeSocket(String Ip, int port) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
