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

			if (AdminUI.sel == 6 && Change.sum() == 0)
				System.out.println("잔돈을 추가해주세요!\n");
			else if (AdminUI.sel == 6 && Change.sum() != 0)
				break;
		}
		while (true);
	}
}