package daoImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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

import util.HibernateUtil;

import com.opensymphony.xwork2.ActionContext;

import actionForm.Emp_Login;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Emp_Login_DaoImpl.class, ActionContext.class, SessionFactory.class, Session.class, HibernateUtil.class, Iterator.class})
public class Emp_Login_DaoImplTest {
	
	@Test
	public void testCheckLogin(){
		
		
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
		
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		
		
		Emp_Login mockEmplogin = new Emp_Login();
		mockEmplogin.setBank_id("222");
		mockEmplogin.setUserName("testusr");
		mockEmplogin.setPassword("password");
		Query mockQuery= PowerMockito.mock(Query.class);
		mockQuery.setParameter("one", "one");
		mockQuery.setParameter("two", "two");
		mockQuery.setEntity("xdsds", "dsad");

		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockEmplogin);
		
		List<String> list = Arrays.asList("onme", "twp");
		PowerMockito.when(mockQuery.list()).thenReturn(list);
		
		
		Emp_Login_DaoImpl emp_Login_DaoImpl = new Emp_Login_DaoImpl();
		
		Emp_Login checkLogin = emp_Login_DaoImpl.checkLogin(mockEmplogin);
		Assert.assertNotNull(checkLogin);
	}
	
	
	@Test
	public void testCheckLoginHandleException(){
		
		
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
		
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		
		
		Emp_Login mockEmplogin = new Emp_Login();
		mockEmplogin.setBank_id("222");
		mockEmplogin.setUserName("testusr");
		mockEmplogin.setPassword("password");
		Query mockQuery= PowerMockito.mock(Query.class);
		mockQuery.setParameter("one", "one");
		mockQuery.setParameter("two", "two");
		mockQuery.setEntity("xdsds", "dsad");

		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("dsds"));
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockEmplogin);
		
		List<String> list = Arrays.asList("onme", "twp");
		PowerMockito.when(mockQuery.list()).thenReturn(list);
		
		
		Emp_Login_DaoImpl emp_Login_DaoImpl = new Emp_Login_DaoImpl();
		
		Emp_Login checkLogin = emp_Login_DaoImpl.checkLogin(mockEmplogin);
		Assert.assertNotNull(checkLogin);
	}
	
	@Test
	public void testCheckLoginHandleException2(){
		
		
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
		
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		
		
		Emp_Login mockEmplogin = new Emp_Login();
		mockEmplogin.setBank_id("222");
		mockEmplogin.setUserName("testusr");
		mockEmplogin.setPassword("password");
		
		Query mockQuery= PowerMockito.mock(Query.class);
		mockQuery.setParameter("one", "one");
		mockQuery.setParameter("two", "two");
		mockQuery.setEntity("xdsds", "dsad");

		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockEmplogin);
		
		Emp_Login_DaoImpl emp_Login_DaoImpl = new Emp_Login_DaoImpl();
		
		Emp_Login checkLogin = emp_Login_DaoImpl.checkLogin(mockEmplogin);
		Assert.assertNotNull(checkLogin);
	}
	
	@Test
	public void testChangpw(){
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsdas", "dsads"));
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		
		Emp_Login emplogin = new Emp_Login();
		
		emplogin.setOldpw("password");
		emplogin.setNewpw("password");
		emplogin.setTest("good");
		
		Emp_Login_DaoImpl emp_Login_DaoImpl = new Emp_Login_DaoImpl();
		Emp_Login checkLogin = emp_Login_DaoImpl.changepw(emplogin);
		Assert.assertNotNull(checkLogin);
			
	}
	
	@Test
	public void testChangpwExcpetionHanldled(){
		
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
		
		
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Query mockQuery= PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("Dasdasd"));
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsdas", "dsads"));
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));

		Emp_Login emplogin = new Emp_Login();
		
		emplogin.setOldpw("password");
		emplogin.setNewpw("password");
		emplogin.setTest("good");
		
		Emp_Login_DaoImpl emp_Login_DaoImpl = new Emp_Login_DaoImpl();
		Emp_Login checkLogin = emp_Login_DaoImpl.changepw(emplogin);
		Assert.assertNotNull(checkLogin);
		
		
		
		
	}
}
