package tech.csm.firstproject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FirstProject implements Comparable<Integer>{
	public static void main(String[] args) {
		  int x = 3, y = 4, z=4; 
		  System.out.println(z>=y&&y>=x?1:0);
		  
		  switch(9) {
		  case 8:
		  case 1: 
			  System.out.println("one");
			  break;
		  case 2: 
			  System.out.println("two");
			  break;
		  case 3: 
			  System.out.println("three");
			  break;
		  default :
			  System.out.println("invalid input");
		  }
		  
		  Integer lists[] = new Integer[]{1, 4, 3, 7, 10, 2};
		  
		  System.out.println(Arrays.toString(lists));
		  Arrays.sort(lists);
		  System.out.println(Arrays.toString(lists));
		  Arrays.sort(lists, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return (Integer)o2 - (Integer)o1;
			}
			  
		  });
		  System.out.println(Arrays.toString(lists));
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
