import java.io.IOException;

public class Cafe
{

	public static void open() throws IOException
	{	
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│                                                    │");
		System.out.println("│  <---- Random Cafe 오픈 준비를 시작합니다!! ---->  │");
		System.out.println("│                                                    │");
		System.out.println("│                                                    │");
		System.out.println("│ - 관리자모드로 로그인 후 잔돈을 넣어주세요.        │");
		System.out.println("│ - 잔돈이 없는 경우, 카페 오픈이 불가합니다.        │");
		System.out.println("│ - 오픈하기 전에는, 관리자 모드로만 이동이 가능하며 │");
		System.out.println("│   매장, 포장, 쿠폰 사용 선택이 불가합니다.         │");
		System.out.println("└────────────────────────────────────────────────────┘");

		do
		{
			InitialUI.initialDisp();
			InitialUI.initialSelect();
			if (InitialUI.sel != InitialUI.adminLogin)
			{
				System.out.println("\n4번을 눌러서 관리자 모드로 들어가주세요!\n");
				continue;
			}
			InitialUI.initialRun();
		}
		while (InitialUI.sel != InitialUI.adminLogin);

		Cat.open();
	}

	public static void operate() throws IOException
	{
		do
		{
			InitialUI.initialDisp();
			InitialUI.initialSelect();
			InitialUI.initialRun();
		}
		while (true);
	}
}
