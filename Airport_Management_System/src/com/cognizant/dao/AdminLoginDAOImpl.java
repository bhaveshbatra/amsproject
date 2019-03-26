package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Admin;
@Repository("AdminDAOImpl")
public class AdminLoginDAOImpl implements AdminLoginDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean doLogin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=
				session.createQuery("select o from Admin o where o.Email=:email and o.password=:password");
		query.setParameter("email", admin.getEmail());
		query.setParameter("password", admin.getPassword());
		List<Admin> adminList=query.list();
		
		if(adminList.isEmpty())
			return false;
		else
		return true;
	}
	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(admin);
		tx.commit();
		session.close();
		return true;
	}

}
