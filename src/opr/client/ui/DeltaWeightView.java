package opr.client.ui;

import java.util.Arrays;
import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.ui.WeightView.Callback;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellList;
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
	private FlexTable ft = new FlexTable();
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
		
		viewInfo.addStyleName("deltaWeight");
		vPanel.add(hPanel1);
		hPanel1.add(viewInfo);
		
		vPanel.add(ft);
		ft.setWidget(0, 0, prdName);
		ft.setWidget(0, 1, prdNr);		
		ft.setWidget(0, 2, wData);
		ft.setWidget(1, 0, productName);
		ft.setWidget(1, 1, productNr);
		ft.setWidget(1, 2, weightData);
		productListView();
		
		
		
	}
	
	
	
	public void productListView(){
		
		  // The list of data to display.
		  final List<String> DAYS = Arrays.asList("Sunday", "Monday",
		      "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

		    // Create a cell to render each value in the list.
		    TextCell textCell = new TextCell();

		    // Create a CellList that uses the cell.
		    CellList<String> cellList = new CellList<String>(textCell);

		    // Set the total row count. This isn't strictly necessary, but it affects
		    // paging calculations, so its good habit to keep the row count up to date.
		    cellList.setRowCount(DAYS.size(), true);

		    // Push the data into the widget.
		    cellList.setRowData(0, DAYS);
		    ft.setWidget(1,2,cellList);
		
	}
}
