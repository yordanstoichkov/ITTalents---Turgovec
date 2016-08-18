package turgovec.execution;
import java.util.Random;

public class Product {
	private String name;
	private int price;
	

	Product(String name){
		this.name=name;
		this.price = new Random().nextInt(10)+5;
	}
	

	public int getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
}
