package turgovec.execution;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {

		try{
			List<Dealer> dealers = new ArrayList<Dealer>();
			String[] dealerNames = {"Petar" , "Georgi", "Asen"};
			Dealer[] typeDealers = {new WholesaleDealer(dealerNames[new Random().nextInt(dealerNames.length)],"Lyulin" , "9-17h") , new RetailDealer(dealerNames[new Random().nextInt(dealerNames.length)],"Studentski grad" , "9-17h")};
			for(int dealer = 1 ; dealer <=10 ; dealer++){
				dealers.add(typeDealers[new Random().nextInt(typeDealers.length)]);
			}
			List<Shop> shops = new ArrayList<Shop>();
			Shop[] typeShops = {new ShopAtMall("9-17h", "Mladost" , new Random().nextInt(90)+10) , new ShopAtMarket("9-17h", "Drujba" , new Random().nextInt(8)+2) , new ShopOnStreet("9-17h", "Vitoshka" , new Random().nextInt(4)+6)};
			for(int shop = 1; shop<=20 ; shop++){
				shops.add(typeShops[new Random().nextInt(typeShops.length)]);
				
			}
			
			Murchant ambulantTurgovec = new Ambulant("Venelin" , "Center" , 100);
			Murchant ednolichenTurgovec = new ET("Krasimira" , "Hadji Dimitur" , 500);
			Murchant turgovskaVeriga = new SellerBrand("Kaufland" , "Mladost" , 3000);
			List<Murchant> turgovci = new ArrayList<Murchant>();
			turgovci.add(turgovskaVeriga);
			turgovci.add(ednolichenTurgovec);
			turgovci.add(ambulantTurgovec);
			int numOfShops=0;
			for(Shop shop : shops){
				if(numOfShops<1 && shop instanceof ShopAtMarket || shop instanceof ShopOnStreet){
				ednolichenTurgovec.addShop(shop);
				numOfShops++;
				continue;
				}
				if(numOfShops<9&&shop instanceof ShopAtMall || shop instanceof ShopOnStreet){
				turgovskaVeriga.addShop(shop);
				numOfShops++;
				continue;
				
				}
			}
			int numOfDealers=0;
			for(Dealer dealer : dealers){
				turgovskaVeriga.addDealer(dealer);
				if(dealer instanceof RetailDealer){
				if(numOfDealers<1){
					ambulantTurgovec.addDealer(dealer);
					numOfDealers++;
					continue;
				}
				if(numOfDealers<5){
					ednolichenTurgovec.addDealer(dealer);
					numOfDealers++;
					continue;
				}
				}
			}
			for(IMurchante turgovec : turgovci){
				turgovec.fillTheShops();
				turgovec.collectDailyMoney();
				turgovec.payTaxes();
				System.out.println("After month capital " + turgovec.getCapital());
			}
			
		
			
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

}
