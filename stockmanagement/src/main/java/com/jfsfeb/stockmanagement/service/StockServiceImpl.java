package com.jfsfeb.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.stockmanagement.dao.CompanyDAO;
import com.jfsfeb.stockmanagement.dao.StockDAO;
import com.jfsfeb.stockmanagement.dto.Stock;
import com.jfsfeb.stockmanagement.exception.ValidationException;
import com.jfsfeb.stockmanagement.util.Validation;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockDAO dao;
	@Autowired
	CompanyDAO companyDao;
	@Override
	public boolean addStock(Stock stock) {
		 if(companyDao.getCompany(stock.getCompanyId()) == null){
		   System.out.println("Given id doesn't exists");
	     }
		Validation v = new Validation();
		String companyId = stock.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			stock.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.addStock(stock);
	}

	@Override
	public boolean deleteStock(int stockId) {
		return dao.deleteStock(stockId);
	}

	@Override
	public boolean updateStock(int stockId, Stock stock) {
		Validation v = new Validation();
		String companyId = stock.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			stock.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.updateStock(stockId, stock);
	}

	@Override
	public List<Stock> getAllStocks() {
		return dao.getAllStocks();
	}

	@Override
	public Stock searchStock(int stockId) {
		return dao.searchStock(stockId);
	}
}
