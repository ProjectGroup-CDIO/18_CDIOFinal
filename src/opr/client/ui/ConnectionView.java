package opr.client.ui;

import opr.client.service.IASEServiceAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConnectionView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	HorizontalPanel hPanel = new HorizontalPanel();
	Label ipLabel = new Label("Ip adress");
	TextBox ipTextbox = new TextBox();
	Label portLabel = new Label("Port Number");
	TextBox portTextbox = new TextBox();
	Button connectButton = new Button("Connect");
	Button disConnectButton = new Button("Disconnect");
	Label colorLabel = new Label("");



	public interface Callback{
		public IASEServiceAsync getASEService();
	}
	public ConnectionView(final Callback c){
		this.initWidget(vPanel);

		vPanel.add(ipLabel);
		vPanel.add(ipTextbox);
		vPanel.add(portLabel);
		vPanel.add(portTextbox);
		vPanel.add(hPanel);
		hPanel.add(connectButton);
		hPanel.add(disConnectButton);
		hPanel.add(colorLabel);
		
		
		Button btnOne = new Button("Connect", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			c.getASEService().changeSocket(ipTextbox.getText(), Integer.parseInt(portTextbox.getText()),new AsyncCallback<Void>(){

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
				Window.alert("Indtagsningfejl"+caught.getMessage());
//					ipTextbox.setText("");
//					portTextbox.setText("");
					colorLabel.setStyleName("Fail");
				}

				@Override
				public void onSuccess(Void result) {
					// TODO Auto-generated method stub
					colorLabel.setStyleName("Successful");
					
				}
				
			});
				
			}
		});


	}
}