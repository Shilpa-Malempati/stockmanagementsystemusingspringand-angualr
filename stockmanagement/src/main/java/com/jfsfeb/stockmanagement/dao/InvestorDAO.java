package com.jfsfeb.stockmanagement.dao;

import java.util.List;

import com.jfsfeb.stockmanagement.dto.InvestorRequestObject;
import com.jfsfeb.stockmanagement.dto.InvestorShare;

public interface InvestorDAO {
	boolean addShare(InvestorRequestObject investor);
	boolean updateStockAvailability(InvestorRequestObject investor, boolean flag);
	List<InvestorShare> getAllShares(int id);
}
