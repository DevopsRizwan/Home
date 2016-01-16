package actionClass;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Client_Login;
import actionForm.Emp_Login;

import com.opensymphony.xwork2.ActionContext;

import daoImpl.Client_Login_DaoImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Client_Login_Action.class, Client_Login_DaoImpl.class, ActionContext.class})
public class Client_Login_ActionTest {
	
	@Test
	public void testExecuteEmp(){
	
		String execute = new Client_Login_Action().execute();
		
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testCheckLoginfailUsNameEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		Client_Login emp_Login  =new Client_Login ();
		emp_Login.setUserName("");
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailPasswordEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		Client_Login emp_Login  =new Client_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("");
		emp_Login.setTerms(true);
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailBankIdEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		Client_Login emp_Login= new Client_Login ();
		emp_Login.setUserName("testuser");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("");

		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testCheckLogintestCheckLoginSuccessBankIdEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		Client_Login emp_Login= new Client_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");
		emp_Login.setTerms(true);

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "success");
		
	}
	
	
	
	@Test
	public void testCheckLogintestCheckLoginErrorBankIdNull() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		Client_Login emp_Login= new Client_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");
		
		emp_Login_Action.setLogin(emp_Login);
		
		Client_Login emp_Login1= new Client_Login ();
		emp_Login1.setUserName("testusr");
		emp_Login1.setPassword("password");
		emp_Login1.setBank_id(null);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login1);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "error");
		
	}
	
	

	@Test
	public void testChangePwFailoldPwEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();		
		changepw.setOldpw("");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailNewPwEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("");
		changepw.setCnewpw("Cnewpw");
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailCNewPwEmpty() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("");
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailnotmatch() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("Cnewpw");
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccess() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testChangePwSuccessTestnot() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("not");
		 Client_Login_Action emp_Login_Action = new Client_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccessTestgood() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("good");
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testEmplogout() throws Exception{
		
		
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user", "user");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		
		String execute = emp_Login_Action.logout();
		Assert.assertEquals(execute, "success");
		
	}
	
	
	
	@Test
	public void testCheckLoginGetCoverage() throws Exception{
		
		Client_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Client_Login_DaoImpl.class);
		PowerMockito.whenNew(Client_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Client_Login_Action emp_Login_Action = new Client_Login_Action();
		
		Client_Login emp_Login= new Client_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		
		emp_Login_Action.setLoginDAO(mockEmp_Login_DaoImpl);
		emp_Login_Action.getLoginDAO();
		
		
		Client_Login changepw= new Client_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		emp_Login_Action.setChpw(changepw);
		emp_Login_Action.getChpw();
		
		emp_Login_Action.setLogin(emp_Login);
		emp_Login_Action.getLogin();
		
		PowerMockito.whenNew(Client_Login.class).withNoArguments().thenReturn(emp_Login);
		
		emp_Login_Action.getModel();
		

	
	}
	

}
