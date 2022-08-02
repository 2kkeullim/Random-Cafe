import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.NumberFormatException;

public class InitialUI
{
	
	public static final int takeOut = 1;
	public static final int forHere = 2;
	public static final int stampUse = 3;
	public static final int adminLogin = 4;
	public static int sel = 1;
	
	// 메뉴표시 메소드
	public static void menuDisp()
	{
		System.out.println("1. 매장이용");
		System.out.println("2. 포장");
		System.out.println("3. 쿠폰 사용");
		System.out.println("4. 관리자모드");
		System.out.print(">> 선택(1~4) : ");
	}
	
	// 메뉴 선택 메소드
	public static void menuSelect() throws IOException, NumberFormatException
	{
		// 메뉴 선택 입력받기 위한 BufferedReader 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 메뉴선택
		do
		{
			sel = Integer.parseInt(br.readLine());
			
			// 1~4번 이외의 번호 입력시 다시 입력해달라는 메세지 출력
			if (sel >= 1 && sel <= 4)
				break;
			else
				System.out.println("다시 입력해주세요.");
		}
		while (true);

	}
	
	// 메뉴 선택 후 실행 메소드
	public static void menuRun()
	{
		switch (sel)
		{
			// 음료 주문
			case 1:
			case 2: drink(); break;
			
			// 쿠폰 사용
			case 3: stamp(); break;
			
			// 관리자 모드
			case 4: adminUI(); break;
		}
	}
	
	// 음료 주문 메소드
	public static void drink()
	{
		System.out.println("음료메뉴 화면");
	}
	
	// 쿠폰 사용 메소드
	public static void stamp()
	{
		System.out.println("쿠폰 사용 음료메뉴 화면");
	}
	
	// 관리자 모드 진입 메드
	public static void adminUI()
	{
		System.out.println("관리자 화면");
	}


	public static void main(String[] args) throws IOException, NumberFormatException
	{
		
		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while (true);
	}
}
