package assignment;

import java.time.LocalTime;
import java.util.*;


public class Solution {
		
	
	static void main(){

		
		ArrayList<Stock> stList = new ArrayList<Stock>();
		// add stocks, operate...
		
		double gbce = GBCE(stList);
		// ...
		
		
	}
	
	
	
	
	
	
	
	static double GBCE(ArrayList<Stock> st){
			if (st.size() == 0){
				return 0;
			}
			Double m, p, exp;
			int counter;
			m = 1D;
			counter = 0;
			for (Stock s:st){
				p = s.getPrice();
				if (p != -1d){
					counter++;
					m = m * p; 			
				}
				
			}
			exp = 1d;
			exp = exp/counter;
			return Math.pow(m, exp);
		}
		
		
}
