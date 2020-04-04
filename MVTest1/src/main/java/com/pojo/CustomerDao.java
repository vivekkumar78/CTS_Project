package com.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CustomerDao {
	private Configuration conf;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;

	@SuppressWarnings("deprecation")
	public void saveData(CustomerPojo e) {

		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
	}

	
	

	@SuppressWarnings("deprecation")
	public List displayData() {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from CustomerPojo").list();
		return list;
	}


	//login part
		@SuppressWarnings({ "deprecation", "rawtypes" })
		public List login(String email, String pass) {
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			String sql="from CustomerPojo  as e where e.cemail=? and e.cpass=?";
			Query query1= session.createQuery(sql);
			query1.setParameter(0, email);
			query1.setParameter(1, pass);
			List list = query1.list();
			
			return list;
		}



		//delete data
		public void deleteData(CustomerPojo emp) {
			
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			CustomerPojo obj = (CustomerPojo) session.get(CustomerPojo.class, emp.getCid());
			session.delete(obj);
			tx.commit();
		}


		public void updateData(CustomerPojo emp) {
			
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			CustomerPojo obj = (CustomerPojo) session.get(CustomerPojo.class, emp.getCid());
			 obj.setCemail(emp.getCemail());
			 obj.setCname(emp.getCname());
			 obj.setCaddress(emp.getCaddress());
			 session.update(obj);
			 tx.commit();
		}


		//search data..
		@SuppressWarnings("deprecation")
		public List searchData(CustomerPojo e) {
			List li = new ArrayList();
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			List list = session.createQuery("from CustomerPojo").list();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				CustomerPojo emp = (CustomerPojo)it.next();
				if(e.getCname().equalsIgnoreCase(emp.getCname()))
				{
					CustomerPojo obj = new CustomerPojo();
					obj.setCname(emp.getCname());
					obj.setCemail(emp.getCemail());
					obj.setCaddress(emp.getCaddress());
					li.add(obj);
				}
				
			}
			return li;
		}			


}
