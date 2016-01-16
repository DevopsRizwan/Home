package daoImpl;

import java.util.Arrays;
import java.util.List;

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
import actionForm.Emp_AddTrans;

import com.opensymphony.xwork2.ActionContext;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Emp_AddTrans_DaoImpl.class, HibernateUtil.class,  ActionContext.class}) 

public class Emp_AddTrans_DaoImplTest {

	@Test
	public void testDeposit(){
		
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("1232"));

		
		Emp_AddTrans empAddTrans = new Emp_AddTrans();
		
		empAddTrans.setClid("dff");
		empAddTrans.setAmount("22");
		empAddTrans.setDetails("Awesome");
		Emp_AddTrans_DaoImpl emp_AddTrans_DaoImpl = new Emp_AddTrans_DaoImpl();
		Emp_AddTrans deposit = emp_AddTrans_DaoImpl.deposit(empAddTrans);
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList());
		
		emp_AddTrans_DaoImpl.deposit(empAddTrans);
		
		
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("fdsf"));
		emp_AddTrans_DaoImpl.deposit(empAddTrans);
	
		Assert.assertNotNull(deposit);
	}
	
	
	@Test
	public void testWithDraw(){
		
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("1232"));

		
		Emp_AddTrans taken = new Emp_AddTrans();
		
		taken.setClid("dff");
		taken.setAmount("22");
		taken.setDetails("Awesome");
		Emp_AddTrans_DaoImpl emp_AddTrans_DaoImpl = new Emp_AddTrans_DaoImpl();
		Emp_AddTrans deposit = emp_AddTrans_DaoImpl.withdrawn(taken);
		Assert.assertNotNull(deposit);
	    PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("2000"));
		emp_AddTrans_DaoImpl.withdrawn(taken);

	}
	
	@Test
	public void testList(){
		
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("1232"));

		
		Emp_AddTrans view = new Emp_AddTrans();
		
		view.setClid("dff");
		view.setAmount("22");
		view.setDetails("Awesome");
		Emp_AddTrans_DaoImpl emp_AddTrans_DaoImpl = new Emp_AddTrans_DaoImpl();
		List<Emp_AddTrans> deposit = emp_AddTrans_DaoImpl.list(view);		
		Assert.assertNotNull(deposit);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("fdf"));
		emp_AddTrans_DaoImpl.list(view);

	}
	
	@Test
	public void testVish(){
		
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("1232"));

		
		Emp_AddTrans view = new Emp_AddTrans();
		
		view.setClid("dff");
		view.setAmount("22");
		view.setDetails("Awesome");
		Emp_AddTrans_DaoImpl emp_AddTrans_DaoImpl = new Emp_AddTrans_DaoImpl();
		Emp_AddTrans deposit = emp_AddTrans_DaoImpl.vish(view);		
		Assert.assertNotNull(deposit);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("fdf"));
		emp_AddTrans_DaoImpl.vish(view);

	   

	}
}
