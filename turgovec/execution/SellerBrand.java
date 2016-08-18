package turgovec.execution;
import turgovec.exceptions.MurchantException;

public class SellerBrand extends Murchant{

	public SellerBrand(String name, String address, int capital) throws MurchantException {
		super(name, address, capital);
	}
	
	@Override
	public
	void addDealer(Dealer dealer) throws MurchantException {
		if(this.getDealers().size()<15){
			super.addDealer(dealer);
		}else{
			throw new MurchantException("You limit of dealer is crossed");
		}
		
	}


	@Override
	public
	void addShop(Shop shop) throws MurchantException {
		if(this.getShops().size()<=10){
			if(shop instanceof ShopAtMall || shop instanceof ShopOnStreet){
			super.addShop(shop);
			}else{
				throw new MurchantException("You cannot buy such a shop");
			}
		}else{
			throw new MurchantException("You limit of shops is crossed");
		}
	}
}
