package turgovec.execution;
import turgovec.exceptions.DealerException;
import turgovec.exceptions.ObektException;

public class RetailDealer extends Dealer{
	
	public RetailDealer(String name, String address, String workTime) throws DealerException, ObektException {
		super(name, address, workTime);
	}

}
