package turgovec.execution;
import turgovec.exceptions.DealerException;
import turgovec.exceptions.ObektException;

public class WholesaleDealer extends Dealer{
	
	private static final float PERCENT_DISCOUNT = 15/100f;

	public WholesaleDealer(String name, String address, String workTime) throws DealerException, ObektException {
		super(name, address, workTime);
		
	}
	
	public float makeDiscount(int sum) throws DealerException{
		if(sum>0){
			return sum*PERCENT_DISCOUNT;
		}
		throw new DealerException("Your purchise is invalid");
	}

}
