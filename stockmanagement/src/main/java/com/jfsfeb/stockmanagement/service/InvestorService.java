package com.jfsfeb.stockmanagement.service;

import java.util.List;

import com.jfsfeb.stockmanagement.dto.InvestorRequestObject;
import com.jfsfeb.stockmanagement.dto.InvestorShare;

public interface InvestorService {
	boolean addShare(InvestorRequestObject investor);
	boolean updateStockAvailability(InvestorRequestObject investor, boolean flag);
	List<InvestorShare> getAllShares(int id);

}
