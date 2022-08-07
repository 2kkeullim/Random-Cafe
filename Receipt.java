import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
	static String[] week = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
	static String temp;
	static int receiptNumber;

	public static void receiptDispRun() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("영수증을 출력하시겠습니까? (출력 : Y 또는 y) ");
		temp = br.readLine();
		
		if (temp.equals("Y") || temp.equals("y"))
		{
			if (Pay.sel == 1)
				receiptDispForCard();	// 카드결제 시 카드 영수증
			else if (Pay.sel == 2)
				receiptDispForCash();	// 현금결제 시 현금 영수증
		}
		if(receiptNumber < 10)
			System.out.printf("  주문번호 : 000%d\n", ++receiptNumber);
		else if(receiptNumber > 10 && receiptNumber < 100)
			System.out.printf("  주문번호 : 00%d\n", ++receiptNumber);
		else if(receiptNumber > 100 && receiptNumber < 1000)
			System.out.printf("  주문번호 : 0%d\n", ++receiptNumber);
		else
			System.out.printf("  주문번호 : %d\n", ++receiptNumber);
		AddSales.addSales();
	}

	public static void detectRandom()
	{
		for (int i = 0; i < Cart.vc.size(); i++)
		{	
			switch (Cart.vc.get(i).getName())
			{
				case "랜덤커피"   : Cart.vc.get(i).setName("(Random) " + Coffee.drinkName[RandomDrink.roll()]);		break;
				case "랜덤라떼"   : Cart.vc.get(i).setName("(Random) " + NonCoffee.drinkName[RandomDrink.roll()]);	break;
				case "랜덤주스"   : Cart.vc.get(i).setName("(Random) " + Juice.drinkName[RandomDrink.roll()]);		break;
				case "랜덤스무디" : Cart.vc.get(i).setName("(Random) " + Smoothie.drinkName[RandomDrink.roll()]);	break;
				case "랜덤티"     : Cart.vc.get(i).setName("(Random) " + Tea.drinkName[RandomDrink.roll()]);		break;
				case "랜덤에이드" : Cart.vc.get(i).setName("(Random) " + Ade.drinkName[RandomDrink.roll()]);		break;
			}
		}
	}

	public static void receiptDispForCard()
	{
		detectRandom();
		System.out.println("                  [영   수   증] ");
		System.out.printf("%s %02d:%02d:%02d %s%n", nd, hour, minute, second, week[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" 선택한 메뉴   옵션                            개수 ");
		System.out.println("──────────────────────────────────────────────────────");
		for (int i = 0; i < Cart.vc.size(); i++)
		{
			if (Cart.vc.get(i).getCouponUse() == true)
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount() + 1);
			else
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount());
		}
	}

	public static void receiptDispForCash()
	{
		detectRandom();
		System.out.println(" [영   수   증] ");
				System.out.printf("%s %d:%d:%02d %s%n", nd, hour, minute, second, week[cal.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(" 선택한 메뉴     옵션                      개수 ");
		System.out.println("──────────────────────────────────────────────────────");
		for (int i = 0; i < Cart.vc.size(); i++)
		{
			if (Cart.vc.get(i).getCouponUse() == true)
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount() + 1);
			else
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount());
		}
		System.out.println("──────────────────────────────────────────────────────");
		System.out.println("지불하신 금액	거스름돈");
		System.out.printf("%d원		%d원%n", ReturnChange.pay, ReturnChange.getChangeSum());
		System.out.println("──────────────────────────────────────────────────────");
	}
}
