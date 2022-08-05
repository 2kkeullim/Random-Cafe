import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Tea extends Options
{
	public static final int cost = 1000;
	public static String drinkName[] = {"그린티" , "얼그레이", "페퍼민트" , "복숭아티" ,"캐모마일"};
	public static int drinkPrice[] = {2000, 2500, 2500 , 3000 , 3000};
	
	public void set(String drinkName , int drinkPrice) throws IOException
	{
		System.out.println(Tea.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		option1();
		Drink dr = new Drink(hotOrColdOption, iceOption, drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		Cart.vc.add(dr);
		Cart.overLap(dr);
		Cart.printVC();
	}
}
