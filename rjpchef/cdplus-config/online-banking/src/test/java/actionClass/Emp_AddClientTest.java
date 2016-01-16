package actionClass;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import daoImpl.Emp_AddClient_DaoImpl;
import actionForm.Client_Login;
import actionForm.Emp_AddClient;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Emp_AddClient_Action.class)

public class Emp_AddClientTest {
	
	@Test
	public void testEmp_AddClient() throws Exception {

		Emp_AddClient  addEmps = new Emp_AddClient();
		
		Emp_AddClient_DaoImpl mocknew = PowerMockito.mock(Emp_AddClient_DaoImpl.class);
		
		PowerMockito.whenNew(Emp_AddClient_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Emp_AddClient mockAddCleint = PowerMockito.mock(Emp_AddClient.class);
		PowerMockito.when(mocknew.addClient(mockAddCleint)).thenReturn(addEmps);
		
		Client_Login clientlog=	PowerMockito.mock(Client_Login.class);
				
		Emp_AddClient_Action emp_AddClient_Action = new Emp_AddClient_Action();
		emp_AddClient_Action.setAdd(mockAddCleint);
		emp_AddClient_Action.setAddb(mockAddCleint);
		emp_AddClient_Action.setAdds(clientlog);
		emp_AddClient_Action.setXyz(mocknew);
		emp_AddClient_Action.getAdd();
		emp_AddClient_Action.getAdds();
		emp_AddClient_Action.getAddb();
		emp_AddClient_Action.getEdit();
		emp_AddClient_Action.getXyz();
	
		String addEmp = emp_AddClient_Action.addClient();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddClient_DaoImpl.class);
		
	}
	
	

	@Test
	public void testEmp_AddClients() throws Exception {

		Client_Login  clientLogdet = new Client_Login();
		
		Emp_AddClient_DaoImpl mocknew = PowerMockito.mock(Emp_AddClient_DaoImpl.class);
		
		PowerMockito.whenNew(Emp_AddClient_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Client_Login mockCleintLogDet = PowerMockito.mock(Client_Login.class);
		PowerMockito.when(mocknew.addClients(mockCleintLogDet)).thenReturn(clientLogdet);
				
		String addEmp = new Emp_AddClient_Action().addClients();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddClient_DaoImpl.class);
		
	}
	
	
	@Test
	public void testEmp_EditClient() throws Exception {

		Emp_AddClient  addEmps = new Emp_AddClient();
		
		Emp_AddClient_DaoImpl mocknew = PowerMockito.mock(Emp_AddClient_DaoImpl.class);
		
		PowerMockito.whenNew(Emp_AddClient_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Emp_AddClient mockAddCleint = PowerMockito.mock(Emp_AddClient.class);
		List<Emp_AddClient> clientList = new ArrayList<Emp_AddClient>();
		PowerMockito.when(mocknew.list(mockAddCleint)).thenReturn(clientList);
		
		Client_Login clientlog=	PowerMockito.mock(Client_Login.class);
				
		Emp_AddClient_Action emp_AddClient_Action = new Emp_AddClient_Action();
		emp_AddClient_Action.setAdd(mockAddCleint);
		emp_AddClient_Action.setAddb(mockAddCleint);
		emp_AddClient_Action.setAdds(clientlog);
		emp_AddClient_Action.setXyz(mocknew);
		emp_AddClient_Action.setDetail(clientList);
		
		//Emp_AddClient emp_AddClient = PowerMockito.mock(Emp_AddClient.class);
		emp_AddClient_Action.setEdit(mockAddCleint);
		emp_AddClient_Action.getEdit();
		emp_AddClient_Action.getDetail();

		String addEmp = emp_AddClient_Action.editclient();
		
		emp_AddClient_Action.eclient();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddClient_DaoImpl.class);
		
	}
	
	
	
	
	
	
	
	

}
