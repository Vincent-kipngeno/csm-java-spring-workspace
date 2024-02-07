package tech.csm.firstproject;
import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static final String CUSTOMER_GOVERNMENT = "Government";
    static final String CUSTOMER_UNIVERSITY = "University";
    
	public static void main(String[] args) {
		String customer = getCustomerType();
		sc.nextLine();
		
		int product = getProductType();
		sc.nextLine();
		
		System.out.println("Enter the amount of the order: ");
		double orderAmt = sc.nextDouble();
		
		double discount = getDiscount(product, customer, orderAmt);
		double netAmt = orderAmt * (1 - discount);
		
		System.out.println("Net ammount payable: " + netAmt);
	}
	
	public static String getCustomerType(){
	    System.out.println("Please enter customer type(enter 1, 2, or 3):\n" +
		    "\t1. Government\n" +
		    "\t2. University\n"
		);
		int selection = sc.nextInt();
		
		switch(selection){
		    case 1: return CUSTOMER_GOVERNMENT;
		    default: return CUSTOMER_UNIVERSITY;
		}
	}
	
	public static int getProductType(){
	    System.out.println("Please enter product type(enter 1, 2, or 3):\n" +
		    "\t1. 16-bit\n" +
		    "\t2. 32-bit\n"
		);
		int selection = sc.nextInt();
		
		switch(selection){
		    case 1: return 16;
		    default: return 32;
		}
	}
	
	public static double getDiscount(int microprocessor, String customer, double orderAmt){
	    if (microprocessor == 32){
	        if (orderAmt < 50000){
	            if (customer.equals(CUSTOMER_GOVERNMENT)){
	                return 0.065;
	            }
	        }
	        else{
	            if (customer.equals(CUSTOMER_GOVERNMENT)){
	                return 0.085;
	            }
	        }
	        
	        return 0.010;
	    }
	    else{
	        if (orderAmt < 10000){
	            return 0;
	        }
	        else{
	            if (customer.equals(CUSTOMER_GOVERNMENT)){
	                return 0.05;
	            }
	            else{
	                return 0.07;
	            }
	        }
	    }
	}
}
