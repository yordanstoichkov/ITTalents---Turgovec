package turgovec.execution;
import turgovec.exceptions.ObektException;

public class ShopAtMarket extends Shop{

	private static final int MAX_SIZE_OF_SHOP_AT_MARKET = 10;
	private static final int MIN_SIZE_OF_SHOP_AT_MARKET = 2;
	private static final int COUNTRY_TAX_FOR_SHOP_AT_MARKET = 50;

	ShopAtMarket(String workTime, String address, int size) throws ObektException {
		super(workTime, address , COUNTRY_TAX_FOR_SHOP_AT_MARKET);
		if(size>=MIN_SIZE_OF_SHOP_AT_MARKET && size<=MAX_SIZE_OF_SHOP_AT_MARKET){
			setSize(size);
		}
		
	}

	

}
