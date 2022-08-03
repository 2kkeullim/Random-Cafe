import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class AdminUI
{	
	static int sel;
	static BufferedReader br ;
	
	static  // 초기화
	{
		br = new BufferedReader(new InputStreamReader(System.in));    
		sel = 1;
	}

	public static void menuDisp()                                                  // 메뉴 출력 메소드
	{
		System.out.println();
		System.out.println("1.매출액 관리");
		System.out.println("2.메뉴별 판매비율");
		System.out.println("3.잔돈 보유량");
		System.out.println("4.잔돈 추가");
		System.out.println("5.종료");
		System.out.println("====================");
		System.out.print(">> 메뉴 선택 (1~5) : ");
	}

	public static void menuSelect() throws IOException, NumberFormatException     // 메뉴선택 메소드
	{
		do
		{
			sel = Integer.parseInt(br.readLine());
			if (sel < 1 || sel > 5)
			{
				System.out.println();
				System.out.println("입력값을 벗어났습니다.");
				menuDisp();								// 입력값 벗어났을시 메뉴 다시출력
			}
		}
		while (sel < 1 || sel > 5);
	}

	public static void menuRun()									// 선택한 메뉴실행에 따른 기능호출 메소드
	{
		switch(sel)
		{
			case 1: sales(); break;
			case 2: salesRatio(); break;
			case 3: changes(); break;
			case 4: addChanges(); break;
			case 5: exit(); break;
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

	public static void changes()    // 잔돈 보유량확인 메소드
	{
		System.out.println("현재 보유한 잔돈은");
		System.out.printf("500원   %d개 입니다.\n", Change.change.get(500));
		System.out.printf("1000원  %d개 입니다.\n", Change.change.get(1000));
		System.out.printf("5000원  %d개 입니다.\n", Change.change.get(5000));
		System.out.printf("10000원 %d개 입니다.\n", Change.change.get(10000));
		System.out.printf("총액은 %d입니다.\n", Change.sumCal());
	}

	public static void addChanges()   // 잔돈 추가 메소드
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 가능 금액 단위 (500원 1000원 5000원 10000원)");
		do
		{
			System.out.print("금액 단위와 개수를 입력해 주세요. (공백 구분) : ");
			int unit = sc.nextInt();
			if ((unit != 500) && (unit != 1000) && (unit != 5000) && (unit != 10000))
			{
				System.out.println("잘못된 금액 단위 입니다. 다시 입력 해주세요." + "\n");
				continue;
			}
			int existingCount = Change.change.get(unit);
			int count = sc.nextInt();
			if((unit == 500 && count > 100) || (unit != 500 && count > 50))
			{
				System.out.println("추가하려는 잔돈의 갯수가 너무 많습니다. 다시 입력해주세요." + "\n");
				continue;
			}
			Change.change.put(unit,count + existingCount);
			System.out.printf("%d원을 %d개 추가 하였습니다.\n",unit,count);
			System.out.println(Change.change.get(unit));
		}
		while (true);
	}

	public static void exit()     // 프로그램종료 메소드
	{
		System.out.println("프로그램 종료!!!");
		System.exit(0);
	}

	

	public static void main(String[] args) throws IOException, NumberFormatException
	{
		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while(true);	
	}
}
