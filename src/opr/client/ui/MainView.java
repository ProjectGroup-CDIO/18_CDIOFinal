package opr.client.ui;

import opr.client.service.IOperatoerService;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite implements Login.Callback {
	
	private OperatoerDTO activeUser;
	private VerticalPanel content = new VerticalPanel();
	private Login login;
	private MenuView menu;
	private AddView add;
	private final IOperatoerServiceAsync service = GWT.create(IOperatoerService.class);

	private AbsolutePanel aPanel = new AbsolutePanel();
	
	//private final IASEServiceAsync ase = GWT.create(IASEService.class);

	
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
		aPanel.setWidgetPosition(content, 200, 200);
	}
	
	public void openLoginView() {

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
	
/*	public IASEServiceAsync getAse() {
		return ase;
	}*/

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

	public void openWeightView() {
		// TODO Auto-generated method stub
		
	}

	
}
