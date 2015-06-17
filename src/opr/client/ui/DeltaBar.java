package opr.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;

public class DeltaBar extends Composite {

	private double weightIndicator = 201.0;
	private double lowerWeightBound = 191.0;
	private double upperWeightBound = 211.0;
	private static final double TOTALPIXELS = 402;
	private static final double MIDDLE = TOTALPIXELS/2;
	
	

	private LayoutPanel layoutPanel = new LayoutPanel();
	HorizontalPanel hPanel = new HorizontalPanel();
	Label l1 = new Label("Y");
	Label l2 = new Label("X");

	private	LayoutPanel layoutPanel_1 = new LayoutPanel();
	private	LayoutPanel layoutPanel_2 = new LayoutPanel();
	private	LayoutPanel layoutPanel_3 = new LayoutPanel();



	public DeltaBar(){
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
	public double getWeightIndicator() {
		return weightIndicator;
	}
	public void setWeightIndicator(double weigthIndicator) {
		this.weightIndicator = weigthIndicator;
	}
	public double getLowerWeightBound() {
		return lowerWeightBound;
	}
	public void setLowerWeightBound(double lowerWiegthBound) {
		this.lowerWeightBound = lowerWiegthBound;
	}
	public double getUpperWeightBound() {
		return upperWeightBound;
	}
	public void setUpperWeightBound(double upperWiegthBound) {
		this.upperWeightBound = upperWiegthBound;
	}
	public void deltaBarData(double z, double q, double tolerance){
		
		double lower = q-q*(tolerance);
		double upper = q+q*(tolerance);

		double x = q+q*(tolerance*3);
		double y = q-q*(tolerance*3);
		
		weightIndicator = (x-y/100)*4*z;
		
		lowerWeightBound = ((x-y/100)*4)*lower;
		upperWeightBound = ((x-y/100)*4)*upper;
		
		l1.setText(Double.toString(y));
		l2.setText(Double.toString(x));
		//Window.alert(""+weigthIndicator + ":"+z + ":" + q +":" + tolerance);
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, weightIndicator, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_2, lowerWeightBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_2, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_3, upperWeightBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_3, 0.0, Unit.PX, 37.0, Unit.PX);

	}
	
	/**
	 * 
	 * @param w_input SI-input
	 * @param w_batch batchvægt
	 * @param tolerance	batchtolerance
	 */

	public void deltaBarData2(double w_input, double w_batch, double tolerance){

		double lower_w;
		double upper_w;

		double y = w_batch-(2*w_batch*tolerance);
		double x = w_batch+(2*w_batch*tolerance);
		
		double pxPrUnit = TOTALPIXELS/(x-y);
		
		lower_w = w_batch-(w_batch*tolerance);
		upper_w = w_batch+(w_batch*tolerance);
		
		lowerWeightBound = (lower_w - y)*pxPrUnit;
		upperWeightBound = (upper_w - y)*pxPrUnit;
		
		if(w_input < y) weightIndicator = (y - y) * pxPrUnit;
		else if(w_input > x) weightIndicator = (x - y) * pxPrUnit;
		else weightIndicator = (w_input - y) * pxPrUnit;
		
		l1.setText(Double.toString(y));
		l2.setText(Double.toString(x));
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, weightIndicator, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_2, lowerWeightBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_2, 0.0, Unit.PX, 37.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(layoutPanel_3, upperWeightBound, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_3, 0.0, Unit.PX, 37.0, Unit.PX);

		System.out.println("%%%%555->>>> pxPrUnit: "+pxPrUnit);
		System.out.println("#######---> lower: "+lower_w);
		System.out.println("#######---> upper: "+ upper_w);
	}
	
	public void setIndicator(double w_input, double leftborder, double pxprkg) {
		weightIndicator = (w_input - leftborder) * pxprkg;
	}
}
