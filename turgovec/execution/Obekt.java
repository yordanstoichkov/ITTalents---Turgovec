package turgovec.execution;
import turgovec.exceptions.ObektException;

public abstract class Obekt {
	private String address;
	private String workTime;
	
	Obekt(String workTime, String address) throws ObektException{
		if(isStringValid(workTime)){
			this.workTime=workTime;
		}
		else{
			throw new ObektException("Invalid dealer's work time!");
		}
		if(isStringValid(address)){
			this.address=address;
		}
		else{
			throw new ObektException("Invalid dealer's address!");
		}
	}
	

	protected boolean isStringValid(String str){
		if(str!=null&&str.trim().length()>0){
			return true;
		}
		return false;
	}

}
