package opr.client.ui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import opr.client.service.IASEServiceAsync;
import opr.client.service.IOperatoerServiceAsync;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeltaWeightView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel1 = new HorizontalPanel();
	private FlexTable ft = new FlexTable();
	private Label viewInfo = new Label("Delta Weight");

	private Label prdName = new Label("Product Name");
	private Label prdNr = new Label("Product ID");
	private Label wData = new Label("Weight data");

	private TextBox productName = new TextBox(); 
	private TextBox productNr = new TextBox();
	private TextBox weightData = new TextBox();

	
	
	  /**
	   * A simple data type that represents a contact.
	   */
	  private static class Contact {
	    private final String address;
	    private final Date birthday;
	    private final String name;

	    public Contact(String name, Date birthday, String address) {
	      this.name = name;
	      this.birthday = birthday;
	      this.address = address;
	    }
	  }
	
	
	public interface Callback{
		public IASEServiceAsync getASEService();
		public IOperatoerServiceAsync getService();
	}

	public DeltaWeightView(final Callback c) {
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
		  final List<Contact> CONTACTS = Arrays.asList(
		      new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
		      new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
		      new Contact("George", new Date(46, 6, 6), "1600 Pennsylvania Avenue"));

		 
		    // Create a CellTable.
		    CellTable<Contact> table = new CellTable<Contact>();
		    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		    // Add a text column to show the name.
		    TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
		      @Override
		      public String getValue(Contact object) {
		        return object.name;
		      }
		    };
		    table.addColumn(nameColumn, "ID");

		    // Add a date column to show the birthday.
		    DateCell dateCell = new DateCell();
		    Column<Contact, Date> dateColumn = new Column<Contact, Date>(dateCell) {
		      @Override
		      public Date getValue(Contact object) {
		        return object.birthday;
		      }
		    };
		    table.addColumn(dateColumn, "Product Name");

		    // Add a text column to show the address.
		    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
		      @Override
		      public String getValue(Contact object) {
		        return object.address;
		      }
		    };
		    table.addColumn(addressColumn, "Address");

		 

		    // Set the total row count. This isn't strictly necessary, but it affects
		    // paging calculations, so its good habit to keep the row count up to date.
		    table.setRowCount(CONTACTS.size(), true);

		    // Push the data into the widget.
		    table.setRowData(0, CONTACTS);

		    // Add it to the root panel
		    ft.setWidget(2, 2, table);
		
		
		
	}




}
