import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InitialUI
{
	public static final int takeOut = 1;
	public static final int forHere = 2;
	public static final int stampUse = 3;
	public static final int adminLogin = 4;
	public static int sel = 1;
	
	public static void menuDisp()
	{
		System.out.println("1. 매장이용");
		System.out.println("2. 포장");
		System.out.println("3. 쿠폰 사용");
		System.out.println("4. 관리자모드");
		System.out.print(">> 선택(1~4) : ");
	}
	
	public static void menuSelect() throws IOException, NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			sel = Integer.parseInt(br.readLine());

			if (sel >= 1 && sel <= 4)
				break;
			else
			{
				System.out.println("\n다시 입력해주세요.\n");
				menuDisp();
			}
		}
		while (true);
	}
	
	public static void menuRun()
	{
		
		switch (sel)
		{
			case takeOut:
			case forHere: drink(); break;			
			case stampUse: stamp(); break;
			case adminLogin: adminUI(); break;
		}
	}
	
	public static void drink()
	{
		System.out.println("\n음료메뉴 화면\n");
	}
	
	public static void stamp()
	{
		System.out.println("\n쿠폰 사용 음료메뉴 화면\n");
	}
	
	public static void adminUI()
	{
		System.out.println("\n관리자 화면\n");
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
