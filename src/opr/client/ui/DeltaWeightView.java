package opr.client.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.OperatoerDTO;
import opr.shared.UnitDTO;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

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


	private List<OperatoerDTO> tableList;



	public interface Callback{
		public IASEServiceAsync getASEService();
		public IOperatoerServiceAsync getService();
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
		
		c.getService().getOperatoerList(new AsyncCallback<List<OperatoerDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				tableList = result;
				
			}
		
	});

		// Create a CellTable.
		CellTable<OperatoerDTO> table = new CellTable<OperatoerDTO>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a text column to show the name.
		TextColumn<OperatoerDTO> nameColumn = new TextColumn<OperatoerDTO>() {
			@Override
			public String getValue(OperatoerDTO object) {
				return ""+object.getOprId();
			}
		};
		table.addColumn(nameColumn, "Table name");



		// Add a text column to show the address.
//		    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
//		      @Override
//		      public String getValue(Contact object) {
//		        return object.address;
//		      }
//		    };
//		    table.addColumn(addressColumn, "Address");
//		 


		// Set the total row count. This isn't strictly necessary, but it affects
		// paging calculations, so its good habit to keep the row count up to date.
		table.setRowCount(tableList.size(), true);

		// Push the data into the widget.
		table.setRowData(0, tableList);
		table.redraw();
		

		// Add it to the root panel
		//ft.setWidget(3, 3, table);



}




}
