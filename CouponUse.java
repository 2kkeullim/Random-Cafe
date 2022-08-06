import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class CouponUse
{
	static UserList ul = new UserList();
	static CategoryUI cu = new CategoryUI();

	public static void couponRun() throws IOException
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("	쿠폰을 사용하시겠습니까? (Y 또는 y)	 ");
			String temp = br.readLine();
			
			if (temp.equals("Y") || temp.equals("y"))
			{
				ul.userLogin();	

				if (ul.flag == true)
				{
					
					if (ul.couponForLogIn < 1)
					{
						System.out.println("============================");
						System.out.println("사용가능한 쿠폰이 없습니다!");
						System.out.println("============================");
						return;
					}
					else
					{
						cu.category();
						cu.categoryRun();
					}
				}
				else 
				{
					System.out.println("============================");
					System.out.println("일치하는 ID가 없습니다!");
					System.out.println("============================");
				}
			}
	}
}