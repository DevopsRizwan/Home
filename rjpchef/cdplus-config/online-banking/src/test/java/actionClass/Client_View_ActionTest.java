package actionClass;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Client_View;
import daoImpl.Client_View_DaoImpl;



@RunWith(PowerMockRunner.class)
@PrepareForTest({Client_View_Action.class,Client_View_DaoImpl.class, Client_View.class})
public class Client_View_ActionTest {
	
	@Test
	public void testViewCl() throws Exception{
	
	Client_View clientView = new Client_View();
		
	Client_View mockClientView = PowerMockito.mock(Client_View.class);
	PowerMockito.whenNew(Client_View.class).withNoArguments().thenReturn(mockClientView);
	
	Client_View_DaoImpl mockClient_View_DaoImpl = PowerMockito.mock(Client_View_DaoImpl.class);
	PowerMockito.whenNew(Client_View_DaoImpl.class).withNoArguments().thenReturn(mockClient_View_DaoImpl);
	
	
	ArrayList<Client_View> clviewList = new ArrayList<Client_View>();
	PowerMockito.when(mockClient_View_DaoImpl.list(mockClientView)).thenReturn(clviewList);
	
	
	Client_View_Action client_View_Action = new Client_View_Action();
	client_View_Action.setView(clientView);
	String viewcl = client_View_Action.viewcl();
		
	}
	
	
	@Test
	public void testViewClsetGetCoverage() throws Exception{
	
	Client_View clientView = new Client_View();
		
	Client_View mockClientView = PowerMockito.mock(Client_View.class);
	PowerMockito.whenNew(Client_View.class).withNoArguments().thenReturn(mockClientView);
	
	Client_View_DaoImpl mockClient_View_DaoImpl = PowerMockito.mock(Client_View_DaoImpl.class);
	PowerMockito.whenNew(Client_View_DaoImpl.class).withNoArguments().thenReturn(mockClient_View_DaoImpl);
	
	
	ArrayList<Client_View> clviewList = new ArrayList<Client_View>();
	PowerMockito.when(mockClient_View_DaoImpl.list(mockClientView)).thenReturn(clviewList);
	
	
	Client_View_Action client_View_Action = new Client_View_Action();
	client_View_Action.setView(clientView);
	client_View_Action.getView();
	client_View_Action.setAbc(mockClientView);
	client_View_Action.getAbc();
	client_View_Action.setXyz(mockClient_View_DaoImpl);
	client_View_Action.getXyz();
	client_View_Action.setDetailList(clviewList);
	client_View_Action.getDetailList();
	
	}
	
	
	

}
