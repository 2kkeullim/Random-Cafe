import java.io.IOException;

public class Admin
{
	public static void open() throws IOException
	{
		AdminLogin.login();
		operate();
	}

	public static void operate() throws IOException
	{		
		do
		{
			AdminUI.adminDisp();
			AdminUI.adminSelect();
			AdminUI.adminRun();

			if (AdminUI.sel == AdminUI.back && Change.sum() == 0)
				System.out.println("잔돈을 추가해주세요!\n");
			else if (AdminUI.sel == AdminUI.back && Change.sum() != 0)
				break;
		}
		while (true);
	}
}