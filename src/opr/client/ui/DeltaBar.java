package opr.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;

public class DeltaBar extends Composite {

	private double weigthIndicator = 201.0;
	private double lowerWeigthBound = 191.0;
	private double upperWeigthBound = 211.0;
	
	
	public DeltaBar(final MainView main){
			
		LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("layoutPanel0");
		initWidget(layoutPanel);
		layoutPanel.setSize("402px", "37px");
		
		LayoutPanel layoutPanel_1 = new LayoutPanel();
		layoutPanel_1.setStyleName("layoutPanel2");
		layoutPanel.add(layoutPanel_1);
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, weigthIndicator, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 0.0, Unit.PX, 37.0, Unit.PX);
		
		LayoutPanel layoutPanel_2 = new LayoutPanel();
		layoutPanel_2.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_2);
		layoutPanel.setWidgetLeftWidth(layoutPanel_2, lowerWeigthBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_2, 0.0, Unit.PX, 37.0, Unit.PX);
		
		LayoutPanel layoutPanel_3 = new LayoutPanel();
		layoutPanel_3.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_3);
		layoutPanel.setWidgetLeftWidth(layoutPanel_3, upperWeigthBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_3, 0.0, Unit.PX, 37.0, Unit.PX);
	
		
	}
	public double getWeigthIndicator() {
		return weigthIndicator;
	}
	public void setWeigthIndicator(double weigthIndicator) {
		this.weigthIndicator = weigthIndicator;
	}
	public double getLowerWiegthBound() {
		return lowerWeigthBound;
	}
	public void setLowerWiegthBound(double lowerWiegthBound) {
		this.lowerWeigthBound = lowerWiegthBound;
	}
	public double getUpperWiegthBound() {
		return upperWeigthBound;
	}
	public void setUpperWiegthBound(double upperWiegthBound) {
		this.upperWeigthBound = upperWiegthBound;
	}
}
