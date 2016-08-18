package turgovec.execution;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turgovec.exceptions.DealerException;
import turgovec.exceptions.MurchantException;
import turgovec.exceptions.ShopException;

public abstract class Murchant implements IMurchante  {
	private String name;
	private String addres;
	private int capital;
	private List<Shop> shops = new ArrayList<Shop>();
	private List<Dealer> dealers = new ArrayList<Dealer>();


	public Murchant(String name, String address, int capital) throws MurchantException {
		if (name != null && name.trim().length() > 0) {
			this.name = name;
		} else {
			throw new MurchantException("Invalid name for murchant!");
		}
		if (address != null && address.trim().length() > 0) {
			this.addres = address;
		} else {
			throw new MurchantException("Invalid address for murchant!");
		}
		if (capital > 0) {
			this.capital = capital;
		} else {
			throw new MurchantException("Go get some money to become murchant!");
		}
	}
	
	/* (non-Javadoc)
	 * @see IMurchante#purchiseStock(Shop, java.util.List)
	 */
	@Override
	public void purchiseStock(IShop shop, List<Product> stock) throws MurchantException{
		Dealer dealer = dealers.get(new Random().nextInt(dealers.size()));
		int sum = 0 ;
		for(Product product : stock){
			if(product!=null){
			sum+=product.getPrice();
			}else{
				throw new MurchantException("invalid product given!");
			}
		}
		if(sum<=capital/2){
			for(Product product : stock){
				try {
					shop.addStock(product);
				} catch (ShopException e) {
					throw new MurchantException("invalid product given!");
				}
			}
			capital-=sum;
			if(dealer instanceof WholesaleDealer){
				try {
					float discount=((WholesaleDealer)dealer).makeDiscount(sum);
					this.capital+=discount;
				} catch (DealerException e) {
					throw new MurchantException("Unfortunately the price of the products is invalid!");
				}
			}
		}else{
			throw new MurchantException("You don't have enough money to make this purchise");
		}
	}
	 
	/* (non-Javadoc)
	 * @see IMurchante#fillTheShops()
	 */
	@Override
	public void fillTheShops() throws MurchantException{
		String[] namesOfProducts = {"Dreha" , "Mebel", "Hrana"};
		for(IShop shop:shops){
		List<Product> purchiseProducts = new ArrayList<Product>();
		for(int product = 0 ; product<= new Random().nextInt(15)+5;product++){
			Product productToPurchise = new Product(namesOfProducts[new Random().nextInt(namesOfProducts.length)]);
			purchiseProducts.add(productToPurchise);
		}
		purchiseStock(shop, purchiseProducts);
		}
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return this.getClass()+"[shops=" + shops + "]\n";
	}

	/* (non-Javadoc)
	 * @see IMurchante#collectDailyMoney()
	 */
	@Override
	public void collectDailyMoney(){
		int dailyMoney=0;
		for(IShop shop : shops){
			dailyMoney+=shop.getWinnings();
		}
		this.capital+=dailyMoney;
		
	}

	
	/* (non-Javadoc)
	 * @see IMurchante#payTaxes()
	 */
	@Override
	public void payTaxes(){
		for(IShop shop : shops){
			capital-=shop.getTax();
		}
	}

	/* (non-Javadoc)
	 * @see IMurchante#addShop(Shop)
	 */
	@Override
	public void addShop(Shop shop) throws MurchantException {
		if (shop != null) {
			shops.add(shop);
		} else {
			throw new MurchantException("Invalid shop given to be added");
		}
	}

	/* (non-Javadoc)
	 * @see IMurchante#addDealer(Dealer)
	 */
	@Override
	public void addDealer(Dealer dealer) throws MurchantException {
		if (dealer != null) {
			dealers.add(dealer);
		} else {
			throw new MurchantException("Invalid dealer given to be added");
		}
	}
	@Override
	public int getCapital() {
		return capital;
	}

	public List<Dealer> getDealers() {
		return dealers;
	}
	

	public List<Shop> getShops() {
		return shops;
	}

}
