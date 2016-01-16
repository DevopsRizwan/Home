package actionClass;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import actionForm.Bank_Detail;
import daoImpl.Bank_Detail_DaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Bank_Detail_Action.class, Bank_Detail_DaoImpl.class,Bank_Detail.class })
public class Bank_Detail_ActionTest {

	
	@Test
	public void testAddbank() {
		String addBank = new Bank_Detail_Action().addBank();
		Assert.assertEquals(addBank, "success");

	}
	
	@Test
	public void testExecute() throws Exception {
		
		Bank_Detail_DaoImpl mockBank_Detail_DaoImpl	=PowerMockito.mock(Bank_Detail_DaoImpl.class);
		PowerMockito.whenNew(Bank_Detail_DaoImpl.class).withNoArguments().thenReturn(mockBank_Detail_DaoImpl);
		
		List<Bank_Detail> mockbankdetlist = new ArrayList<Bank_Detail>();
		
		Bank_Detail bankDetails= new Bank_Detail();
		mockbankdetlist.add(bankDetails);
		PowerMockito.when(mockBank_Detail_DaoImpl.list()).thenReturn(mockbankdetlist);
		
		
		Bank_Detail_Action bank_Detail_Action = new Bank_Detail_Action();
		String addBank = bank_Detail_Action.execute();
		bank_Detail_Action.setDetailMan(mockBank_Detail_DaoImpl);
		bank_Detail_Action.getDetailMan();
		bank_Detail_Action.setDetailList(mockbankdetlist);
		bank_Detail_Action.getDetailList();
		bank_Detail_Action.setDetails(bankDetails);
		bank_Detail_Action.getDetails();
		Assert.assertEquals(addBank, "success");

	}

}
