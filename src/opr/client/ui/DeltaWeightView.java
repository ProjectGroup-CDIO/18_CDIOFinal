package opr.client.ui;

import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.IMetaService;
import opr.client.service.IMetaServiceAsync;
import opr.client.service.IOperatoerServiceAsync;
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

	FlexTable ft = new FlexTable();
	private Label viewInfo = new Label("Delta-weight");

	private Label prdName = new Label("Product Name");
	private Label prdNr = new Label("Product ID");
	private Label wData = new Label("Weight data");

	private TextBox productName = new TextBox(); 
	private TextBox productNr = new TextBox();
	private TextBox weightData = new TextBox();


	private List<String> tableList;
	private List<OperatoerDTO> oprList;



	public interface Callback{
		public IASEServiceAsync getASEService();
		public IOperatoerServiceAsync getService();
		public IMetaServiceAsync getMetaService();
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
				ft.setWidget(3, 3, tables);

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
						if (selected != null) {
							Window.alert("You selected: " + selected);
						}
						if(selected.equals("operatoer")){
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


									//	Add a selection model to handle user selection.
										oprTable.setRowCount(oprList.size(), true);
										// Push the data into the widget.
										oprTable.setRowData(0, oprList);
										oprTable.redraw();
										ft.setWidget(3,4, oprTable);


									}

								});
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				});

				

			}

		});




	}




}
