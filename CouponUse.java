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
			System.out.println("	쿠폰을 사용하시겠습니까? (Y 또는 y)	 ");
			System.out.print(" >> " );
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
						System.out.println("============================");
						System.out.println("로그인에 성공하였습니다.");
						System.out.println("보유 중인 쿠폰 수   : " + ul.user.get(ul.dispUserNumber-1).getCoupon());
						System.out.println("보유 중인 스탬프 수 : " + ul.user.get(ul.dispUserNumber-1).getStamp());
						System.out.println("============================");
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

	public static void bargenByCoupon() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp;
		int minusCoupon = ul.user.get(ul.dispUserNumber-1).getCoupon();
		System.out.println("쿠폰을 사용할 메뉴 번호를 입력해주세요.");
		System.out.print("메뉴 번호 입력 : " );
		temp = Integer.parseInt(br.readLine());
		Sales.totalCoupon += Cart.vc.get(temp-1).getPrice();
		if(Cart.vc.get(temp-1).getCount() == 1)
			Cart.vc.get(temp-1).setPrice(0);
		else
			Cart.vc.get(temp-1).setPrice(Cart.vc.get(temp-1).getPrice()-(Cart.vc.get(temp-1).getPrice()/(Cart.vc.get(temp-1).getCount())));
		
		Cart.couponUseCount++;
		//ul.user.get(ul.dispUserNumber-1).setCoupon(minusCoupon-1);
	}
}