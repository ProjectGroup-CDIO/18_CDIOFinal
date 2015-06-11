package opr.client.ui;

import opr.client.service.IASEServiceAsync;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WeightView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel1 = new HorizontalPanel();
	private HorizontalPanel hPanel2 = new HorizontalPanel();
	private Label weightLabel = new Label("Netto");
	private TextBox weightTxtBox = new TextBox(); 
	
	public interface Callback{
		public IASEServiceAsync getASEService();
	}
	
	public WeightView(final Callback c) {
	
		initWidget(this.vPanel);

		
		vPanel.add(weightLabel);
		final TextArea weightDisplay = new TextArea();
		weightDisplay.setPixelSize(290, 50);
		weightDisplay.setEnabled(false);
		vPanel.add(weightDisplay);
		
		vPanel.add(hPanel2);
		vPanel.add(hPanel1);
		
	
		
		//Weight-button, get
		
		Button getWeightButton = new Button("Get weight", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event){
				try {
					c.getASEService().getSWeight(new AsyncCallback<Double>(){

						@Override
						public void onFailure(Throwable caught) {
							//Window.alert("Server fejl!" + caught.getMessage());
						}

						@Override
						public void onSuccess(Double result) {
							weightDisplay.setText("" + result);
						}
		});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		hPanel1.add(getWeightButton);
		getWeightButton.setPixelSize( 100, 30);
		
		Button saveWeightButton = new Button("Save");
		hPanel1.add(saveWeightButton);
		saveWeightButton.setPixelSize(100, 30);
		
		Button taraWeightButton = new Button("Tara");
		hPanel1.add(taraWeightButton);
		taraWeightButton.setPixelSize(100, 30);
	}
}
