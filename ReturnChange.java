import java.io.IOException;

public class ReturnChange
{
	static int pay;
	static int drink;
	static int change;
	
	//손님에게 건네준 잔돈을 담을 변수
	private static int returnChangeSum = 0;
	private static int returnChange500 = 0;
	private static int returnChange1000 = 0;
	private static int returnChange5000 = 0;
	private static int returnChange10000 = 0;
	
	//각 화폐단위가 손님에게 건네진 횟수
	private static int count10000 = 0;
	private static int count5000 = 0;
	private static int count1000 = 0;
	private static int count500 = 0;

	public static void changeCal()	//잔돈 계산
	{
		boolean change10000Flag = 10000*Change.change.get(10000) >= change;

		if(change10000Flag)
		{
			returnChange10000 += (10000 * (change/10000));
			count10000 += change/10000;
			change -= returnChange10000;
		}
		
		else if (change/10000 != 0 && Change.change.get(10000)!= 0)
		{
			returnChange10000 += (10000 * Change.change.get(10000));
			count10000 += Change.change.get(10000);
			change -= returnChange10000;
		}
		
		boolean change5000Flag = 5000*Change.change.get(5000) >= change;
		
		if(change5000Flag)
		{
			returnChange5000 += (5000 * (change/5000));
			count5000 += change/5000;
			change -= returnChange5000;
		}
		
		else if (change/5000 != 0 && Change.change.get(5000)!= 0)
		{
			returnChange5000 += (5000 * Change.change.get(5000));
			count5000 += Change.change.get(5000);
			change -= returnChange5000;
		}
		
		boolean change1000Flag = 1000*Change.change.get(1000) >= change;

		if(change1000Flag)
		{
			returnChange1000 += (1000 * (change/1000));
			count1000 += change/1000;
			change -= returnChange1000;
		}
		
		else if (change/1000 != 0 && Change.change.get(1000)!= 0) // 3
		{
			returnChange1000 += (1000 * Change.change.get(1000));
			count1000 += Change.change.get(1000);
			change -= returnChange1000;
		}
		
		boolean change500Flag = 500*Change.change.get(500) >= change;

		if(change500Flag)
		{
			returnChange500 += (500 * (change/500));
			count500 += change/500;
			change -= returnChange500;
		}
		
		else if (change/500 != 0 && Change.change.get(500)!= 0) // 1
		{
			returnChange500 += (500 * Change.change.get(500));
			count500 += Change.change.get(500);
			change -= returnChange500; // 500
		}
	}

	public static void changePrint() throws IOException	//잔돈 반환 결과 출력
	{
		changeCal();
		returnChangeSum = returnChange10000+returnChange5000+returnChange1000+returnChange500;
		if (change == 0)
		{
			System.out.println("==============================");
			if(count10000 != 0)
				System.out.printf("10000원 %d장%n",count10000);
			
			if(count5000 != 0)
				System.out.printf(" 5000원 %d장%n",count5000);

			if(count1000 != 0)
				System.out.printf(" 1000원 %d장%n",count1000);

			if(count500 != 0)
				System.out.printf("  500원 %d개%n",count500);

			System.out.printf("%n총 거스름돈 %d원 입니다.%n",returnChangeSum);
			System.out.println("===============================");
		}
		
		else
		{
			System.out.println("======================================");
			System.out.println("잔돈이 부족하니 카운터로 문의해주세요.");
			System.out.println("======================================");
			
			Cart.vc.clear();
			Cart.totalSum = 0;
			do
			{
				InitialUI.menuDisp();
				InitialUI.menuSelect();
				InitialUI.menuRun();
			}
			while (true);
		}
		changeReNew();
		changeReset();
	}
	
	public static void changeReNew() // 잔돈 보유량 갱신
	{
		Change.change.put(10000,Change.change.get(10000)-count10000);
		Change.change.put(5000,Change.change.get(5000)-count5000);
		Change.change.put(1000,Change.change.get(1000)-count1000);
		Change.change.put(500,Change.change.get(500)-count500);
	}

	public static int getChangeSum()
	{
		return returnChangeSum;
	}

	public static void changeReset()
	{
		count10000 = 0;
		count5000 = 0;
		count1000 = 0;
		count500 = 0;	
		returnChange500 = 0;
		returnChange1000 = 0;
		returnChange5000 = 0;
		returnChange10000 = 0;
	}
}