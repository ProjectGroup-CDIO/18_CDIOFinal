package opr.client.ui;

import opr.client.service.IASEServiceAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class TestView extends Composite {
	VerticalPanel vPanel = new VerticalPanel();
	
	public interface Callback {
		public IASEServiceAsync getASEService();
	}
	
	public TestView(final Callback c) {
		initWidget(vPanel);

		final Label label = new Label("Hello");
		Button btn = new Button("Click", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				c.getASEService().getSWeight(new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Hello everybody, message: "+caught.getMessage());				
					}

					@Override
					public void onSuccess(Double result) {
						label.setText("vægten står på "+ result);
//						Window.alert("Success everybody: "+result);	
					}
					
				});
				
			}
			
		});

		
		
		
		vPanel.add(label);
		vPanel.add(btn);
	}
}
