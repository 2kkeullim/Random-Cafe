import java.io.IOException;

public class Tea extends Options
{
	public static String drinkName[] = {"그린티", "얼그레이티", "페퍼민트티", "복숭아티", "캐모마일티", "랜덤티"};
	public static int drinkPrice[] = {2000, 2500, 2500, 3000, 3000, 2500};
	
	public void set(String drinkName, int drinkPrice) throws IOException
	{
		System.out.println("\n" + Tea.drinkName[DrinkUI.sel - 1] + " 을(를) 선택하셨습니다.\n");
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
