package actionClass;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Emp_Login;

import com.opensymphony.xwork2.ActionContext;

import daoImpl.Emp_Login_DaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Emp_Login_Action.class, Emp_Login_DaoImpl.class, ActionContext.class})
public class Emp_Login_ActionTest {
	
	@Test
	public void testExecuteEmp(){
	
		String execute = new Emp_Login_Action().execute();
		
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testCheckLoginfailUsNameEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		Emp_Login emp_Login  =new Emp_Login ();
		emp_Login.setUserName("");
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailPasswordEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		Emp_Login emp_Login  =new Emp_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("");
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailBankIdEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		Emp_Login emp_Login= new Emp_Login ();
		emp_Login.setUserName("testuser");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("");

		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testCheckLogintestCheckLoginSuccessBankIdEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		Emp_Login emp_Login= new Emp_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "success");
		
	}
	
	
	
	@Test
	public void testCheckLogintestCheckLoginErrorBankIdNull() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		Emp_Login emp_Login= new Emp_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");
		
		emp_Login_Action.setLogin(emp_Login);
		
		Emp_Login emp_Login1= new Emp_Login ();
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
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();		
		changepw.setOldpw("");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailNewPwEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("");
		changepw.setCnewpw("Cnewpw");
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailCNewPwEmpty() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("");
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailnotmatch() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("Cnewpw");
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccess() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testChangePwSuccessTestnot() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("not");
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccessTestgood() throws Exception{
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("good");
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testEmplogout() throws Exception{
		
		
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
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
		
		Emp_Login_DaoImpl mockEmp_Login_DaoImpl = PowerMockito.mock(Emp_Login_DaoImpl.class);
		PowerMockito.whenNew(Emp_Login_DaoImpl.class).withNoArguments().thenReturn(mockEmp_Login_DaoImpl);
		Emp_Login_Action emp_Login_Action = new Emp_Login_Action();
		
		Emp_Login emp_Login= new Emp_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockEmp_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		
		emp_Login_Action.setXyz(mockEmp_Login_DaoImpl);
		emp_Login_Action.getXyz();
		
		emp_Login_Action.setLoginDAO(mockEmp_Login_DaoImpl);
		emp_Login_Action.getLoginDAO();
		
		
		Emp_Login changepw= new Emp_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		emp_Login_Action.setChpw(changepw);
		emp_Login_Action.getChpw();
		
		emp_Login_Action.setLogin(emp_Login);
		emp_Login_Action.getLogin();
		
		PowerMockito.whenNew(Emp_Login.class).withNoArguments().thenReturn(emp_Login);
		
		emp_Login_Action.getModel();
		

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
