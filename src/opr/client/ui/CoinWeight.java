package opr.client.ui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class CoinWeight extends Composite {
	
	private FlexTable ft;
	
	public CoinWeight() {
		initWidget(ft);
		FlexCellFormatter ftf = ft.getFlexCellFormatter();
		
		Label wLabel = new Label("Weight");
		TextBox wText = new TextBox();
		wText.setEnabled(false);
		
		Label stkLabel = new Label("# of items");
		TextBox stkText = new TextBox();
		stkText.setEnabled(false);
		
		Button btn50 = new Button("50 øre");
		Button btn1 = new Button("1 kr");
		Button btn2 = new Button("2 kr");
		Button btn5 = new Button("5 kr");
		Button btn10 = new Button("10 kr");
		Button btn20 = new Button("20 kr");
		Button btnback = new Button("Go back");
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(btn50);
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		buttonPanel.add(btn5);
		buttonPanel.add(btn10);
		buttonPanel.add(btn20);
		
		ft.setBorderWidth(1);
		ft.setWidget(1, 1, wLabel);
		ft.setWidget(2, 1, wText);
		ft.setWidget(3, 1, stkLabel);
		ft.setWidget(4, 1, stkText);
		ft.setWidget(5, 1, buttonPanel);
		
		
	}

	

}
