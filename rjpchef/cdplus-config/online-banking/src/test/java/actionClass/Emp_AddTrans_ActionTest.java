package actionClass;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Emp_AddTrans;
import daoImpl.Emp_AddTrans_DaoImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Emp_AddTrans_Action.class,Emp_AddTrans.class})
public class Emp_AddTrans_ActionTest {

	@Test
	public void testEmpAddTransDeposit() throws Exception{

		Emp_AddTrans empDetails = new Emp_AddTrans();
		
		Emp_AddTrans_DaoImpl mocknew = PowerMockito.mock(Emp_AddTrans_DaoImpl.class);
		PowerMockito.whenNew(Emp_AddTrans_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		Emp_AddTrans mockAdminEmp = PowerMockito.mock(Emp_AddTrans.class);
		PowerMockito.when(mocknew.deposit(mockAdminEmp)).thenReturn(empDetails);
				
		String addEmp = new Emp_AddTrans_Action().deposit();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddTrans_DaoImpl.class);
	}
	
	
	@Test
	public void testEmpAddTransWithdraw() throws Exception{

		Emp_AddTrans empTra = new Emp_AddTrans();
		empTra.setTest("yes");
		empTra.setPamount("55");
		
		Emp_AddTrans_DaoImpl mocknew = PowerMockito.mock(Emp_AddTrans_DaoImpl.class);
		PowerMockito.whenNew(Emp_AddTrans_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		PowerMockito.when(mocknew.withdrawn(empTra)).thenReturn(empTra);
				
		Emp_AddTrans_Action emp_AddTrans_Action = new Emp_AddTrans_Action();
		
		emp_AddTrans_Action.setWith(empTra);
		String addEmp = emp_AddTrans_Action.withdrawn();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddTrans_DaoImpl.class);
	}
	
	@Test
	public void testEmpAddTransWithdrawTestfalse() throws Exception{

		Emp_AddTrans empTra = new Emp_AddTrans();
		empTra.setTest("no");
		empTra.setPamount("55");
		
		Emp_AddTrans_DaoImpl mocknew = PowerMockito.mock(Emp_AddTrans_DaoImpl.class);
		PowerMockito.whenNew(Emp_AddTrans_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		PowerMockito.when(mocknew.withdrawn(empTra)).thenReturn(empTra);
				
		Emp_AddTrans_Action emp_AddTrans_Action = new Emp_AddTrans_Action();
		
		emp_AddTrans_Action.setWith(empTra);
		String addEmp = emp_AddTrans_Action.withdrawn();

		Assert.assertEquals(addEmp, "error");
		PowerMockito.verifyNew(Emp_AddTrans_DaoImpl.class);
	}
	
	
	@Test
	public void testEmpAddTransviewcls() throws Exception{

		Emp_AddTrans views = new Emp_AddTrans();
		views.setTest("no");
		views.setPamount("55");
		
		Emp_AddTrans_DaoImpl mocknew = PowerMockito.mock(Emp_AddTrans_DaoImpl.class);
		PowerMockito.whenNew(Emp_AddTrans_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		List<Emp_AddTrans> mockList = new ArrayList<Emp_AddTrans>();
		mockList.add(views);
		PowerMockito.when(mocknew.list(views)).thenReturn(mockList);
						
		Emp_AddTrans_Action emp_AddTrans_Action = new Emp_AddTrans_Action();
		
		emp_AddTrans_Action.setWith(views);
		emp_AddTrans_Action.setViews(views);
		
		String addEmp = emp_AddTrans_Action.viewcls();

		Assert.assertEquals(addEmp, "success");
		PowerMockito.verifyNew(Emp_AddTrans_DaoImpl.class);
	}
	
	@Test
	public void testSetGetWithcoverage() throws Exception{

		Emp_AddTrans views = new Emp_AddTrans();
		views.setTest("no");
		views.setPamount("55");
		
		Emp_AddTrans_DaoImpl mocknew = PowerMockito.mock(Emp_AddTrans_DaoImpl.class);
		PowerMockito.whenNew(Emp_AddTrans_DaoImpl.class).withNoArguments().thenReturn(mocknew);
		
		List<Emp_AddTrans> mockList = new ArrayList<Emp_AddTrans>();
		mockList.add(views);
		PowerMockito.when(mocknew.list(views)).thenReturn(mockList);
						
		Emp_AddTrans_Action emp_AddTrans_Action = new Emp_AddTrans_Action();
		
		emp_AddTrans_Action.setWith(views);
		emp_AddTrans_Action.getWith();
		
		emp_AddTrans_Action.setViews(views);
		emp_AddTrans_Action.getViews();
		
		emp_AddTrans_Action.setDepo(views);
		emp_AddTrans_Action.getDepo();
		
		emp_AddTrans_Action.setXyz(mocknew);
		emp_AddTrans_Action.getXyz();
		
		emp_AddTrans_Action.setDetailList(mockList);
		emp_AddTrans_Action.getDetailList();
		


		PowerMockito.verifyNew(Emp_AddTrans_DaoImpl.class);
		
		
	}
	
	
	
}
