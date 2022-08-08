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
	
	// 관리자 로그인 메소드
	public static void login() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n────────────────── [관리자  로그인] ──────────────────");
		
		// private static final String[] ID = {"조", "최", "정", "반"};
		// private static final String[] PW = {"1", "2", "3", "4"};	
		// 관리자들의 id와 비밀번호가 해쉬맵 자료구조에 들어있으므로 이를 조회함

		do
		{
			System.out.print(">> ID 입력 : ");
			id = br.readLine();
			// 입력받은 문자열이 해쉬맵의 키(id)와 일치하지 않으면 안내메세지 출력
			if (!AdminList.account.containsKey(id))
				System.out.println("\n해당 하는 ID가 없습니다.");
		}
		while (!AdminList.account.containsKey(id));

		do
		{
			// 입력받은 문자열이 해쉬맵의 value(pw)와 일치하지 않으면 안내메세지 출력
			System.out.print(">> PW 입력 : ");
			pw = br.readLine();
			if (!AdminList.account.get(id).equals(pw))
				System.out.println("\n비밀 번호가 올바르지 않습니다.");
		}
		while (!AdminList.account.get(id).equals(pw));

		System.out.println("\n            관리자 로그인에 성공했습니다!!            ");
		System.out.println("──────────────────────────────────────────────────────\n");
	}
}