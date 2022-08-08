import java.io.IOException;

public class Cafe
{
	
	// 처음 프로그램을 실행하면 수행되는 메소드
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
				// 첫 오픈에서는 무조건 잔돈을 추가해야 하므로
				// 관리자모드에만 진입을 허락함
				System.out.println("\n4번을 눌러서 관리자 모드로 들어가주세요!\n");
				continue;
			}
			InitialUI.initialRun();
		}
		while (InitialUI.sel != InitialUI.adminLogin);

		Cat.open();
	}
	
	// open()메소드가 끝난 이후 초기화면 출력해주는 메소드
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
