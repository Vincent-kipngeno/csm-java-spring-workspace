package tech.csm.controller;

import java.util.List;
import java.util.Scanner;

import tech.csm.domain.ProductVO;
import tech.csm.service.ProductService;
import tech.csm.service.ProductServiceImpl;
import tech.csm.util.DBUtil;

public class POSController {

	private static ProductService productService=new ProductServiceImpl();
	
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);	
		
		int choice;	
		char ck='n';
		do {
			System.out.println(
					"\n1.Create Bill\n2.Show Bill\n" 
							+ "3.Exit\n"
							+ "Enter your Choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				
				break;
			case 2:
				
				break;
			
			case 3:
				
				System.out.println("Are you sure [y/n]:");
				ck=ss.nextLine().charAt(0);
				if(ck=='y')
					DBUtil.closeConnection();
				break;
			default:
				System.out.println("invalid option!!");
			}

		} while (choice != 3 || (choice == 3 && ck !='y'));

	}

}
