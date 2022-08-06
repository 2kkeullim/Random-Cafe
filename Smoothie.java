import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Smoothie extends Options
{
	public static final int cost = 2500;
	public static String drinkName[] = {"오렌지스무디" , "청포도스무디", "망고스무디" , "딸기스무디" ,"요거트스무디", "랜덤스무디"};
	public static int drinkPrice[] = {4000, 4000, 4500 , 4500 , 5000, 4000};
	
	public void set(String drinkName , int drinkPrice) throws IOException
	{
		System.out.println(Smoothie.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		cupsCount();
		Drink dr = new Drink("cold", " ", drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		Cart.vc.add(dr);
		if (DrinkUI.sel != 6)
			Cart.overLap(dr);
		Cart.printVC();
	}
}
