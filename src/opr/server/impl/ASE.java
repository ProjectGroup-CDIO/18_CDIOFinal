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

public class ASE extends RemoteServiceServlet implements IASE, IASEService, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3486195199860414450L;
	
	private Socket sock;
	private BufferedReader in;
	private DataOutputStream out;
	private int brutto;
	private int tara;
	private int netto = (brutto - tara);
	
	private static String host = "10.16.161.152";
	private static int port = 8000;
	
	public ASE() throws UnknownHostException, IOException {
		connect();
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
		double weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return weight;
	}

	@Override
	public double getSIWeight() throws IOException {
		out.writeBytes("SI\r\n");
		String response = in.readLine();
		if(response.startsWith("ES")) {
			return -1;
		}
		double weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return weight;
		
	}

	@Override
	public void tara() throws Exception {
		getSWeight(); 
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

	public int getBrutto() {
		return brutto;
	}

	public void setBrutto(int brutto) {
		this.brutto = brutto;
	}

	public int getNetto() {
		return netto;
	}

	public void setNetto(int netto) {
		this.netto = netto;
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
