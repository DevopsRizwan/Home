package actionClass;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Admin_EmpChPW;
import daoImpl.Admin_EmpChPW_DaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Admin_EmpChPW_Action.class, Admin_EmpChPW.class, Admin_EmpChPW_DaoImpl.class })
public class Admin_EmpChPW_ActionTest {

	@Test
	public void changeEmpPwEmptyNewPw() {
		
		Admin_EmpChPW_Action admin_EmpChPW_Action = new Admin_EmpChPW_Action();
		Admin_EmpChPW admin_EmpChPW = new Admin_EmpChPW();
		admin_EmpChPW.setCnewpw("passwd");
		admin_EmpChPW.setNewpw("");
		admin_EmpChPW.setBank_id("111");
		
		admin_EmpChPW_Action.setChpw(admin_EmpChPW);
		
		String changepw = admin_EmpChPW_Action.changepw();
		Assert.assertEquals(changepw, "error");
	}
	
	@Test
	public void changeEmpPwWithemptyCnewPw() {
		
		Admin_EmpChPW_Action admin_EmpChPW_Action = new Admin_EmpChPW_Action();
		Admin_EmpChPW admin_EmpChPW = new Admin_EmpChPW();

		admin_EmpChPW.setNewpw("password");
		admin_EmpChPW.setCnewpw("");
		admin_EmpChPW.setBank_id("111");
		
		admin_EmpChPW_Action.setChpw(admin_EmpChPW);
		
		String changepw = admin_EmpChPW_Action.changepw();
		Assert.assertEquals(changepw, "error");
	}
	
	@Test
	public void changeEmpPwWithemptyBankId() {
		
		Admin_EmpChPW_Action admin_EmpChPW_Action = new Admin_EmpChPW_Action();
		Admin_EmpChPW admin_EmpChPW = new Admin_EmpChPW();

		admin_EmpChPW.setNewpw("password");
		admin_EmpChPW.setCnewpw("password");
		admin_EmpChPW.setBank_id("");
		
		admin_EmpChPW_Action.setChpw(admin_EmpChPW);
		
		String changepw = admin_EmpChPW_Action.changepw();
		Assert.assertEquals(changepw, "error");
	}
	
	@Test
	public void changeEmpPwWithequalCnewPwAndNewpw() throws Exception {
		
		Admin_EmpChPW_DaoImpl mocknew =	PowerMockito.mock(Admin_EmpChPW_DaoImpl.class);
		PowerMockito.whenNew(Admin_EmpChPW_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		
		Admin_EmpChPW admin_EmpChPW = new Admin_EmpChPW();
		admin_EmpChPW.setNewpw("password");
		admin_EmpChPW.setCnewpw("password");
		admin_EmpChPW.setBank_id("111");
	
		PowerMockito.when(mocknew.changepw(admin_EmpChPW)).thenReturn(admin_EmpChPW);
		
		Admin_EmpChPW_Action admin_EmpChPW_Action = new Admin_EmpChPW_Action();
		admin_EmpChPW_Action.setChpw(admin_EmpChPW);		
		
		String changepw = admin_EmpChPW_Action.changepw();
		admin_EmpChPW_Action.getChpw();
		
		admin_EmpChPW_Action.setXyz(mocknew);
		admin_EmpChPW_Action.getXyz();
		Assert.assertEquals(changepw, "success");
	}
	
	
	@Test
	public void changeEmpPwWithUnequalCnewPwAndNewpw() throws Exception {
		
		Admin_EmpChPW_DaoImpl mocknew =	PowerMockito.mock(Admin_EmpChPW_DaoImpl.class);
		PowerMockito.whenNew(Admin_EmpChPW_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		
		Admin_EmpChPW admin_EmpChPW = new Admin_EmpChPW();
		admin_EmpChPW.setNewpw("password");
		admin_EmpChPW.setCnewpw("password1");
		admin_EmpChPW.setBank_id("111");
	
		PowerMockito.when(mocknew.changepw(admin_EmpChPW)).thenReturn(admin_EmpChPW);
		
		Admin_EmpChPW_Action admin_EmpChPW_Action = new Admin_EmpChPW_Action();
		admin_EmpChPW_Action.setChpw(admin_EmpChPW);		
		
		String changepw = admin_EmpChPW_Action.changepw();
		Assert.assertEquals(changepw, "error");
	}
	

}
