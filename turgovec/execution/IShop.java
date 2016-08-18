package turgovec.execution;
import turgovec.exceptions.ShopException;

public interface IShop {

	void addStock(Product product) throws ShopException;

	int getTax();

	int getWinnings();

}