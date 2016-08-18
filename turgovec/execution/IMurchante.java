package turgovec.execution;
import java.util.List;

import turgovec.exceptions.MurchantException;

public interface IMurchante {

	void purchiseStock(IShop shop, List<Product> stock) throws MurchantException;

	void fillTheShops() throws MurchantException;

	void collectDailyMoney();

	void payTaxes();

	void addShop(Shop shop) throws MurchantException;

	void addDealer(Dealer dealer) throws MurchantException;

	int getCapital();

}