import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NonCoffee extends Options
{
	public static final int cost = 2000;
	public static String drinkName[] = {"녹차라떼" , "초코라떼", "고구마라떼" , "곡물라떼" ,"딸기라떼", "랜덤라떼" };
	public static int drinkPrice[] = {3000, 3500, 4000 , 4000 , 4500, 3500};

	public void set(String drinkName , int drinkPrice) throws IOException
	{	
		System.out.println(NonCoffee.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		option1();
		Drink dr = new Drink(hotOrColdOption, iceOption, drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		AddSales.addSales(dr);
		Cart.vc.add(dr);
		Cart.overLap(dr);
		Cart.printVC();
	}
}
