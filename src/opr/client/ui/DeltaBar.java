package opr.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

public class DeltaBar extends Composite {


	public DeltaBar(final MainView main){
		
		double e1 = 200.0;
		double e2 = 228.0;
		double s = 150.0;
		
		LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("layoutPanel0");
		initWidget(layoutPanel);
		layoutPanel.setSize("403px", "37px");
		
		LayoutPanel layoutPanel_1 = new LayoutPanel();
		layoutPanel_1.setStyleName("layoutPanel2");
		layoutPanel.add(layoutPanel_1);
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, e1, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 0.0, Unit.PX, 37.0, Unit.PX);
		
		LayoutPanel layoutPanel_2 = new LayoutPanel();
		layoutPanel_2.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_2);
		layoutPanel.setWidgetLeftWidth(layoutPanel_2, e2, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_2, 0.0, Unit.PX, 37.0, Unit.PX);
		
		LayoutPanel layoutPanel_3 = new LayoutPanel();
		layoutPanel_3.setStyleName("layoutPanel1");
		layoutPanel.add(layoutPanel_3);
		layoutPanel.setWidgetLeftWidth(layoutPanel_3, 150.0, Unit.PX, 2.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_3, 0.0, Unit.PX, 37.0, Unit.PX);
		
	}
}
