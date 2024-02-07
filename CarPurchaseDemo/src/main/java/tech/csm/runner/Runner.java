package tech.csm.runner;

import java.util.List;
import java.util.Scanner;

import tech.csm.entity.Category;
import tech.csm.entity.Product;
import tech.csm.entity.Purchase;
import tech.csm.service.CategoryService;
import tech.csm.service.CategoryServiceImpl;
import tech.csm.service.ProductService;
import tech.csm.service.ProductServiceImpl;
import tech.csm.service.PurchaseService;
import tech.csm.service.PurchaseServiceImpl;
import tech.csm.util.DBUtil;

public class Runner {
	//get all category service
	private static CategoryService  categoryService= new CategoryServiceImpl();
	private static ProductService productService=new ProductServiceImpl();
	private static PurchaseService purchaseService=new PurchaseServiceImpl();
	
public static void main(String[] args) {

//	//getting all categories
//	List<Category> categoryList=categoryService.getAllCategories();
//	System.out.println(categoryList);
	
//	//get products by category id
//	List<Product> productlist= productService.getProductByCategoryId(100);
//	System.out.println(productlist);
	
	Scanner sc=new Scanner(System.in);
	Scanner ss=new Scanner(System.in);
	int choice=0;
	do {
		System.out.println("\n1.Create purchase\n2.Show all purchases\n3.Exit");
		System.out.println("Enter choice");
		choice=sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("enter the customer name:");
			String customerName=ss.nextLine();
			System.out.println("Enter the cutomer phone number");
			String customerphone=ss.nextLine();
			System.out.println("Enter the category id"+categoryService.getAllCategories());
			Integer cid=sc.nextInt();
			System.out.println("Enter product id:"+productService.getProductByCategoryId(cid));
			Integer pidInteger =sc.nextInt();
			
			Purchase purchase =new Purchase();
			
			Category c=new Category();
			c.setCId(cid);
			purchase.setCategory(c);
			
			purchase.setCustomerName(customerName);
			purchase.setCustomerPhoneNo(customerphone);
			
			Product p=new Product();
			p.setPId(pidInteger);
			purchase.setProduct(p);
			
			String createpurchase =purchaseService.createPurchase(purchase);
			System.out.println(createpurchase);
			
			break;
			
		case 2:
			//get all purchases
			List<Purchase> purchaseList =purchaseService.getAllPurchases();
			System.out.println(purchaseList);
			break;

		case 3:
			break;
		default:
			System.out.println("Enter a deafult value!");
			break;
		}
		
	} while (choice>3);
}
}
