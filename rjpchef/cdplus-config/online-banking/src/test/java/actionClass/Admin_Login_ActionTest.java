package actionClass;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.opensymphony.xwork2.ActionContext;

import daoImpl.Admin_AddEmp_DaoImpl;
import daoImpl.Admin_Login_DaoImpl;
import daoImpl.Admin_Login_DaoImpl;
import actionForm.Admin_Login;
import actionForm.Emp_Login;



@RunWith(PowerMockRunner.class)
@PrepareForTest({Admin_Login_Action.class, Admin_Login.class, Admin_Login_DaoImpl.class, ActionContext.class})

public class Admin_Login_ActionTest {
	
	@Test
	public void testExecute(){
	
	String execute = new Admin_Login_Action().execute();
		
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testLogin() throws Exception{
		
		Admin_Login mocknew = PowerMockito.mock(Admin_Login.class);
		PowerMockito.whenNew(Admin_Login.class).withNoArguments().thenReturn(mocknew);
		
		Object execute = new Admin_Login_Action().getModel();
		Assert.assertEquals(execute.toString(), "admin_Login");
		PowerMockito.verifyNew(Admin_Login.class);
		
	}
	
	@Test
	public void testCheckLoginfailUsNameEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		Admin_Login emp_Login  =new Admin_Login ();
		emp_Login.setUserName("");
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailPasswordEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		Admin_Login emp_Login  =new Admin_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("");
		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();
		
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testCheckLogintestCheckLoginfailBankIdEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		Admin_Login emp_Login= new Admin_Login ();
		emp_Login.setUserName("testuser");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("");

		emp_Login_Action.setLogin(emp_Login);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testCheckLogintestCheckLoginSuccessBankIdEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		Admin_Login emp_Login= new Admin_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "success");
		
	}
	
	
	
	@Test
	public void testCheckLogintestCheckLoginErrorBankIdNull() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		Admin_Login emp_Login= new Admin_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");
		
		emp_Login_Action.setLogin(emp_Login);
		
		Admin_Login emp_Login1= new Admin_Login ();
		emp_Login1.setUserName("testusr");
		emp_Login1.setPassword("password");
		emp_Login1.setBank_id(null);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login1);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		String execute = emp_Login_Action.checkLogin();

		Assert.assertEquals(execute, "error");
		
	}
	
	

	@Test
	public void testChangePwFailoldPwEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		/*changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");*/
		
		changepw.setOldpw("");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailNewPwEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		/*changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");*/
		
		changepw.setOldpw("oldpw");
		changepw.setNewpw("");
		changepw.setCnewpw("Cnewpw");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		emp_Login_Action.setChpw(changepw);
		
		String execute = emp_Login_Action.changepw();

		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailCNewPwEmpty() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	@Test
	public void testChangePwFailnotmatch() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("Cnewpw");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		emp_Login_Action.setChpw(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccess() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "success");
		
	}
	
	@Test
	public void testChangePwSuccessTestnot() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("not");
		
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
		String execute = emp_Login_Action.changepw();
		Assert.assertEquals(execute, "error");
		
	}
	
	
	@Test
	public void testChangePwSuccessTestgood() throws Exception{
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		changepw.setTest("good");
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		emp_Login_Action.setChpw(changepw);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.changepw(changepw)).thenReturn(changepw);
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
		
		Admin_Login_DaoImpl mockAdmin_Login_DaoImpl = PowerMockito.mock(Admin_Login_DaoImpl.class);
		PowerMockito.whenNew(Admin_Login_DaoImpl.class).withNoArguments().thenReturn(mockAdmin_Login_DaoImpl);
		Admin_Login_Action emp_Login_Action = new Admin_Login_Action();
		
		Admin_Login emp_Login= new Admin_Login ();
		emp_Login.setUserName("testusr");
		emp_Login.setPassword("password");
		emp_Login.setBank_id("1111");

		emp_Login_Action.setLogin(emp_Login);
		
		PowerMockito.when(mockAdmin_Login_DaoImpl.checkLogin(emp_Login)).thenReturn(emp_Login);
		
		Map<String, Object> session = new HashMap<String, Object>();
		emp_Login_Action.setSession(session);
		
		emp_Login_Action.setXyz(mockAdmin_Login_DaoImpl);
		emp_Login_Action.getXyz();
		
		emp_Login_Action.setLoginDAO(mockAdmin_Login_DaoImpl);
		emp_Login_Action.getLoginDAO();
		
		
		Admin_Login changepw= new Admin_Login ();
		changepw.setOldpw("oldpw");
		changepw.setNewpw("newpw");
		changepw.setCnewpw("newpw");
		
		emp_Login_Action.setChpw(changepw);
		emp_Login_Action.getChpw();
		
		emp_Login_Action.setLogin(emp_Login);
		emp_Login_Action.getLogin();
		
		PowerMockito.whenNew(Admin_Login.class).withNoArguments().thenReturn(emp_Login);
		
		emp_Login_Action.getModel();
		

	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
