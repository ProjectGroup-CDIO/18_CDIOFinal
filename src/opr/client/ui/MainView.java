package opr.client.ui;

import opr.client.service.IASEService;
import opr.client.service.IASEServiceAsync;
import opr.client.service.IOperatoerService;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite implements Login.Callback, WeightView.Callback, DeltaWeightView.Callback {
	
	private OperatoerDTO activeUser;
	private VerticalPanel content = new VerticalPanel();
	private Login login;
	private MenuView menu;
	private AddView add;
	private final IOperatoerServiceAsync service = GWT.create(IOperatoerService.class);
	private final IASEServiceAsync ASEservice = GWT.create(IASEService.class);

	private AbsolutePanel aPanel = new AbsolutePanel();

	
	public MainView() throws Exception {
		initWidget(aPanel);

		aPanel.setSize(Integer.toString(Window.getClientWidth())+"px", Integer.toString(Window.getClientHeight())+"px");
		
		login = new Login(this);
		openLoginView();
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void openEditView(int oprId) throws Exception {
		content.clear();
		content.add(new EditView(this, oprId));
	
	}
	
	public void openAddView() throws Exception{
		content.clear();
		add = new AddView(this);
		content.add(add);
		
		aPanel.add(content);
		aPanel.setWidgetPosition(content,Window.getClientWidth()/8,Window.getClientHeight()/8);
	}
	
	public void openLoginView() {
		aPanel.clear();
		content.clear();
		activeUser = null;
		login.clear();
		content.add(login);
		aPanel.add(content);
		aPanel.setWidgetPosition(content,Window.getClientWidth()/2-115,Window.getClientHeight()/4);
		
	}
	
	public void openListView() throws Exception {
		content.clear();
		content.add(new ListView(this));
	
	}
	
	@Override
	public IOperatoerServiceAsync getService() {
		return service;
	}
	
	
	@Override
	public void loginSucces(OperatoerDTO activeUser) {

		aPanel.clear();
		this.activeUser = activeUser;
		menu = new MenuView(this);
		aPanel.add(menu);
		aPanel.setWidgetPosition(menu, 10, 10);
	}

	@Override
	public void loginFailiure() {
		// TODO Auto-generated method stub	
	}

	public void openWeightView() throws Exception{
		content.clear();
		WeightView weight = new WeightView(this);
		content.add(weight);
		aPanel.add(content);
		aPanel.setWidgetPosition(content,Window.getClientWidth()/8,Window.getClientHeight()/8);

	}

	public IASEServiceAsync getASEService() {
		return ASEservice;
	}

	public void openDeltaWeightView() {
		content.clear();
		DeltaWeightView dWView = new DeltaWeightView(this);
		content.add(dWView);
		aPanel.add(content);
		aPanel.setWidgetPosition(content,Window.getClientWidth()/8,Window.getClientHeight()/8);
		
	}

	
}
