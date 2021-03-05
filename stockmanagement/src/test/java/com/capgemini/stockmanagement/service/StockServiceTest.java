package com.capgemini.stockmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfsfeb.stockmanagement.dto.Stock;
import com.jfsfeb.stockmanagement.service.StockService;

@SpringBootTest
class StockServiceTest {

	@Autowired
	private StockService service;
	private Stock stock = new Stock();

	@Test
	void testAddStock() {
		try {
			Stock stock = new Stock();
			stock.setCompanyId("2");
			stock.setPrice("400000");
			boolean result = service.addStock(stock);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addStock(stock);
			});
		}

	}

	@Test
	void testDeleteStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(345);
			boolean result = service.deleteStock(stock.getStockId());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addStock(stock);
			});
		}
	}

	@Test
	void testUpdateStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(1);
			stock.setPrice("6700000");
			boolean result = service.updateStock(stock.getStockId(), stock);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addStock(stock);
			});
		}
	}

	@Test
	void testGetAllStocks() {
		List<Stock> company = service.getAllStocks();
		assertNotNull(company);
	}

	@Test
	void testSearchStock() {
		try {
			Stock stock = new Stock();
			stock.setStockId(2);
			Stock result = service.searchStock(stock.getStockId());
			assertNotNull(result);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addStock(stock);
			});
		}
	}
}