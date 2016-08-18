package turgovec.execution;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turgovec.exceptions.ObektException;
import turgovec.exceptions.ShopException;

public abstract class Shop extends Obekt implements IShop{
	private static final double SELL_PERCENT_OF_PRICE = 1.3;
	private int size;
	private int countryTax;
	private List<Product> stock = new ArrayList<Product>();
	
	Shop(String workTime, String address , int countryTax) throws ObektException{
		super(workTime, address);
	}
	
	protected void setSize(int size) {
		this.size=size;
		
	}
	
	/* (non-Javadoc)
	 * @see IShop#addStock(Product)
	 */
	@Override
	public void addStock(Product product) throws ShopException{
		if(product!=null){
			stock.add(product);
		}else{
			throw new ShopException("No product was given");
		}
	}

	/* (non-Javadoc)
	 * @see IShop#getTax()
	 */
	@Override
	public int getTax() {
		return countryTax;
	}

	/* (non-Javadoc)
	 * @see IShop#getWinnings()
	 */
	@Override
	public int getWinnings() {
		int winnings = 0;
		for(int product = 0 ; product < new Random().nextInt(stock.size()) ; product++){
			winnings+=SELL_PERCENT_OF_PRICE*stock.get(product).getPrice();
			stock.remove(product);
		}
		
		return winnings;
		
	}

	@Override
	public String toString() {
		return "Shop [stock=" + stock + "]\n";
	}
}
