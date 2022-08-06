import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ade extends Options
{
	public static final int cost = 1500;
	public static String drinkName[] = {"레몬에이드" , "유자에이드", "망고에이드" , "자몽에이드" ,"청포도에이드", "랜덤에이드"};
	public static int drinkPrice[] = {3000, 3000, 4000 , 4000 , 4000, 3500};
	
	
	public void set(String drinkName , int drinkPrice) throws IOException
	{
		System.out.println(Ade.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		option2();
		Drink dr = new Drink("cold", iceOption, drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		AddSales.addSales(dr);
		Cart.vc.add(dr);
		if (DrinkUI.sel != 6)
			Cart.overLap(dr);
		Cart.printVC();
	}
}
