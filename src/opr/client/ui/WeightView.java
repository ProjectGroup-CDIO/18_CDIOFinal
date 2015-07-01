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
import com.google.gwt.user.client.ui.VerticalPanel;

public class WeightView extends Composite {


	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel1 = new HorizontalPanel();
	private Label weightLabel = new Label("Netto"); 

	public interface Callback{
		public IASEServiceAsync getASEService();
	}

	public WeightView(final Callback c) {

		/**
		 * Initialiserer paneler, og tilføjer andre paneler til det initialiserede panel
		 */

		initWidget(this.vPanel);
		weightLabel.addStyleName("weightLabel");
		vPanel.add(weightLabel);
		vPanel.add(hPanel1);
		

		/**
		 * "Get weight"-knappen. 
		 * Knappen oprettes, og der tilføjes en ClickHandler
		 * Der laves CallBack til ASEService, og herefter kan getSWeight() hentes
		 * Knappen tilføjes til et panel, og størrelse og border sættes
		 */

		Button getWeightButton = new Button("Get weight", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event){
				try {
					c.getASEService().getSWeight(new AsyncCallback<Double>(){

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("An error occured: " + caught.getMessage());
						}

						@Override
						public void onSuccess(Double result) {
							weightLabel.setText("Netto: " + result + " kg");
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		hPanel1.add(getWeightButton);
		getWeightButton.setPixelSize( 105, 30);
		hPanel1.setBorderWidth(3);
		
		

		/**
		 * "Get tara"-knappen
		 * Knappen oprettes, og der tilføjes ClickHandler
		 * CallBack til ASEService, og udfører tara()-metoden
		 * Knappen tilføjes til panel, og størrelse/border sættes
		 */

		Button taraWeightButton = new Button("Tara", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event){
				try {
					c.getASEService().tara(new AsyncCallback<Void>(){
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("An error occured: " + caught.getMessage());
						}
						@Override
						public void onSuccess(Void result) {
							c.getASEService().getSWeight(new AsyncCallback<Double>(){

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("An error occured: " + caught.getMessage());
								}

								@Override
								public void onSuccess(Double result) {
									weightLabel.setText("Netto: " + result + " kg");
								}
							});

						}
					}
							); 
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		hPanel1.add(taraWeightButton);
		taraWeightButton.setPixelSize(105, 30);
		hPanel1.setBorderWidth(3);

	}
}
