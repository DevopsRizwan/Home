package daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.opensymphony.xwork2.ActionContext;

import actionForm.Admin_AddEmp;
import actionForm.Client_Login;
import actionForm.Emp_AddClient;
import actionForm.Emp_Login;
import util.HibernateUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Emp_AddClient_DaoImpl.class, HibernateUtil.class, SessionFactory.class, 
	Session.class, Emp_AddClient.class, Emp_AddClient.class, ActionContext.class}) 

public class Emp_AddClient_DaoImplTest {
	
	
	
	@Test
	public final void testAddClient() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Emp_AddClient adminAddEmp= PowerMockito.mock(Emp_AddClient.class);

		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		Emp_AddClient addEmp = admin_AddEmp_DaoImpl.addClient(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddClientExceptionHanlded() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		final Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Emp_AddClient adminAddEmp= PowerMockito.mock(Emp_AddClient.class);
		PowerMockito.when(mockSession.save(adminAddEmp)).thenThrow(new HibernateException("exceptin hankded"));


		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		Emp_AddClient addEmp = admin_AddEmp_DaoImpl.addClient(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddClients() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Client_Login mockEmpLogin= PowerMockito.mock(Client_Login.class);
		mockEmpLogin.setBank_id("222");
		mockEmpLogin.setUserName("testuser");		
		mockEmpLogin.setPassword("password");

		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		
		Client_Login addEmp = admin_AddEmp_DaoImpl.addClients(mockEmpLogin);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddClientsExceptionHanlded() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Client_Login mockEmpLogin= PowerMockito.mock(Client_Login.class);
		mockEmpLogin.setBank_id("222");
		mockEmpLogin.setUserName("testuser");		
		mockEmpLogin.setPassword("password");
		PowerMockito.when(mockSession.save(Mockito.anyString())).thenThrow(new HibernateException("sss"));
		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		
		Client_Login addEmp = admin_AddEmp_DaoImpl.addClients(mockEmpLogin);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testEClients() {
		
		
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("test", "test");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		
		Emp_AddClient eclient= PowerMockito.mock(Emp_AddClient.class);
		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		Emp_AddClient addEmp = admin_AddEmp_DaoImpl.eclient(eclient);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}

	
	@Test
	public final void testEClientsExceptionHanldled() {
		
		
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("test", "test");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("sddd"));
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		
		Emp_AddClient eclient= PowerMockito.mock(Emp_AddClient.class);
		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		Emp_AddClient addEmp = admin_AddEmp_DaoImpl.eclient(eclient);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}

	
	
	
	@Test
	public final void testlistClients() {
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("test", "test");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		


		Emp_AddClient edit= PowerMockito.mock(Emp_AddClient.class);
		edit.setBank_id("111");
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		
		
		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		List<Emp_AddClient> addEmp = admin_AddEmp_DaoImpl.list(edit);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testlistClientsExceptionHanlded() {
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("test", "test");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		


		Emp_AddClient edit= PowerMockito.mock(Emp_AddClient.class);
		edit.setBank_id("111");
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("ssss"));
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		
		
		
		Emp_AddClient_DaoImpl admin_AddEmp_DaoImpl = new Emp_AddClient_DaoImpl();
		List<Emp_AddClient> addEmp = admin_AddEmp_DaoImpl.list(edit);
		
		
	}
}
