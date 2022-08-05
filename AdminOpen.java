import java.io.IOException;

public class AdminOpen
{
	public static void adminOpen() throws IOException
	{
		AdminLogin.login();
		open();
	}

	public static void open() throws IOException
	{		
		do
		{
			AdminUI.menuDisp();
			AdminUI.menuSelect();
			AdminUI.menuRun();

			if (AdminUI.sel == 6 && Change.sumCal() == 0)
			{
				System.out.println("현재 잔돈 보유량이 0원이라 카페를 오픈할 수 없습니다.");
				System.out.println("잔돈을 추가해주세요!\n");
			}
			else if (AdminUI.sel == 6 && Change.sumCal() != 0)
				break;
		}
		while (true);
	}
}