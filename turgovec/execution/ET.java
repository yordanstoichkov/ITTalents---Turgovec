package turgovec.execution;
import turgovec.exceptions.MurchantException;

public class ET extends Murchant{

	public ET(String name, String address, int capital) throws MurchantException {
		super(name, address, capital);
	}
	
	@Override
	public
	void addDealer(Dealer dealer) throws MurchantException {
		if(this.getDealers().size()<5){
			if(dealer instanceof RetailDealer){
			super.addDealer(dealer);
			}else{
				throw new MurchantException("You cannot work with such a dealer");
			}
		}else{
			throw new MurchantException("You limit of dealer is crossed");
		}
		
	}
	
	@Override
	public
	void addShop(Shop shop) throws MurchantException {
		if(this.getShops().size()<20){
			if(shop instanceof ShopAtMarket || shop instanceof ShopOnStreet){
			super.addShop(shop);
			}else{
				throw new MurchantException("You cannot buy such a shop");
			}
		}else{
			throw new MurchantException("You limit of shops is crossed");
		}
	}

}
