package daoImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import actionForm.Client_View;

import com.opensymphony.xwork2.ActionContext;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Client_View_DaoImpl.class, ActionContext.class, HibernateUtil.class})
public class Client_View_DaoImplTest {
	
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
		

		Query mockQuery= PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		Client_View clientView = new Client_View();
		
		Client_View_DaoImpl client_View_DaoImpl = new Client_View_DaoImpl();
		List<Client_View> list = client_View_DaoImpl.list(clientView);
		
		
	}
	
	
	@Test
	public void testListHandleException(){
		
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
		session.put("user", "user");
		session.put("user0", "user0");
		session.put("user1", "user1");
		session.put("user2", "user2");
		
		ActionContext actionContext= new ActionContext(context);
		actionContext.setSession(session);
		PowerMockito.mockStatic(ActionContext.class);
		PowerMockito.when(ActionContext.getContext()).thenReturn(actionContext);
		

		Query mockQuery= PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("dfsd"));
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		Client_View clientView = new Client_View();
		
		Client_View_DaoImpl client_View_DaoImpl = new Client_View_DaoImpl();
		List<Client_View> list = client_View_DaoImpl.list(clientView);
		
		
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
		

		Query mockQuery= PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		
		PowerMockito.when(mockQuery.list()).thenReturn(Arrays.asList("dsd", "sdfs"));
		
		Client_View clientView = new Client_View();
		
		Client_View_DaoImpl client_View_DaoImpl = new Client_View_DaoImpl();
		Client_View list = client_View_DaoImpl.vish(clientView);
		
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("fdfd"));
		client_View_DaoImpl.vish(clientView);

		
		
	}
	
	
	

}
