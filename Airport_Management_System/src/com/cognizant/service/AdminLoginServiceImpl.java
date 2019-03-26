package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AdminLoginDAO;
import com.cognizant.entity.Admin;

@Service("AdminLoginServiceImpl")
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	@Override
	public boolean doLogin(Admin admin) {
		// TODO Auto-generated method stub
		return adminLoginDAO.doLogin(admin);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminLoginDAO.addAdmin(admin);
	}

}