package assignment;

import java.time.LocalTime;

public class Trade {
	static enum Act {BUY, SELL}
	
	Act action;
	int quantity;
	double pricePerStock;
	LocalTime timestamp;
	
	public Trade(Trade.Act action, int quantity, double pricePerStock, LocalTime timestamp) {
		this.action = action;
		this.quantity = quantity;
		this.pricePerStock = pricePerStock;
		this.timestamp = timestamp;
	}
	
	public double price(){
		return pricePerStock * quantity;
	}
	
}
