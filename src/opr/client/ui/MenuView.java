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
		
		Button logoutBtn = new Button("LOGOUT", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
				main.openLoginView();
			}
			
		});
		
		Button weightBtn1 = new Button("WEIGHT", new ClickHandler(){
			
			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openWeightView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
		

		Button deltaBtn = new Button("Advanced weight", new ClickHandler(){
			
			@Override
			public void onClick(ClickEvent event) {
				try {
					main.openDeltaWeightView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Button testBtn2 = new Button("Coins", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
				try {
					main.openCoinWeight();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
		
		
		Button testBtn3 = new Button("N/A");
		
		
		
		
		weightBtn1.setPixelSize( 100, 30);
		deltaBtn.setPixelSize( 100, 30);
		testBtn3.setPixelSize( 100, 30);
		listBtn.setPixelSize(100, 30);
		addBtn.setPixelSize(100, 30);
		logoutBtn.setPixelSize(100, 30);
		
		
		vPanel.add(weightBtn1);
		vPanel.add(deltaBtn);
		vPanel.add(testBtn3);
		vPanel.add(listBtn);
		vPanel.add(addBtn);
		vPanel.add(logoutBtn);
		
		
		
		
	}
}



