package actionForm;

import java.util.Date;

import org.junit.Test;



public class ActionFormSingleFileForAllTest {

	
	@Test
	public void testAdmin_AddEmpGetterSetter() {
		
		Admin_AddEmp admin_AddEmp = new Admin_AddEmp();
		admin_AddEmp.setAddress("dsad");
		admin_AddEmp.setBank_id("23");
		admin_AddEmp.setBranch("dsad");
		admin_AddEmp.setCity("jai");
		admin_AddEmp.setDob("jun");
		admin_AddEmp.setEmail("email");
		admin_AddEmp.setFirstName("chan");
		admin_AddEmp.setGender("male");
		admin_AddEmp.setId(1L);
		admin_AddEmp.setLandLine("434");
		admin_AddEmp.setLastName("gupta");
		admin_AddEmp.setMiddleName("deep");
		admin_AddEmp.setRole_name("manager");
		admin_AddEmp.setState("raj");
		admin_AddEmp.setMobile("423432");
		
		admin_AddEmp.getAddress();
		admin_AddEmp.getBank_id();
		admin_AddEmp.getBranch();
		admin_AddEmp.getCity();
		admin_AddEmp.getClass();
		admin_AddEmp.getDob();
		admin_AddEmp.getEmail();
		admin_AddEmp.getFirstName();
		admin_AddEmp.getLandLine();
		admin_AddEmp.getLastName();
		admin_AddEmp.getMiddleName();
		admin_AddEmp.getRole_name();
		admin_AddEmp.getState();
		admin_AddEmp.getMobile();
	
	}
	
	@Test
	public void testAdmin_LoginGetterSetter() {
		
		Admin_Login  admin_Login= new Admin_Login();
		
		admin_Login.setBank_id("111");
		admin_Login.setCnewpw("sdsd");
		admin_Login.setNewpw("dsads");
		admin_Login.setPassword("password");
		admin_Login.setOldpw("ddsd");
		admin_Login.setTest("good");
		admin_Login.setUserName("chan");
		
		admin_Login.getBank_id();
		admin_Login.getCnewpw();
		admin_Login.getNewpw();
		admin_Login.getOldpw();
		admin_Login.getPassword();
		admin_Login.getTest();
		admin_Login.getUserName();
		
		
	}
	
	
	@Test
	public void testAdmin_LoginManGetterSetter() {
		
		Admin_LoginMan admin_LoginMan= new Admin_LoginMan();
		
		admin_LoginMan.setBank_id("111");
		admin_LoginMan.setCreated(new Date());
		admin_LoginMan.setId(1L);
		
		admin_LoginMan.getBank_id();
		admin_LoginMan.getCreated();
		admin_LoginMan.getId();
		
	}
	
	
	@Test
	public void testAdmin_EmpChPwGetterSetter() {
		
		Admin_EmpChPW  admimEmpChPw= new Admin_EmpChPW();
		
		admimEmpChPw.setBank_id("111");
		admimEmpChPw.setCnewpw("sdsd");
		admimEmpChPw.setNewpw("dsads");
		admimEmpChPw.setPassword("password");
		admimEmpChPw.setTest("good");
		admimEmpChPw.setUserName("chan");
		
		admimEmpChPw.getBank_id();
		admimEmpChPw.getCnewpw();
		admimEmpChPw.getNewpw();
		admimEmpChPw.getPassword();
		admimEmpChPw.getTest();
		admimEmpChPw.getUserName();
		
		
	}
	@Test
	public void testEmp_AddClientGetterSetter() {
		
		Emp_AddClient  empAddClient= new Emp_AddClient();
		

		empAddClient.setAddress("dsad");
		empAddClient.setBank_id("23");
		empAddClient.setBranch("dsad");
		empAddClient.setCity("jai");
		empAddClient.setDob("jun");
		empAddClient.setEmail("email");
		empAddClient.setFirstName("chan");
		empAddClient.setGender("male");
		empAddClient.setId(1L);
		empAddClient.setLandLine("434");
		empAddClient.setLastName("gupta");
		empAddClient.setMiddleName("deep");
		empAddClient.setState("raj");
		empAddClient.setMobile("423432");
		
		empAddClient.getAddress();
		empAddClient.getBank_id();
		empAddClient.getBranch();
		empAddClient.getCity();
		empAddClient.getClass();
		empAddClient.getDob();
		empAddClient.getEmail();
		empAddClient.getFirstName();
		empAddClient.getLandLine();
		empAddClient.getLastName();
		empAddClient.getMiddleName();
		empAddClient.getState();
		empAddClient.getMobile();
	
	}
	
	
	@Test
	public void testEmp_AddTansGetterSetter() {
		
		Emp_AddTrans  empAddTrans= new Emp_AddTrans();
		empAddTrans.setAmount("23");
		empAddTrans.setClid("Dsa");
		empAddTrans.setCreated(new Date());
		empAddTrans.setDeposit("4324");
		empAddTrans.setDetails("Dsads");
		empAddTrans.setId(1L);
		empAddTrans.setNamount("2342");
		empAddTrans.setPamount("4342");
		empAddTrans.setTest("good");
		empAddTrans.setWithdrawn("234");
		
		
		empAddTrans.getAmount();
		empAddTrans.getClid();
		empAddTrans.getCreated();
		empAddTrans.getDeposit();
		empAddTrans.getDetails();
		empAddTrans.getId();
		empAddTrans.getNamount();
		empAddTrans.getPamount();
		empAddTrans.getTest();
		empAddTrans.getWithdrawn();	
	
	}
	
	@Test
	public void testEmp_LoginManGetterSetter() {
		
		Emp_LoginMan emp_LoginMan= new Emp_LoginMan();
		
		emp_LoginMan.setBank_id("111");
		emp_LoginMan.setCreated(new Date());
		emp_LoginMan.setId(1L);
		
		emp_LoginMan.getBank_id();
		emp_LoginMan.getCreated();
		emp_LoginMan.getId();
		
	}
	
	@Test
	public void testClientViewGetterSetter() {
		
		Client_View  clientView= new Client_View();
		clientView.setAmount("23");
		clientView.setClid("Dsa");
		clientView.setCreated(new Date());
		clientView.setDeposit("4324");
		clientView.setDetails("Dsads");
		clientView.setId(1L);
		clientView.setNamount("2342");
		clientView.setPamount("4342");
		clientView.setTest("good");
		clientView.setWithdrawn("234");
		
		
		clientView.getAmount();
		clientView.getClid();
		clientView.getCreated();
		clientView.getDeposit();
		clientView.getDetails();
		clientView.getId();
		clientView.getNamount();
		clientView.getPamount();
		clientView.getTest();
		clientView.getWithdrawn();	
	
	}
	
	@Test
	public void testBankDetailsGetterSetteer() {
		
		Bank_Detail bankDetails = new Bank_Detail();
		
		bankDetails.setBank_branch_add("jasas");
		bankDetails.setBank_branch_city("jau");
		bankDetails.setBank_branch_name("dsad");
		bankDetails.setId(1L);
		bankDetails.setBank_id(2L);
		bankDetails.setBank_branch_phone("432");
		bankDetails.getBank_branch_add();
		bankDetails.getBank_branch_city();
		bankDetails.getBank_branch_name();
		bankDetails.getBank_id();
		bankDetails.getId();
		bankDetails.getBank_branch_phone();
		
	}
	
	
}
