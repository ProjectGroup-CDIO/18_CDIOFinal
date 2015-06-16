package opr.client.ui;

import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.IBatchServiceAsync;
import opr.client.service.ICoinServiceAsync;
import opr.client.service.IFruitServiceAsync;
import opr.client.service.IMetaServiceAsync;
import opr.client.service.IOperatoerServiceAsync;
import opr.client.ui.DeltaWeightView.Callback;
import opr.shared.CoinDTO;
import opr.shared.FruitDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class StykWeight extends Composite {
	private FlexTable ft = new FlexTable();
	private Label unitLabel = new Label("Unit-weight");
	private VerticalPanel vPanel = new VerticalPanel();
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
	private List<CoinDTO> coinList;
	private List<FruitDTO> fruitList;
	
	public interface Callback{
		public IASEServiceAsync getASEService();
		public IOperatoerServiceAsync getService();
		public IMetaServiceAsync getMetaService();
		public ICoinServiceAsync getCoinService();
		public IFruitServiceAsync getFruitService();
	}
	
	public StykWeight(final Callback c){
		this.initWidget(vPanel);
		 unitLabel.addStyleName("unitLabel");
		 vPanel.add(unitLabel);
		 vPanel.add(ft);
		 
		 btnCoins.setPixelSize(100, 30);
		 btnBills.setPixelSize(100, 30);
		 btnFruit.setPixelSize(100, 30);
		 btnCondiments.setPixelSize(100, 30);
		
		//FlexCellFormatter ftf = ft.getFlexCellFormatter();
		
		wText.setEnabled(false);
		stkText.setEnabled(false);
				
		ft.setBorderWidth(5);
		ft.setWidget(1, 1, wLabel);
		ft.setWidget(2, 1, wText);
		ft.setWidget(3, 1, stkLabel);
		ft.setWidget(4, 1, stkText);
		ft.setWidget(1, 0, btnCoins);
		ft.setWidget(2, 0, btnFruit);
		ft.setWidget(3, 0, btnCondiments);
		
		btnCoins.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {
					coinCellView(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFruit.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				try {c.getASEService().getSWeight(new AsyncCallback<Double>(){

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("An error occured: " + caught.getMessage());
					}

					@Override
					public void onSuccess(Double result) {
						wText.setText("Netto: " + result + " kg");
					}
				});
					fruitCellView(c);
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
					btnBanana.setPixelSize(80, 30);
					btnStrawberry.setPixelSize(80, 30);
					btnPineapple.setPixelSize(80, 30);
					btnKiwi.setPixelSize(80, 30);
					btnMango.setPixelSize(80, 30);
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
					btnSugar.setPixelSize(80, 30);
					btnPepper.setPixelSize(80, 30);
					btnSalt.setPixelSize(80, 30);
					btnChemicalX.setPixelSize(80, 30);
					ft.setWidget(5, 1, buttonPanel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	private void coinCellView(final Callback c) {
		try {
			c.getCoinService().getCoinList(new AsyncCallback<List<CoinDTO>>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Failed to access databse: "+caught.getMessage());

				}
				@Override
				public void onSuccess(List<CoinDTO> result) {
					coinList = result;

					CellTable<CoinDTO> coinTable = new CellTable<CoinDTO>();
					coinTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

					// Add a text column to show the name.
					TextColumn<CoinDTO> valueColumn = new TextColumn<CoinDTO>() {
						@Override
						public String getValue(CoinDTO object) {
							return Double.toString(object.getValue());
							
						}


					};
					coinTable.addColumn(valueColumn, "Coin Value");
					final SingleSelectionModel<CoinDTO> selectionModel = new SingleSelectionModel<CoinDTO>();
					coinTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

					coinTable.setSelectionModel(selectionModel);
					selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
						public void onSelectionChange(SelectionChangeEvent event) {
							final CoinDTO selected = selectionModel.getSelectedObject();
							/*
							 * Here we want to display the data in the table operatoer
							 * then we want to make it able to then show both coins and operatoer
							 * 
							 */
							if (selected != null) {
								//Window.alert("You selected: " + selected.getWeightPerUnit());
								try {c.getASEService().getSWeight(new AsyncCallback<Double>(){

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("An error occured: " + caught.getMessage());
									}

									@Override
									public void onSuccess(Double result) {
										wText.setText("Netto: " + result + " kg");
										double tWeight = (result)/(selected.getWeightPerUnit());
										stkText.setText("Number of units: "+tWeight);
									}
								});
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					});
					
					
					coinTable.setRowCount(coinList.size(), true);
					// Push the data into the widget.
					coinTable.setRowData(0, coinList);
					coinTable.redraw();
					ft.setWidget(5, 1, coinTable);
//					ft.setStyleName("H2");
				}

			});


		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void fruitCellView(final Callback c) {
		try {
			c.getFruitService().getFruitList(new AsyncCallback<List<FruitDTO>>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Failed to access databse: "+caught.getMessage());

				}
				@Override
				public void onSuccess(List<FruitDTO> result) {
					fruitList = result;

					CellTable<FruitDTO> fruitTable = new CellTable<FruitDTO>();
					fruitTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

					// Add a text column to show the name.
					TextColumn<FruitDTO> nameColumn = new TextColumn<FruitDTO>() {
						@Override
						public String getValue(FruitDTO object) {
							return object.getName();
						}

					};
					fruitTable.addColumn(nameColumn, "Fruit name");
				
					final SingleSelectionModel<FruitDTO> selectionModel = new SingleSelectionModel<FruitDTO>();
					fruitTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

					fruitTable.setSelectionModel(selectionModel);
					selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
						public void onSelectionChange(SelectionChangeEvent event) {
							final FruitDTO selected = selectionModel.getSelectedObject();
							/*
							 * Here we want to display the data in the table operatoer
							 * then we want to make it able to then show both coins and operatoer
							 * 
							 */
							if (selected != null) {
								try {c.getASEService().getSWeight(new AsyncCallback<Double>(){

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("An error occured: " + caught.getMessage());
									}

									@Override
									public void onSuccess(Double result) {
										wText.setText("Netto: " + result + " kg");
										double tWeight = (result)/(selected.getWeightPerUnit());
										stkText.setText("Number of units: "+tWeight);
									}
								});
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}


						}
					});
					
					
					fruitTable.setRowCount(fruitList.size(), true);
					// Push the data into the widget.
					fruitTable.setRowData(0, fruitList);
					fruitTable.redraw();
					ft.setWidget(5, 1, fruitTable);
				}

			});


		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
