package daoImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import util.HibernateUtil;
import actionForm.Bank_Detail;
import actionForm.Client_Login;

import com.opensymphony.xwork2.ActionContext;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Bank_Detail_DaoImpl.class,HibernateUtil.class})

public class Bank_Detail_DaoImplTest {
	
	@Test
	public void testlist(){
		
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		
		Query mockQuery= PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		Bank_Detail_DaoImpl bank_Detail_DaoImpl = new Bank_Detail_DaoImpl();
		List<Bank_Detail> list = bank_Detail_DaoImpl.list();
		
		Assert.assertNotNull(list);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("dsdas"));
		list =bank_Detail_DaoImpl.list();


	}
	

	@Test
	public void testaddBank(){
		
		Bank_Detail bankDetail = new Bank_Detail();
		Bank_Detail_DaoImpl bank_Detail_DaoImpl = new Bank_Detail_DaoImpl();
		bank_Detail_DaoImpl.addBank(bankDetail);
	}
		
	
	
	
	

}
