package opr.client.ui;

import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.ICoinServiceAsync;
import opr.client.service.IMetaService;
import opr.client.service.IMetaServiceAsync;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.CoinDTO;
import opr.shared.OperatoerDTO;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class DeltaWeightView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel1 = new HorizontalPanel();
	private HorizontalPanel hPanel2 = new HorizontalPanel();
	
	FlexTable ft = new FlexTable();
	FlexTable ft2 = new FlexTable();
	private Label viewInfo = new Label("Delta-weight");

	private Label prdName = new Label("Product Name");
	private Label prdNr = new Label("Product ID");
	private Label wData = new Label("Weight data");

	private TextBox productName = new TextBox(); 
	private TextBox productNr = new TextBox();
	private TextBox weightData = new TextBox();


	private List<String> tableList;
	private List<OperatoerDTO> oprList;
	private List<CoinDTO> coinList;




	public interface Callback{
		public IASEServiceAsync getASEService();
		public IOperatoerServiceAsync getService();
		public IMetaServiceAsync getMetaService();
		public ICoinServiceAsync getCoinService();
	}

	public DeltaWeightView(final Callback c) throws Exception {
		initWidget(vPanel);

		viewInfo.addStyleName("deltaWeight");
		vPanel.add(viewInfo);
		vPanel.add(hPanel1);

		hPanel1.add(ft);
		ft.setWidget(1, 0, prdName);
		ft.setWidget(1, 1, prdNr);		
		ft.setWidget(1, 2, wData);
		ft.setWidget(2, 0, productName);
		ft.setWidget(2, 1, productNr);
		ft.setWidget(2, 2, weightData);

		
		hPanel2.add(ft2);
		vPanel.add(hPanel2);



		/**
		 * The list of data to display.
		 */

		c.getMetaService().getTables(new AsyncCallback<List<String>>(){
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());

			}

			@Override
			public void onSuccess(List<String> result) {
				tableList = result;
				// Create a CellTable.
				CellTable<String> tables = new CellTable<String>();
				tables.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
				// Add a text column to show the name.
				TextColumn<String> nameColumn = new TextColumn<String>() {
					@Override
					public String getValue(String object) {
						return object;
					}
				};
				tables.addColumn(nameColumn, "Table name");

				// Set the total row count. This isn't strictly necessary, but it affects
				// paging calculations, so its good habit to keep the row count up to date.
				tables.setRowCount(tableList.size(), true);
				// Push the data into the widget.
				tables.setRowData(0, tableList);
				tables.redraw();
				//Placement of tables on the flextable nr 2
				ft2.setWidget(0, 0, tables);
				
				
				final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
				tables.setSelectionModel(selectionModel);
				selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						String selected = selectionModel.getSelectedObject();
						/*
						 * Here we want to display the data in the table operatoer
						 * then we want to make it able to then show both coins and operatoer
						 * 
						 */
						//						if (selected != null) {
						//							Window.alert("You selected: " + selected);
						//						}
						if(selected.equals("operatoer")){
							oprCellView(c);

						}
						if(selected.equals("coins")){
							coinCellView(c);

						}
					}
				});

			}
		});
	}


	private void coinCellView(Callback c) {
		try {
			c.getCoinService().getCoinList(new AsyncCallback<List<CoinDTO>>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Failed to access databse: "+caught.getMessage());

				}

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


					TextColumn<CoinDTO> toleColumn = new TextColumn<CoinDTO>() {
						@Override
						public String getValue(CoinDTO object) {
							return Double.toString(object.getTolerance());
						}


					};
					coinTable.addColumn(toleColumn, "Tolerance");


					TextColumn<CoinDTO> wPrUnitColumn = new TextColumn<CoinDTO>() {
						@Override
						public String getValue(CoinDTO object) {
							return Double.toString(object.getWeightPerUnit());
						}


					};
					coinTable.addColumn(wPrUnitColumn, "Weight Pr Unit");
					
					
					final SingleSelectionModel<CoinDTO> selectionModel = new SingleSelectionModel<CoinDTO>();
					coinTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

					coinTable.setSelectionModel(selectionModel);
					selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
						public void onSelectionChange(SelectionChangeEvent event) {
							CoinDTO selected = selectionModel.getSelectedObject();
							/*
							 * Here we want to display the data in the table operatoer
							 * then we want to make it able to then show both coins and operatoer
							 * 
							 */
							if (selected != null) {
								Window.alert("You selected: " + selected);
							}


						}
					});
					coinTable.setRowCount(coinList.size(), true);
					// Push the data into the widget.
					coinTable.setRowData(0, coinList);
					coinTable.redraw();
					ft2.setWidget(0,1, coinTable);
				}

			});


		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void oprCellView(final Callback c) {
		try {
			c.getService().getOperatoerList(new AsyncCallback<List<OperatoerDTO>>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Failed to access databse: "+caught.getMessage());
				}

				@Override
				public void onSuccess(List<OperatoerDTO> result) {
					oprList = result;

					CellTable<OperatoerDTO> oprTable = new CellTable<OperatoerDTO>();
					oprTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
					// Add a text column to show the name.
					TextColumn<OperatoerDTO> oprColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return Integer.toString(object.getOprId());
						}


					};
					oprTable.addColumn(oprColumn, "Opr ID");


					TextColumn<OperatoerDTO> nameColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return object.getOprNavn();
						}


					};
					oprTable.addColumn(nameColumn, "name");


					TextColumn<OperatoerDTO> iniColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return object.getIni();
						}


					};
					oprTable.addColumn(iniColumn, "initials");

					TextColumn<OperatoerDTO> cprColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return object.getCpr();
						}


					};
					oprTable.addColumn(cprColumn, "cpr");
					TextColumn<OperatoerDTO> passwColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return object.getPassword();
						}


					};
					oprTable.addColumn(passwColumn, "Password");

					TextColumn<OperatoerDTO> activeColumn = new TextColumn<OperatoerDTO>() {
						@Override
						public String getValue(OperatoerDTO object) {
							return Integer.toString(object.getActive());
						}


					};
					oprTable.addColumn(activeColumn, "active rights ID");

					final SingleSelectionModel<OperatoerDTO> selectionModel = new SingleSelectionModel<OperatoerDTO>();
					oprTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
					oprTable.setSelectionModel(selectionModel);
					selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
						public void onSelectionChange(SelectionChangeEvent event) {
							OperatoerDTO selected = selectionModel.getSelectedObject();
							/*
							 * Here we want to display the data in the table operatoer
							 * then we want to make it able to then show both coins and operatoer
							 * 
							 */
							if (selected != null) {
								Window.alert("You selected: " + selected);
							}


						}


					});
					//	Add a selection model to handle user selection.
					oprTable.setRowCount(oprList.size(), true);
					// Push the data into the widget.
					oprTable.setRowData(0, oprList);
					oprTable.redraw();
					ft2.setWidget(0,1, oprTable);


				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
