package opr.client.ui;

import opr.client.service.IASEServiceAsync;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConnectionView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	HorizontalPanel hPanel = new HorizontalPanel();
	Label IpLabel = new Label("Ip adress");
	TextBox IpTextbox = new TextBox();
	Label PortLabel = new Label("Port Number");
	TextBox PortTextbox = new TextBox();
	Button ConnectButton = new Button("Connect");
	Button DisConnectButton = new Button("Disconnect");
	
	
	
	public interface Callback{
		public IASEServiceAsync getASEService();
}
	public ConnectionView(final Callback c){
		this.initWidget(vPanel);
		
		vPanel.add(IpLabel);
		vPanel.add(IpTextbox);
		vPanel.add(PortLabel);
		vPanel.add(PortTextbox);
		hPanel.add(ConnectButton);
		hPanel.add(DisConnectButton);
		
		
	}
}