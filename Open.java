import java.io.IOException;

public class Open
{

	public static void openProcess() throws IOException
	{
		System.out.println("┌──────────────────────────────────────────┐");
		System.out.println("│   Random Cafe 오픈 준비를 시작합니다!!   │");
		System.out.println("└──────────────────────────────────────────┘");
		System.out.println();
		System.out.println(">> 관리자모드로 로그인 후 잔돈을 넣어주세요~!!!");
		System.out.println();

		InitialUI init = new InitialUI();
		
		do
		{
			init.menuDisp();
			init.menuSelect();
			if (init.sel != init.adminLogin)
			{
				System.out.println("\n4번을 눌러서 관리자 모드로 들어가주세요!\n");
				continue;
			}
			init.menuRun();
		}
		while (init.sel != init.adminLogin);
	}

	public static void main(String[] args) throws IOException
	{
		openProcess();
	}
}
