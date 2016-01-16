package actionClass;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Admin_AddEmp;
import actionForm.Emp_Login;
import daoImpl.Admin_AddEmp_DaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Admin_AddEmp_Action.class)
public class Admin_Add_Emp_ActionTest {

	@Test
	public void testAddEmp() throws Exception {

		Admin_AddEmp empDetails = new Admin_AddEmp();
		
		Admin_AddEmp_DaoImpl mocknew = PowerMockito.mock(Admin_AddEmp_DaoImpl.class);
		PowerMockito.whenNew(Admin_AddEmp_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Admin_AddEmp mockAdminEmp = PowerMockito.mock(Admin_AddEmp.class);
		PowerMockito.when(mocknew.addEmp(mockAdminEmp)).thenReturn(empDetails);
				
		Admin_AddEmp_Action admin_AddEmp_Action = new Admin_AddEmp_Action();
		admin_AddEmp_Action.setAdd(mockAdminEmp);
		admin_AddEmp_Action.setXyz(mocknew);
		String addEmp = admin_AddEmp_Action.addEmp();
	
		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Admin_AddEmp_DaoImpl.class);
	

		
	}
	
	
	@Test
	public void testAddEmps() throws Exception {

		Emp_Login empLoginDetails = new Emp_Login();
		
		Admin_AddEmp_DaoImpl mocknew = PowerMockito.mock(Admin_AddEmp_DaoImpl.class);
		PowerMockito.whenNew(Admin_AddEmp_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Emp_Login mockEmpLogin = PowerMockito.mock(Emp_Login.class);
		PowerMockito.when(mocknew.addEmps(mockEmpLogin)).thenReturn(empLoginDetails);
				
		
		Admin_AddEmp_Action admin_AddEmp_Action = new Admin_AddEmp_Action();
		admin_AddEmp_Action.setAdds(mockEmpLogin);
		String empLogin = admin_AddEmp_Action.addEmps();
	
		Assert.assertEquals(empLogin, "success");
		PowerMockito.verifyNew(Admin_AddEmp_DaoImpl.class);
	

		
	}
	
	@Test
	public void testgetAdd() throws Exception {
		Emp_Login mockEmpLogin = PowerMockito.mock(Emp_Login.class);
		Admin_AddEmp_Action admin_AddEmp_Action = new Admin_AddEmp_Action();
		admin_AddEmp_Action.setAdds(mockEmpLogin);
		Emp_Login empLogin = admin_AddEmp_Action.getAdds();
	}
	
	
	@Test
	public void testgetAdds() throws Exception {
		Admin_AddEmp mockEmpLogin = PowerMockito.mock(Admin_AddEmp.class);
		Admin_AddEmp_Action admin_AddEmp_Action = new Admin_AddEmp_Action();
		admin_AddEmp_Action.setAdd(mockEmpLogin);
		Admin_AddEmp empLogin = admin_AddEmp_Action.getAdd();
	}
	
	
	@Test
	public void testgetXYZ() throws Exception {
		Admin_AddEmp_DaoImpl mocknew = PowerMockito.mock(Admin_AddEmp_DaoImpl.class);
		PowerMockito.whenNew(Admin_AddEmp_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Admin_AddEmp_Action admin_AddEmp_Action = new Admin_AddEmp_Action();
		admin_AddEmp_Action.setXyz(mocknew);
		admin_AddEmp_Action.getXyz();
	}
	
	
	

}
