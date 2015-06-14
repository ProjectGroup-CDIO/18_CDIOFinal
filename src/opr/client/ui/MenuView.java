package opr.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();


	public MenuView(final MainView main){
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);

		//-----------------------------------------------------
		//add-button, opens AddView when pressed
		//-----------------------------------------------------

		Button addBtn = new Button("ADD", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {

				try {
					main.openAddView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//list-button, opens ListView when pressed
		//-----------------------------------------------------

		Button listBtn = new Button("LIST", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openListView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//logout-button, reopens LoginView when pressed
		//-----------------------------------------------------

		Button logoutBtn = new Button("LOGOUT", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				main.openLoginView();
			}
		});

		//-----------------------------------------------------
		//weight-button, opens WeightView when pressed
		//-----------------------------------------------------

		Button weightBtn = new Button("WEIGHT", new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openWeightView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//unit-weight-button, opens StykWeight when pressed
		//-----------------------------------------------------

		Button unitWBtn = new Button("UNIT", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {

				try {
					main.openStykWeight();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


		//-----------------------------------------------------
		//delta-weight-button, opens DeltaWeightView when pressed
		//-----------------------------------------------------

		Button deltaWBtn = new Button("Delta Weight", new ClickHandler(){
			@Override
			public void onClick(ClickEvent even){
				try{
					main.openDeltaWeightView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//coin-weight-button, opens CoinWeight when pressed
		//-----------------------------------------------------

		Button coinBtn = new Button("COIN", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event){
				try{
					main.openCoinWeight();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//-----------------------------------------------------
		//connectionView-button, opens Connection when pressed
		//-----------------------------------------------------
		
		Button connectionBtn = new Button("Connection", new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openConnetion();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
		
		Button testBtn = new Button("ClickMe!", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openTestView();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});

		//-----------------------------------------------------
		//adding buttons to vertical panel, setting pixel size
		//-----------------------------------------------------

		weightBtn.setPixelSize( 100, 30);
		unitWBtn.setPixelSize( 100, 30);
		deltaWBtn.setPixelSize( 100, 30);
		coinBtn.setPixelSize(100, 30);

		listBtn.setPixelSize(100, 30);
		addBtn.setPixelSize(100, 30);
		connectionBtn.setPixelSize(100, 30);
		logoutBtn.setPixelSize(100, 30);

		vPanel.add(weightBtn);
		vPanel.add(unitWBtn);
		vPanel.add(deltaWBtn);
		vPanel.add(coinBtn);
		vPanel.add(listBtn);
		vPanel.add(addBtn);
		vPanel.add(connectionBtn);
		vPanel.add(logoutBtn);
		vPanel.add(testBtn);
	}
}



