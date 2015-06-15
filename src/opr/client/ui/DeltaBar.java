package opr.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;

public class DeltaBar extends Composite {

	private double weigthIndicator = 201.0;
	private double lowerWiegthBound = 191.0;
	private double upperWiegthBound = 211.0;
	private LayoutPanel layoutPanel = new LayoutPanel();
	HorizontalPanel hPanel = new HorizontalPanel();
	Label l1 = new Label("Y");
	Label l2 = new Label("X");
	
private	LayoutPanel layoutPanel_1 = new LayoutPanel();
private	LayoutPanel layoutPanel_2 = new LayoutPanel();
private	LayoutPanel layoutPanel_3 = new LayoutPanel();
	
	public interface Callback{
		
	}
	
	public DeltaBar(final Callback c){
		initWidget(hPanel);
		hPanel.add(l1);
		hPanel.add(layoutPanel);
		hPanel.add(l2);
		layoutPanel.setStyleName("layoutPanel0");
		layoutPanel.setSize("402px", "37px");
		
		layoutPanel_1.setStyleName("layoutPanel2");
		layoutPanel.add(layoutPanel_1);
		layoutPanel_2.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_2);
		
		
		layoutPanel_3.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_3);
	
		
	}
	public double getWeigthIndicator() {
		return weigthIndicator;
	}
	public void setWeigthIndicator(double weigthIndicator) {
		this.weigthIndicator = weigthIndicator;
	}
	public double getLowerWiegthBound() {
		return lowerWiegthBound;
	}
	public void setLowerWiegthBound(double lowerWiegthBound) {
		this.lowerWiegthBound = lowerWiegthBound;
	}
	public double getUpperWiegthBound() {
		return upperWiegthBound;
	}
	public void setUpperWiegthBound(double upperWiegthBound) {
		this.upperWiegthBound = upperWiegthBound;
	}
	public void deltaBarData(double z, double q, double tolerance){
		
		double lower = q-q*(tolerance);
		double upper = q+q*(tolerance);
		double x = q+q*(tolerance*3);
		double y = q-q*(tolerance*3);
		l1.setText(Double.toString(y));
		weigthIndicator = (x/100)*4*z;
		lowerWiegthBound = (x/100)*4*lower;
		upperWiegthBound = (x/100)*4*upper;
		l2.setText(Double.toString(x));
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, weigthIndicator, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_2, lowerWiegthBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_2, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_3, upperWiegthBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_3, 0.0, Unit.PX, 37.0, Unit.PX);
	}
}
