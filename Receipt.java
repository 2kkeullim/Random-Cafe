import java.util.Vector;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;


public class Receipt
{
	static Calendar cal = Calendar.getInstance();

	static LocalDate nd = LocalDate.now();
	static LocalTime nt = LocalTime.now();

	static int hour = nt.getHour();
	static int minute = nt.getMinute();
	static int second = nt.getSecond();
	static String[] week = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};

	public static void detectRandom()
	{
		for (int i = 0; i < Cart.vc.size(); i++)
		{	
			switch (Cart.vc.get(i).getName())
			{
				case "랜덤커피"   : Cart.vc.get(i).setName(Coffee.drinkName[RandomDrink.roll()]); break;
				case "랜덤라떼"   : Cart.vc.get(i).setName(NonCoffee.drinkName[RandomDrink.roll()]); break;
				case "랜덤주스"   : Cart.vc.get(i).setName(Juice.drinkName[RandomDrink.roll()]); break;
				case "랜덤스무디" : Cart.vc.get(i).setName(Smoothie.drinkName[RandomDrink.roll()]); break;
				case "랜덤티"     : Cart.vc.get(i).setName(Tea.drinkName[RandomDrink.roll()]); break;
				case "랜덤에이드" : Cart.vc.get(i).setName(Ade.drinkName[RandomDrink.roll()]); break;
			}
		}
	}

	public static void receiptDispForCard()
	{
		detectRandom();
		System.out.println(" [영   수   증] ");
		System.out.printf("%s %d:%d:%02d %s%n", nd, hour, minute, second, week[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" 선택한메뉴   옵션   개수 ");
		System.out.println("------------------------------------");
		for(int i=0;i < Cart.vc.size();i++)
		{
			System.out.printf("\n%d번 %s  %s  %s  %d원  %d개\n",i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
				, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount());
		}
	}

	public static void receiptDispForCash()
	{
		detectRandom();
		System.out.println(" [영   수   증] ");
				System.out.printf("%s %d:%d:%02d %s%n", nd, hour, minute, second, week[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" 선택한메뉴   옵션   개수 ");
		System.out.println("------------------------------------");
		for(int i=0;i < Cart.vc.size();i++)
		{
			System.out.printf("\n%d번 %s  %s  %s  %d원  %d개\n",i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
				, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount());
		}
		System.out.println("------------------------------------");
		System.out.println("지불하신 금액	거스름돈");
		System.out.printf("%d원		$d원%n", ReturnChange.pay, ReturnChange.getChangeSum());
		System.out.println("------------------------------------");
	}

}