package tech.csm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
import tech.csm.model.Customer;
import tech.csm.model.Product;
import tech.csm.model.Sales;
import tech.csm.service.CustomerService;
import tech.csm.service.ProductService;
import tech.csm.service.SalesService;

@Controller
public class SalesController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/getsales")
	public String getSalesForm(Model model) {
		
		List<Product> productList=productService.getAllProducts();
		List<Customer> customerList=customerService.getAllCustomers();
		List<Sales> salesList=salesService.getAllSales();
		
		model.addAttribute("productList", productList);
		model.addAttribute("customerList", customerList);
		model.addAttribute("salesList",salesList);
		return "salesform";
	}
	@PostMapping("/saveSales")
	public String saveSales(@ModelAttribute Sales sales, RedirectAttributes rd) {
		sales.setSalesDate(new Date());
		Sales s=salesService.saveSales(sales);	
		rd.addFlashAttribute("msg", "one sales done successfully with id: "+s.getSalesId());
		return "redirect:./getsales";
		
	}
	@GetMapping("/getProductQntyByProductId")
	public void getProductQntyByProductId(@RequestParam("productId") Integer productId,HttpServletResponse resp) throws IOException {
		Product p=productService.getProductById(productId);
		resp.getWriter().print(p.getQuantity());
	}
	@GetMapping("/delSales")
	public String deleteSalesById(@RequestParam("sId") Integer salesId, RedirectAttributes rd) {
		String msg=salesService.deleteSalesById(salesId);
		rd.addFlashAttribute("msg", msg);
		
		return "forward:/getdelform";
//		return "redirect:./getsales";
	}
	@GetMapping("/getdelform")
	public String getDelScreen() {
		
		
		
		return "delform";
	}
	
	
	
	
	@GetMapping("/upSales")
	public String updateSalesById(Model model,@RequestParam("sId") Integer salesId) {
		Sales sales=salesService.getSalesById(salesId);		
		List<Product> productList=productService.getAllProducts();
		List<Customer> customerList=customerService.getAllCustomers();
		List<Sales> salesList=salesService.getAllSales();
		
		model.addAttribute("usales", sales);
		model.addAttribute("productList", productList);
		model.addAttribute("customerList", customerList);
		model.addAttribute("salesList",salesList);
		return "salesform";
	}
	
	
}
