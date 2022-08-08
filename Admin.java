import java.io.IOException;

public class Admin
{
	// 관리자 모드를 진입하면 수행되는 open() 메소드
	public static void open() throws IOException
	{
		// 관리자모드를 들어가기 위해 로그인 수행
		AdminLogin.login();
		// 로그인 수행하면 AdminUI를 출력해주는 operate() 메소드 수행
		operate();
	}

	public static void operate() throws IOException
	{		
		do
		{
			AdminUI.adminDisp();
			AdminUI.adminSelect();
			AdminUI.adminRun();
			
			// 잔돈이 0원이면 잔돈을 추가하기 전까지 관리자모드 나가기 불가능
			if (AdminUI.sel == AdminUI.back && Change.sum() == 0)
				System.out.println("잔돈을 추가해주세요!\n");
			else if (AdminUI.sel == AdminUI.back && Change.sum() != 0)
				break;
		}
		while (true);
	}
}