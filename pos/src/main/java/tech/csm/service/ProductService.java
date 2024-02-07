package tech.csm.service;

import java.util.List;

import tech.csm.domain.ProductVO;

public interface ProductService {

	List<ProductVO> getAllProducts();

	ProductVO getProductById(Integer pId);

}
