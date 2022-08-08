import java.util.Random;

public class RandomDrink
{
	// 난수 생성 메서드
	public static int roll()
	{
		int n;

		Random rd = new Random();
		n = rd.nextInt(5);
		return n;
	}

	public static void detectRandom()
	{
		for (int i = 0; i < Cart.vc.size(); i++)
		{	
			// 만약 랜덤음료 종류를 골랐다면?
			// 장바구니에 있는 음료 이름을 활용해 case문 수행
			// 해당 카테고리의 음료이름을 무작위로 불러와서 대신 대입시킴
			switch (Cart.vc.get(i).getName())
			{
				case "랜덤커피"   : Cart.vc.get(i).setName("(R)" + Coffee.drinkName[roll()]);		break;
				case "랜덤라떼"   : Cart.vc.get(i).setName("(R)" + NonCoffee.drinkName[roll()]);	break;
				case "랜덤주스"   : Cart.vc.get(i).setName("(R)" + Juice.drinkName[roll()]);		break;
				case "랜덤스무디" : Cart.vc.get(i).setName("(R)" + Smoothie.drinkName[roll()]);		break;
				case "랜덤티"     : Cart.vc.get(i).setName("(R)" + Tea.drinkName[roll()]);			break;
				case "랜덤에이드" : Cart.vc.get(i).setName("(R)" + Ade.drinkName[roll()]);			break;
			}
		}
	}
}
