import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class AdminUI
{	
	static int sel;
	static BufferedReader br;
	
	static  // 초기화
	{
		br = new BufferedReader(new InputStreamReader(System.in));    
		sel = 1;
	}

	public static void menuDisp()                                                  // 메뉴 출력 메소드
	{
		System.out.println("┌───────────────────────┐");
		System.out.printf("│  [환영합니다, %s 님]  │\n", AdminLogin.getId());
		System.out.println("│                       │");
		System.out.println("│  1. 매출액 관리       │");
		System.out.println("│  2. 메뉴별 판매비율   │");
		System.out.println("│  3. 잔돈   보유량     │");
		System.out.println("│  4. 잔돈   추가       │");
		System.out.println("│  5. 카페   마감       │");
		System.out.println("│  6. 뒤로   가기       │");
		System.out.println("└───────────────────────┘");
		System.out.print("\n>> 메뉴 선택 (1 ~ 6) : ");
	}

	public static void menuSelect() throws IOException, NumberFormatException     // 메뉴선택 메소드
	{
		do
		{
			sel = Integer.parseInt(br.readLine());
			if (sel < 1 || sel > 6)
			{
				System.out.println();
				System.out.println("입력값을 벗어났습니다.\n");
				menuDisp();								// 입력값 벗어났을시 메뉴 다시출력
			}
		}
		while (sel < 1 || sel > 6);
	}

	public static void menuRun() throws IOException					// 선택한 메뉴실행에 따른 기능호출 메소드
	{
		switch (sel)
		{
			case 1: Sales.salesManage(); break;
			case 2: Sales.eachDrinkSales(); break;
			case 3: ChangeUI.change(); break;
			case 4: AddChange.addChanges(); break;
			case 5: exit(); break;
			case 6: break;
		}
	}

	public static void sales()  // 매출액 관리 메소드
	{
		System.out.println("sales");
	}

	public static void salesRatio()  // 메뉴별 판매 비율 메소드
	{ 
		System.out.println("salesRatio");
	}

	public static void exit()     // 프로그램종료 메소드
	{
		Cat.close();
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│  <---------- Random Cafe 마감합니다!! ---------->  │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.exit(0);
	}
}
