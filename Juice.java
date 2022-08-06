import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Juice extends Options
{
	public static final int cost = 1500;
	public static String drinkName[] = {"사과주스" , "오렌지주스", "포도주스" , "망고주스" ,"딸기주스", "랜덤주스"};
	public static int drinkPrice[] = {3000, 3500, 3500 , 4000 , 4000, 3500};

	
	public void set(String drinkName , int drinkPrice) throws IOException
	{
		System.out.println(Juice.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		option2();
		Drink dr = new Drink("cold", iceOption, drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		AddSales.addSales(dr);
		Cart.vc.add(dr);
		Cart.overLap(dr);
		Cart.printVC();
	}
}
