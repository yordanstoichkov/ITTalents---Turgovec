package turgovec.execution;
import turgovec.exceptions.ObektException;

public class ShopAtMall extends Shop{

	private static final int COUNTRY_TAX_FOR_SHOP_AT_MALL = 150;
	private static final int MIN_SIZE_OF_SHOP_AT_MALL = 10;
	private static final int MAX_SIZE_OF_SHOP_AT_MALL = 100;

	ShopAtMall(String workTime, String address, int size) throws ObektException {
		super(workTime, address, COUNTRY_TAX_FOR_SHOP_AT_MALL);
		
		if(size>=MIN_SIZE_OF_SHOP_AT_MALL && size<=MAX_SIZE_OF_SHOP_AT_MALL){
			setSize(size);
		}
	}

}
