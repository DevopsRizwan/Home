package daoImpl;

import org.hibernate.HibernateException;
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

import actionForm.Admin_AddEmp;
import actionForm.Emp_Login;
import util.HibernateUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Admin_AddEmp_DaoImpl.class, HibernateUtil.class, SessionFactory.class, Session.class}) 

public class Admin_AddEmp_DaoImplTest {

	@Test
	public final void testAddEmp() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Admin_AddEmp adminAddEmp= PowerMockito.mock(Admin_AddEmp.class);

		Admin_AddEmp_DaoImpl admin_AddEmp_DaoImpl = new Admin_AddEmp_DaoImpl();
		Admin_AddEmp addEmp = admin_AddEmp_DaoImpl.addEmp(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddEmpExceptionHandled() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);

		Admin_AddEmp adminAddEmp= PowerMockito.mock(Admin_AddEmp.class);
		PowerMockito.when(mockSession.save(Mockito.anyString())).thenThrow(new HibernateException("dsd"));

		Admin_AddEmp_DaoImpl admin_AddEmp_DaoImpl = new Admin_AddEmp_DaoImpl();
		Admin_AddEmp addEmp = admin_AddEmp_DaoImpl.addEmp(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddEmps() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Emp_Login mockEmpLogin= PowerMockito.mock(Emp_Login.class);
		mockEmpLogin.setBank_id("222");
		mockEmpLogin.setUserName("testuser");		
		mockEmpLogin.setPassword("password");
		
		Admin_AddEmp_DaoImpl admin_AddEmp_DaoImpl = new Admin_AddEmp_DaoImpl();
		Emp_Login addEmp = admin_AddEmp_DaoImpl.addEmps(mockEmpLogin);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	@Test
	public final void testAddEmpsExceptionHanlded(){
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(mockSession.save(Mockito.anyString())).thenThrow(new HibernateException("sSDAD"));
		Emp_Login mockEmpLogin= PowerMockito.mock(Emp_Login.class);
		mockEmpLogin.setBank_id("222");
		mockEmpLogin.setUserName("testuser");		
		mockEmpLogin.setPassword("password");
		
		Admin_AddEmp_DaoImpl admin_AddEmp_DaoImpl = new Admin_AddEmp_DaoImpl();
		Emp_Login addEmp = admin_AddEmp_DaoImpl.addEmps(mockEmpLogin);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
}
