import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InitialUI
{
	public static final int forHere = 1;
	public static final int takeOut = 2;
	public static final int couponUse = 3;
	public static final int adminLogin = 4;
	public static int sel = 1;
	
	public static void initialDisp()
	{
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│                      [Service]                     │");
		System.out.println("│                                                    │");
		System.out.println("│                   1. 매장  이용                    │");
		System.out.println("│                   2. 포      장                    │");
		System.out.println("│                   3. 쿠폰  사용                    │");
		System.out.println("│                   4. 관리자모드                    │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.out.print("\n>> 원하시는 서비스를 선택하세요 (1 ~ 4) : ");
	}
	
	public static void initialSelect() throws IOException, NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			sel = Integer.parseInt(br.readLine());

			if (sel >= forHere && sel <= adminLogin)
				break;
			else
			{
				System.out.println("\n다시 입력해주세요.\n");
				initialDisp();
			}
		}
		while (true);
	}
	
	public static void initialRun() throws IOException
	{
		switch (sel)
		{
			case forHere:
			case takeOut:		CategoryUI.categoryRun(); break;	
			case couponUse:		CouponUse.couponRun(); break;
			case adminLogin:	Admin.open(); break;
		}
	}
}
