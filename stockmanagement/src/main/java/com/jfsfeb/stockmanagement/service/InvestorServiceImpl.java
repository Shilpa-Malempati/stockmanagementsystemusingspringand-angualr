package com.jfsfeb.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.stockmanagement.dao.CompanyDAO;
import com.jfsfeb.stockmanagement.dao.InvestorDAO;
import com.jfsfeb.stockmanagement.dao.UserDAO;
import com.jfsfeb.stockmanagement.dto.InvestorRequestObject;
import com.jfsfeb.stockmanagement.dto.InvestorShare;
import com.jfsfeb.stockmanagement.exception.ValidationException;
import com.jfsfeb.stockmanagement.util.Validation;

@Service
public class InvestorServiceImpl implements InvestorService{
	@Autowired
	InvestorDAO dao;
	@Autowired
	UserDAO userDao;
	@Autowired
	CompanyDAO companyDao;

	@Override
	public boolean addShare(InvestorRequestObject investor) {
		 if(userDao.getUser(investor.getUserId()) == null ||
	    		 companyDao.getCompany(investor.getCompanyId()) == null){
		   System.out.println("Given id doesn't exists");
	     }
		Validation v = new Validation();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.addShare(investor);
	}
	
	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {
		Validation v = new Validation();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.updateStockAvailability(investor, flag);
	}
	
	
	
	

	@Override
	public List<InvestorShare> getAllShares(int id) {
		
		return dao.getAllShares(id);
	}

}

