import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;

public class Receipt
{
	// 영수증에 날짜 출력을 하기 위한 변수들
	static Calendar cal = Calendar.getInstance();
	static LocalDate nd = LocalDate.now();
	static LocalTime nt = LocalTime.now();
	
	//현재시간
	static int hour = nt.getHour();
	//현재 분
	static int minute = nt.getMinute();
	//현재 초
	static int second = nt.getSecond();
	// 강의 시간에 배운 요일 출력하는법 활용
	static String[] week = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};

	static String temp;
	static int receiptNumber;

	public static void receiptDispRun() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">> 영수증을 출력하시겠습니까? (출력 : Y 또는 y) ");
		temp = br.readLine();
		
		if (temp.equals("Y") || temp.equals("y"))
		{
			if (Pay.selPay == 1)
				receiptDispForCard();	// 카드결제 시 카드 영수증
			else if (Pay.selPay == 2)
				receiptDispForCash();	// 현금결제 시 현금 영수증
		}
		// ??
		Sales.addSales();
	}

	public static void receiptDispForCard()
	{
		// 마지막으로 랜덤음료를 골랐을 경우
		// 이를 감지하여 무작위로 음료 이름을 영수증에 출력해줌
		RandomDrink.detectRandom();
		System.out.println("\n──────────────────────────────────────────────────────");
		System.out.println("                    [영   수   증]                   \n");
		System.out.printf("%s %02d:%02d:%02d %s         [ 주문번호 : %04d ]\n\n", nd, hour, minute, second, week[cal.get(Calendar.DAY_OF_WEEK)-1], ++receiptNumber);
		System.out.println("        선택한 메뉴    옵션                   개수 ");
		System.out.println("──────────────────────────────────────────────────────");
		for (int i = 0; i < Cart.vc.size(); i++)
		{
			// 영수증에서도 장바구니와 마찬가지로 만약 쿠폰을 사용한 메뉴라면 
			// 가격 계산을 위해 갯수를 -1 시켜줬으므로 출력 갯수를 +1로 표기해줌
			if (Cart.vc.get(i).getCouponUse() == true)
				System.out.printf("%2d번 %7s %7s %8s %8d원 %3d개\n", i + 1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount() + 1);
			else
				System.out.printf("%2d번 %7s %7s %8s %8d원 %3d개\n", i + 1, Cart.vc.get(i).getName(), Cart.vc.get(i).getHoc(), Cart.vc.get(i).getIce()
					, Cart.vc.get(i).getPrice() * Cart.vc.get(i).getCount(), Cart.vc.get(i).getCount());
		}
		System.out.println("──────────────────────────────────────────────────────");
	}

	public static void receiptDispForCash()
	{
		receiptDispForCard();
		// 카드 영수증 양식을 그대로 가져오고 거기에 거스름돈 양식만 더해줌
		// pay는 지불한 금액, getChangeSum()은 ReturnChange의 returnChangeSum 변수를 가져오는 메소드
		System.out.println("──────────────────────────────────────────────────────");
		System.out.println("지불하신 금액 : " + ReturnChange.pay);
		System.out.println("거스름돈      : " + ReturnChange.getChangeSum());
		System.out.println("──────────────────────────────────────────────────────");
	}
}
