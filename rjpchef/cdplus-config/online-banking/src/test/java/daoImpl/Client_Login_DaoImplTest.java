package daoImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
import actionForm.Client_Login;

import com.opensymphony.xwork2.ActionContext;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Client_Login_DaoImpl.class, ActionContext.class, HibernateUtil.class})
public class Client_Login_DaoImplTest {

	
	@Test
	public void testcheckLogin(){
		
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
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		
		
		Client_Login mockclientlogin= new Client_Login();
		mockclientlogin.setUserName("usrtest");
		mockclientlogin.setPassword("password");
		mockclientlogin.setBank_id("111");
		
		
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockclientlogin);
		
		Client_Login_DaoImpl client_Login_DaoImpl = new Client_Login_DaoImpl();
		Client_Login checkLogin = client_Login_DaoImpl.checkLogin(mockclientlogin);
	}
	
	@Test
	public void testcheckLoginHasEmptyqeryResult(){
		
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
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		Client_Login mockadminlogin= new Client_Login();
		mockadminlogin.setUserName("usettes");
		mockadminlogin.setPassword("password");
		mockadminlogin.setBank_id("111");
		
		
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.FALSE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockadminlogin);
		
		Client_Login_DaoImpl admin_Login_DaoImpl = new Client_Login_DaoImpl();
		Client_Login checkLogin = admin_Login_DaoImpl.checkLogin(mockadminlogin);
	}
	
	
	@Test
	public void testcheckLoginExceptionHanlded(){
		
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
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("dsadas"));
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		
		
		Client_Login mockadminlogin= new Client_Login();
		mockadminlogin.setUserName("usettes");
		mockadminlogin.setPassword("password");
		mockadminlogin.setBank_id("111");
		
		
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockadminlogin);
		
		Client_Login_DaoImpl admin_Login_DaoImpl = new Client_Login_DaoImpl();
		Client_Login checkLogin = admin_Login_DaoImpl.checkLogin(mockadminlogin);
	}
	
	@Test
	public void testcheckLoginExHandllewithlesslist(){
		
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
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd"));
		
		
		
		Client_Login mockadminlogin= new Client_Login();
		mockadminlogin.setUserName("usettes");
		mockadminlogin.setPassword("password");
		mockadminlogin.setBank_id("111");
		
		
		Iterator mockIterator =PowerMockito.mock(Iterator.class);
		PowerMockito.when(mockQuery.iterate()).thenReturn(mockIterator);
		PowerMockito.when(mockIterator.hasNext()).thenReturn(Boolean.TRUE);
		PowerMockito.when(mockIterator.next()).thenReturn(mockadminlogin);
		
		Client_Login_DaoImpl admin_Login_DaoImpl = new Client_Login_DaoImpl();
		Client_Login checkLogin = admin_Login_DaoImpl.checkLogin(mockadminlogin);
	}
	
	@Test
	public void changepw(){
			
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
			
			Client_Login mockadminlogin = new Client_Login();
			
			mockadminlogin.setOldpw("password");
			mockadminlogin.setNewpw("password");
			mockadminlogin.setTest("good");
			
			Client_Login_DaoImpl admin_Login_DaoImpl = new Client_Login_DaoImpl();
			Client_Login checkLogin = admin_Login_DaoImpl.changepw(mockadminlogin);
			Assert.assertNotNull(checkLogin);
				
		}
	
	
		
	
	
	@Test
	public void changepwExceptionHanlded(){
			
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
			PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("Dsds"));
			PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsdas", "dsads"));
			PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
			
			Client_Login mockadminlogin = new Client_Login();
			
			mockadminlogin.setOldpw("password");
			mockadminlogin.setNewpw("password");
			mockadminlogin.setTest("good");
			
			Client_Login_DaoImpl admin_Login_DaoImpl = new Client_Login_DaoImpl();
			Client_Login checkLogin = admin_Login_DaoImpl.changepw(mockadminlogin);
			Assert.assertNotNull(checkLogin);
				
		}

}
