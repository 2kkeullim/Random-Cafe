import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Coffee extends Options
{
	public static final int COST = 1000;   //음료 원가
	public static String drinkName[] = {"아메리카노" , "카페라떼", "바닐라라떼" , "카페모카" ,"돌체라떼", "랜덤커피"};
	public static int drinkPrice[] = {1500, 2000, 2500 , 2500 , 3500, 2000};

	public void set(String drinkName , int drinkPrice) throws IOException
	{
		System.out.println(Coffee.drinkName[DrinkUI.sel-1]+" 을(를) 선택하셨습니다.");
		option1();
		Drink dr = new Drink(hotOrColdOption, iceOption, drinkCountOption);
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		Cart.vc.add(dr);
		if (DrinkUI.sel != 6)
			Cart.overLap(dr);
		Cart.printVC();
	}
}