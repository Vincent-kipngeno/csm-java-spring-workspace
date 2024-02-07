package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tech.csm.model.Product;
import tech.csm.model.Sales;
import tech.csm.repo.ProductRepo;
import tech.csm.repo.SalesRepo;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepo salesRepo;
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Sales saveSales(Sales sales) {
		
		
		Sales s=salesRepo.save(sales);
		Product p=s.getProduct();
		p.setQuantity(p.getQuantity()-s.getSalesQnty());
		productRepo.save(p);
		
		return s;
	}

	@Override
	public List<Sales> getAllSales() {
		return salesRepo.findAll();
	}

	@Override
	public String deleteSalesById(Integer salesId) {
		Sales sales=salesRepo.findById(salesId).get();
		Product p=sales.getProduct();
		p.setQuantity(p.getQuantity()+sales.getSalesQnty());
		productRepo.save(p);
		salesRepo.delete(sales);
		return "1 sales delted";
	}

	@Override
	public Sales getSalesById(Integer salesId) {
		
		return salesRepo.findById(salesId).get();
	}

}
