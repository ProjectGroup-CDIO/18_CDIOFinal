package opr.client.ui;

import opr.client.service.IASEServiceAsync;
import opr.client.ui.WeightView.Callback;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeltaWeightView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel1 = new HorizontalPanel();
	private HorizontalPanel hPanel2 = new HorizontalPanel();
	private HorizontalPanel hPanel3 = new HorizontalPanel();
	FlexTable ft = new FlexTable();
	private Label viewInfo = new Label("Delta Weight");
	
	private Label prdName = new Label("Product Name");
	private Label prdNr = new Label("Product ID");
	private Label wData = new Label("Weight data");
	
	private TextBox productName = new TextBox(); 
	private TextBox productNr = new TextBox();
	private TextBox weightData = new TextBox();
	
	
	
	public interface Callback{
		public IASEServiceAsync getASEService();
	}
	
	public DeltaWeightView(final Callback c) {
		initWidget(vPanel);
		
		vPanel.add(hPanel1);
		hPanel1.add(viewInfo);
		
		vPanel.add(ft);
		ft.setWidget(0, 0, prdName);
		ft.setWidget(0, 1, prdNr);		
		ft.setWidget(0, 2, wData);
		ft.setWidget(1, 0, productName);
		ft.setWidget(1, 1, productNr);
		ft.setWidget(1, 2, weightData);
		
		
		
		
	}
}
