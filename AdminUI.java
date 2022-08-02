
import java.io.*;

public class AdminUI
{	
	
	static int sel;
	static BufferedReader br ;
	
	static  //초기화
	{
		br = new BufferedReader(new InputStreamReader(System.in));    
		sel = 1;
	}
	public static void menuDisp()                                                  //메뉴 출력 메소드
	{
		System.out.println();
		System.out.println("1.매출액 관리");
		System.out.println("2.메뉴별 판매비율");
		System.out.println("3.잔돈 보유량");
		System.out.println("4.잔돈 추가");
		System.out.println("5.종료");
		System.out.println("====================");
		System.out.print(">>메뉴 선택 (1~5) : ");
	}
	public static void menuSelect() throws IOException , NumberFormatException     //메뉴선택 메소드
	{
		do
		{
			sel = Integer.parseInt(br.readLine());
			if(sel < 1 || sel > 5)
			{
				System.out.println();
				System.out.println("입력값을 벗어났습니다.");
				menuDisp();       //입력값 벗어났을시 메뉴 다시출력
			}
		}
		while (sel < 1 || sel > 5);
	}
	public static void menuRun()												   //선택한 메뉴실행에 따른 기능호출 메소드
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

	
	public static void sales()  //매출액 관리 메소드
	{
		System.out.println("sales");
		
	}
	public static void salesRatio()  //메뉴별 판매 비율 메소드
	{ 
		System.out.println("salesRatio");
	}
	public static void changes()    //잔돈 보유량확인 메소드
	{
		System.out.println("changes");
	}
	public static void addChanges()   //잔돈 추가 메소드
	{
		System.out.println("addchanges");
	}
	public static void exit()     //프로그램종료 메소드
	{
		System.out.println("프로그램 종료!!!");
		System.exit(0);
	}



	public static void main(String[] args) throws IOException , NumberFormatException
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