package turgovec.execution;
import turgovec.exceptions.ObektException;

public class ShopOnStreet extends Shop{

	private static final int COUNTRY_TAX_FOR_SHOP_ON_THE_STREET = 50;
	private static final int MIN_SIZE_OF_SHOP_ON_STREET = 6;
	private static final int MAX_SIZE_OF_SHOP_ON_STREET = 10;

	ShopOnStreet(String workTime, String address, int size) throws ObektException {
		super(workTime, address,COUNTRY_TAX_FOR_SHOP_ON_THE_STREET);
		if(size>=MIN_SIZE_OF_SHOP_ON_STREET && size<=MAX_SIZE_OF_SHOP_ON_STREET){
			setSize(size);
		}
	}

}
