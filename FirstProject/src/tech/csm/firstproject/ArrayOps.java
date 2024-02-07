package tech.csm.firstproject;

import java.util.*;
public class ArrayOps {

	public static void main(String[] args) {
		int c;
		for ( c = 1; c++<5; System.out.print(++c+" ")); 
			System.out.println(c);
		int arrSize;
		char arr[] = new char[3];
		arr[0] = 50;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		
		int[] A = new int[n];
		int oddCount = 0, evenCount = 0;
		
		for(int i = 0; i < n; i++) {
			A[i] = (int) (Math.random() * 10 + 1);
			
			if (A[i]%2 == 0) {
				evenCount++;
			}
			else {
				oddCount++;
			}
		}
		
		System.out.println(Arrays.toString(A));
		System.out.println("Even count: " + evenCount);
		System.out.println("Odd count: " + oddCount);
		
		int max = A[0];
		int min = A[0];
		for(int x:A) {
			if(x>max)
				max=x;
			if(x<min)
				min=x;
		}
		
		System.out.println("The maximum element is: "+max);
		System.out.println("The minimum element is: "+min);
		
		min = A[0];
		for(int x:A) {
			
			if(x<min)
				System.out.println("Not in ascending order");
		}
	}

}
