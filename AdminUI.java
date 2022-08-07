import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AdminUI
{
	public static final int salesManage = 1;
	public static final int salesRatio = 2;
	public static final int checkChange = 3;
	public static final int addChange = 4;
	public static final int cafeClose = 5;
	public static final int back = 6;
	public static int sel = 1;
	
	public static void adminDisp() // 메뉴 출력 메소드
	{
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.printf("│                 [환영합니다, %s 님]                │\n", AdminLogin.getId());
		System.out.println("│                                                    │");
		System.out.println("│               1. 매출액 통계 보기                  │");
		System.out.println("│               2. 메뉴별 판매 비율                  │");
		System.out.println("│               3. 잔돈 보유량 확인                  │");
		System.out.println("│               4. 잔돈    추가하기                  │");
		System.out.println("│               5. 카페    마감하기                  │");
		System.out.println("│               6. 관리자메뉴  종료                  │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.out.print("\n>> 메뉴 선택 (1 ~ 6) : ");
	}

	public static void adminSelect() throws IOException, NumberFormatException     // 메뉴선택 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			sel = Integer.parseInt(br.readLine());
			if (sel < salesManage || sel > back)
			{
				System.out.println("\n입력값을 벗어났습니다.\n");
				adminDisp();								// 입력값 벗어났을시 메뉴 다시출력
			}
		}
		while (sel < salesManage || sel > back);
	}

	public static void adminRun() throws IOException		// 선택한 메뉴실행에 따른 기능 호출 메소드
	{
		switch (sel)
		{
			case salesManage:	Sales.salesManage(); break;
			case salesRatio:	Sales.eachDrinkSales(); break;
			case checkChange:	ChangeUI.checkChange(); break;
			case addChange:		ChangeUI.addChange(); break;
			case cafeClose:		Cat.close(); break;
			case back:			break;
		}
	}
}
