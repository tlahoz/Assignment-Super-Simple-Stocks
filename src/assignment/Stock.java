package assignment;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



public class Stock {
	private static final int MINUTES_FOR_PRICE_CALCULATION = 15;
	
	String symbol;
	static enum Type {
	    COMMON, PREFERRED
	    }
	
	Type type;
	double tickerPrice;
	double lastDividend;
	double fixedDividend;
	double parValue;
	private ArrayList<Trade> trades = new ArrayList<Trade>();
	
	public double dividendYield(){
		if (tickerPrice <= 0){
			// should throw a controlled exception
			return -1d;
		}
		switch (type){
			case COMMON:
				return lastDividend/tickerPrice;
		case PREFERRED:
				return (fixedDividend * parValue)/tickerPrice;
		default:
				return -1d;
			
			}
		
	}
	
	// maybe dividend should be last dividend || fixedDividend * parValue?
	public double PERatio(){
		if (tickerPrice <= 0){
			// should throw a controlled exception
			return -1d;
		}
		if (lastDividend == 0){
			return 0d;
		}
		return tickerPrice/lastDividend;
	}
	
	public void addTrade(Trade newTrade){
		trades.add(newTrade);
	}
	
	public double getPrice(){
		// if no trade has been done in the last 15 min -> return -1
		
		int q = 0;
		double cumulativePrice = 0;
		LocalTime compareTime = LocalTime.now().minus(MINUTES_FOR_PRICE_CALCULATION, ChronoUnit.MINUTES);

		// iterate over trades till the first one or the condition (now - 15min > timeStamp)
		for(int i = trades.size()-1; i >=0; i--){
			Trade t = trades.get(i);
			if (t.timestamp.isBefore(compareTime)){
				break;
			} else {
				q = q + t.quantity;
				cumulativePrice = cumulativePrice + t.price(); 
			}
		}
		if(q != 0){
			return cumulativePrice/q;
		} else {
			return -1d;
		}
		
	}
	
}