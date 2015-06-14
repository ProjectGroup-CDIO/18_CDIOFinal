package opr.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

public class TestView extends Composite {
	VerticalPanel vPanel = new VerticalPanel();
	
	
	public TestView() {
		initWidget(vPanel);

		SliderBarHorizontal hBar = new SliderBarHorizontal();
		Label label = new Label("Hello");
		
	//	hBar.
		
		vPanel.add(label);
		vPanel.add(hBar);
	}
}
