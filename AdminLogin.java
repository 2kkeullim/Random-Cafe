import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AdminLogin
{
	public void login() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id,pw;
		do
		{
			System.out.print("ID 입력 : ");
			id = br.readLine();
			if(!AdminList.account.containsKey(id))
				System.out.println("해당 하는 ID가 없습니다.");
		}
		while (!AdminList.account.containsKey(id));

		do
		{
			System.out.print("PW 입력 : ");
			pw = br.readLine();
			if(!AdminList.account.get(id).equals(pw))
				System.out.println("비밀 번호가 올바르지 않습니다.");
		}
		while (!AdminList.account.get(id).equals(pw));
		
		do
		{
			AdminUI.menuDisp();
			AdminUI.menuSelect();
			AdminUI.menuRun();
		}
		while(true);	


		
	}

	public static void main(String[] args) throws IOException
	{
		AdminData ad = new AdminData();                      //AdminList에 AdminData 대입.
		ad.listIn();
		AdminLogin al = new AdminLogin();                    //AdminL
		al.login();
	}
}