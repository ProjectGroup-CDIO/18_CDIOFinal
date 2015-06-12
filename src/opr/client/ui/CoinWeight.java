package opr.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class CoinWeight extends Composite {
	private FlexTable ft = new FlexTable();
	Label wLabel = new Label("Weight");
	TextBox wText = new TextBox();
	Label stkLabel = new Label("# of items");
	TextBox stkText = new TextBox();
	Button btnCoins = new Button("Coins");
	Button btnBills = new Button("Bills");
	Button btnFruit = new Button("Fruit");
	Button btnCondiments = new Button("Condiments");
	Button btn50 = new Button("50 øre");
	Button btn1 = new Button("1 kr");
	Button btn2 = new Button("2 kr");
	Button btn5 = new Button("5 kr");
	Button btn10 = new Button("10 kr");
	Button btn20 = new Button("20 kr");
	Button btn50r = new Button("50 kr");
	Button btn100 = new Button("100 kr");
	Button btn200 = new Button("200 kr");
	Button btn500 = new Button("500 kr");
	Button btn1000 = new Button("1000 kr");
	Button btnBanana = new Button("Banana");
	Button btnStrawberry = new Button("Strawberry");
	Button btnPineapple = new Button("Pineapple");
	Button btnKiwi = new Button("Kiwi");
	Button btnMango = new Button("Mango");
	Button btnSugar = new Button("Sugar");
	Button btnPepper = new Button("Pepper");
	Button btnSalt = new Button("Salt");
	Button btnChemicalX = new Button("Chemical X");	
	
	public CoinWeight(final MainView mainView){
		this.initWidget(ft);
		//FlexCellFormatter ftf = ft.getFlexCellFormatter();
		
		wText.setEnabled(false);
		stkText.setEnabled(false);
				
		ft.setBorderWidth(5);
		ft.setWidget(1, 1, wLabel);
		ft.setWidget(2, 1, wText);
		ft.setWidget(3, 1, stkLabel);
		ft.setWidget(4, 1, stkText);
		ft.setWidget(1, 0, btnCoins);
		ft.setWidget(2, 0, btnBills);
		ft.setWidget(3, 0, btnFruit);
		ft.setWidget(4, 0, btnCondiments);
		
		btnCoins.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					HorizontalPanel buttonPanel = new HorizontalPanel();
					buttonPanel.add(btn50);
					buttonPanel.add(btn1);
					buttonPanel.add(btn2);
					buttonPanel.add(btn5);
					buttonPanel.add(btn10);
					buttonPanel.add(btn20);
					ft.setWidget(5, 1, buttonPanel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBills.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					HorizontalPanel buttonPanel = new HorizontalPanel();
					buttonPanel.add(btn50r);
					buttonPanel.add(btn100);
					buttonPanel.add(btn200);
					buttonPanel.add(btn500);
					buttonPanel.add(btn1000);
					ft.setWidget(5, 1, buttonPanel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFruit.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					ft.clearCell(5, 1);
					HorizontalPanel buttonPanel = new HorizontalPanel();
					buttonPanel.add(btnBanana);
					buttonPanel.add(btnStrawberry);
					buttonPanel.add(btnPineapple);
					buttonPanel.add(btnKiwi);
					buttonPanel.add(btnMango);
					ft.setWidget(5, 1, buttonPanel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCondiments.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					ft.clearCell(5, 1);
					HorizontalPanel buttonPanel = new HorizontalPanel();
					buttonPanel.add(btnSugar);
					buttonPanel.add(btnPepper);
					buttonPanel.add(btnSalt);
					buttonPanel.add(btnChemicalX);
					ft.setWidget(5, 1, buttonPanel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
