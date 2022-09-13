package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductDAO {
	@Autowired
	ProductRepo repo;

	public Product insert(Product p) {
		
		return repo.save(p);
	}
	public List<Product> getall(){
		return repo.findAll();
	}
	public Product update(Product p) {
			Product ee=repo.findById(p.getPid()).orElse(null);
			ee.setPname(p.getPname());
			ee.setCost(p.getCost());
			return repo.save(ee);
			
	}
	public void delete(int id) {
	repo.deleteById(id);
	}

}
