import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AdminLogin
{
	private static String id;
	private static String pw;

	public static String getId()
	{
		return id;
	}

	public static void login() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println();
		System.out.println("──────────[관리자 로그인]──────────");

		do
		{
			System.out.print(">> ID 입력 : ");
			id = br.readLine();
			if (!AdminList.account.containsKey(id))
				System.out.println("\n해당 하는 ID가 없습니다.");
		}
		while (!AdminList.account.containsKey(id));

		do
		{
			System.out.print(">> PW 입력 : ");
			pw = br.readLine();
			if (!AdminList.account.get(id).equals(pw))
				System.out.println("\n비밀 번호가 올바르지 않습니다.");
		}
		while (!AdminList.account.get(id).equals(pw));
		System.out.println("\n관리자 로그인에 성공했습니다!");
		System.out.println("───────────────────────────────────\n");
	}
}