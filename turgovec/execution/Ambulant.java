package turgovec.execution;
import turgovec.exceptions.MurchantException;

public class Ambulant extends Murchant{

	public Ambulant(String name, String address, int capital) throws MurchantException {
		super(name, address, capital);
	}
	
	@Override
	public
	void addDealer(Dealer dealer) throws MurchantException {
		if(this.getDealers().size()<1){
			if(dealer instanceof RetailDealer){
			super.addDealer(dealer);
			}else{
				throw new MurchantException("You cannot work with such a dealer");
			}
		}else{
			throw new MurchantException("You limit of dealer is crossed");
		}
		
	}
	
	public void addShop(Shop shop) throws MurchantException {
		throw new MurchantException("You are an ambulant murchant you do not have shops");
	}

}
