package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.CustomerDao;
import com.pojo.CustomerPojo;


@Controller
public class ControllerImpl {

	private ApplicationContext conn;
	@RequestMapping("/register1")
	public String view11(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerPojo  cus = conn.getBean("info", CustomerPojo.class);
		m.addAttribute("bean",cus);
		return "cregister";
	}
	
	
	// ----------------------------------------------
	@RequestMapping("/save")
	public String view3(@ModelAttribute("bean") CustomerPojo e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao obj = conn.getBean("dao", CustomerDao.class);
		obj.saveData(e);
		m.addAttribute("msg", "record inserted..");
		return "cregister";
	}

	//display

	@RequestMapping("/display")	
	public String view191(Model m )
	{		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao  obj = conn.getBean("dao", CustomerDao.class);
		List list  = obj.displayData();
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else {
		m.addAttribute("msg", "no data found..");
		}
		return "display";
	}
	// login
	
	@RequestMapping("/login")
	public String view51(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerPojo  obj = conn.getBean("info", CustomerPojo.class);
		m.addAttribute("bean",obj);
		return "clogin";
	}

	//login data
	
	@RequestMapping("/logindata")
	public String login21(@ModelAttribute("bean") CustomerPojo  obj,Model m,HttpServletRequest request) {
		
		// =  new Employee();		
		obj.setCemail(request.getParameter("cemail"));
		obj.setCpass(request.getParameter("cpass"));
		
		String email = obj.getCemail();
		String pass = obj.getCpass();

		CustomerDao  obj1 =  new CustomerDao();
		
		List list = obj1.login(email,pass);
		if((list!=null) && (list.size()>0))
		{

			return "home";
		}
		else{
			m.addAttribute("msg","login failed.try again..");
			return "clogin";	
			
		}
			
			
			
}
	
	//delete
	@RequestMapping("/delete1")
	public String view7(@ModelAttribute("bean") CustomerPojo csp, Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao obj = conn.getBean("dao", CustomerDao.class);
		obj.deleteData(csp);
		m.addAttribute("msg3", "Successfully Deleted Entry..");
		return "display";
		//return "home";

	}

	
	

	//update
	@RequestMapping("/update1")
	public String view314(@ModelAttribute("bean") CustomerPojo emp, Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao obj = conn.getBean("dao", CustomerDao.class);
		obj.updateData(emp);
		m.addAttribute("msg2", "Successfully Updated..");

		return "display";


	}
	//search part
	//search
		@RequestMapping("/find")
		public String view33(Model m)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			CustomerPojo  emp = conn.getBean("info", CustomerPojo.class);
			m.addAttribute("bean",emp);
			return "search";
		}

		@RequestMapping("/search1")
		public String view34(@ModelAttribute("bean") CustomerPojo e,Model m,HttpServletRequest request)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			CustomerDao obj = conn.getBean("dao", CustomerDao.class);
			List list = obj.searchData(e);
			if(!list.isEmpty())
			{
				m.addAttribute("li", list);
			}
			else {
				m.addAttribute("msg1","no record found..");
			}
			return "search";
		}

}
