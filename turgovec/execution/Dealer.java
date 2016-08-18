package turgovec.execution;
import turgovec.exceptions.DealerException;
import turgovec.exceptions.ObektException;

public abstract class Dealer extends Obekt{
	private String name;
	
	public Dealer(String name, String address, String workTime) throws DealerException, ObektException {
		super(workTime, address);
		if(isStringValid(name)){
			this.name=name;
		}
		else{
			throw new DealerException("Invalid dealer's name!");
		}
	}
	

}
