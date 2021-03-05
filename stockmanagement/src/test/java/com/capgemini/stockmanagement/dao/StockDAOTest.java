package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfsfeb.stockmanagement.dao.StockDAO;
import com.jfsfeb.stockmanagement.dto.Stock;

@SpringBootTest
class StockDAOTest {

	@Autowired
	private StockDAO dao;
	private Stock stock = new Stock();

	@Test
	void testAddStock() {
		try {
			Stock stock = new Stock();
			stock.setCompanyId("2");
			stock.setPrice("400000");
			boolean result = dao.addStock(stock);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addStock(stock);
			});
		}
	}

	@Test
	void testDeleteStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(345);
			boolean result = dao.deleteStock(stock.getStockId());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addStock(stock);
			});
		}
	}

	@Test
	void testUpdateStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(1);
			stock.setPrice("6700000");
			boolean result = dao.updateStock(stock.getStockId(), stock);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addStock(stock);
			});
		}
	}

	@Test
	void testGetAllStocks() {
		List<Stock> company = dao.getAllStocks();
		assertNotNull(company);
	}

	@Test
	void testSearchStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(2);
			Stock result = dao.searchStock(stock.getStockId());
			assertNotNull(result);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addStock(stock);
			});
		}
	}

}
