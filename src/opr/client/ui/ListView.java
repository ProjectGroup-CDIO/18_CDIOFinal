package opr.client.ui;

import java.util.ArrayList;
import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.IBatchServiceAsync;
import opr.client.service.ICoinServiceAsync;
import opr.client.service.IMetaServiceAsync;
import opr.client.service.IOperatoerServiceAsync;
import opr.client.ui.DeltaWeightView.Callback;
import opr.shared.BatchDTO;
import opr.shared.CoinDTO;
import opr.shared.OperatoerDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class ListView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private Anchor remove;
	private Anchor edit;
	private OperatoerDTO opr;

	private List<String> tableList;
	private List<OperatoerDTO> oprList;
	private List<CoinDTO> coinList;
	private List<BatchDTO> batchList;

	private	FlexTable ft = new FlexTable();
	private FlexCellFormatter ftFormat = ft.getFlexCellFormatter();
	public interface Callback{

		public IOperatoerServiceAsync getService();
		public void openListView() throws Exception;
		public void openEditView(int i) throws Exception;
		public ICoinServiceAsync getCoinService();
		public IMetaServiceAsync getMetaService();
		public IBatchServiceAsync getBatchService();

	}


	public ListView(final Callback c) throws Exception {
		initWidget(this.vPanel);
		ft.setBorderWidth(1);
		HorizontalPanel hPanel = new HorizontalPanel();
		
		ft.add(hPanel);
		hPanel.add(edit);
		hPanel.add(remove);


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
				ft.setWidget(0, 0, tables);
				ft.setStyleName("H2");
				//				tables.getRowElement(0).getCells().getItem(0).setId("H3");

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
						if(selected.equals("batch")){
							batchCellView(c);

						}
					}

				});

			}
		});

		c.getService().getOperatoerList(new AsyncCallback<List<OperatoerDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				l = result;
				int j = 1;
				for(int i = 0; i < l.size(); i++) {
					if (l.get(i).getActive() > 0) {
						ft.setText(j, 0,
								String.valueOf(l.get(i).getOprId()));
						ft.setText(j, 1, l.get(i).getOprNavn());
						ft.setWidget(j, 2, new RadioButton("check 'em", ""));
						j++;
					}
				}
			}
		});

		Button editBtn = new Button("Edit");
		editBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				for(int i = 0; i < l.size(); i++) {
					RadioButton btn = (RadioButton) ft.getWidget(i+1, 2);
					if(btn.getValue()) {
						try {
							c.openEditView(Integer.parseInt(ft.getText(i+1, 0)));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		});

		Button removeBtn = new Button("Remove");
		removeBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				for(int i = 0; i < l.size(); i++) {
					RadioButton btn = (RadioButton) ft.getWidget(i+1, 2);
					if(btn.getValue()) {
						try {
							c.getService().getOperatoer(Integer.parseInt(ft.getText(i+1, 0)), new AsyncCallback<OperatoerDTO>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Noget gik galt: "+caught.getMessage());

								}

								@Override
								public void onSuccess(OperatoerDTO result) {
									opr = result; 
									try {
										c.getService().deleteOperatoer(opr, new AsyncCallback<Void>() {

											@Override
											public void onFailure(Throwable caught) {
												Window.alert("Error: "+caught.getMessage());

											}

											@Override
											public void onSuccess(Void result) {
												Window.alert("Success: Operatør "+opr.getOprNavn()+" slettet.\n(Sat til inaktiv)");
												try {
													c.openListView();
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}

											}

										});
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

							});
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		});

		vPanel.add(ft);
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(editBtn);
		buttonPanel.add(removeBtn);
		vPanel.add(buttonPanel);


	}


	private void coinCellView(Callback c) {
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
					ft.setWidget(0,1, coinTable);
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
					ft.setWidget(0,1, oprTable);


				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void batchCellView(final Callback c) {


		c.getBatchService().getBatchList(new AsyncCallback<List<BatchDTO>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());
			}
			@Override
			public void onSuccess(List<BatchDTO> result) {
				batchList = result;


				CellTable<BatchDTO> batchTable = new CellTable<BatchDTO>();
				batchTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

				// Add a text column to show the name.
				TextColumn<BatchDTO> IDColumn = new TextColumn<BatchDTO>() {
					@Override
					public String getValue(BatchDTO object) {
						return Integer.toString(object.getBatch_id());
					}


				};
				batchTable.addColumn(IDColumn, "Batch ID");

				// Add a text column to show the name.
				TextColumn<BatchDTO> raaNavnColumn = new TextColumn<BatchDTO>() {
					@Override
					public String getValue(BatchDTO object) {
						return object.getRaavare_navn();
					}


				};
				batchTable.addColumn(raaNavnColumn, "Raavare");

				// Add a text column to show the name.
				TextColumn<BatchDTO> raavareIDColumn = new TextColumn<BatchDTO>() {
					@Override
					public String getValue(BatchDTO object) {
						return Integer.toString(object.getRaavare_id());
					}


				};
				batchTable.addColumn(raavareIDColumn, "Raavare ID");

				// Add a text column to show the name.
				TextColumn<BatchDTO> baWghtColumn = new TextColumn<BatchDTO>() {
					@Override
					public String getValue(BatchDTO object) {
						return Double.toString(object.getBatchweight());
					}


				};
				batchTable.addColumn(baWghtColumn, "Batch Weight");

				// Add a text column to show the name.
				TextColumn<BatchDTO> toleranceColumn = new TextColumn<BatchDTO>() {
					@Override
					public String getValue(BatchDTO object) {
						return Double.toString(object.getTolerance());
					}


				};
				batchTable.addColumn(toleranceColumn, "Tolerance");

				final SingleSelectionModel<BatchDTO> selectionModel = new SingleSelectionModel<BatchDTO>();


				batchTable.setSelectionModel(selectionModel);
				selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						BatchDTO selected = selectionModel.getSelectedObject();
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

				batchTable.setRowCount(batchList.size(), true);
				// Push the data into the widget.
				batchTable.setRowData(0, batchList);
				batchTable.redraw();
				ft.setWidget(0,1, batchTable);
			}
		});
	}

	

}
