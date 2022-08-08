import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class CouponUse
{
	private static UserList ul = new UserList();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 초기화면에서 쿠폰사용을 선택하면 실행되는 메소드
	public static void couponRun() throws IOException
	{
		System.out.print("\n>> 쿠폰을 사용하시겠습니까? (Y 또는 y) : ");
		String temp = br.readLine();
		
		if (temp.equals("Y") || temp.equals("y"))
		{
			// 만약 쿠폰 사용에서 y를 눌렀다면 userList클래스의
			// userLogion() 메서드 실행
			ul.userLogin();	
			
			// ul.flag가 true면 기존회원이라는 뜻
			if (ul.flag)
			{
				// ID는 있으나 쿠폰 갯수가 0개인 경우
				if (ul.couponForLogIn < 1)
				{
					System.out.println("\n┌────────────────────────────────────────────────────┐");
					System.out.println("│            사용가능한 쿠폰이 없습니다!!            │");
					System.out.println("└────────────────────────────────────────────────────┘");
					return;
				}
				// ID도 있고 쿠폰 갯수도 1개 이상인 경우
				else
				{
					System.out.println("\n┌────────────────────────────────────────────────────┐");
					System.out.println("│               로그인에 성공하였습니다.             │");
					System.out.println("└────────────────────────────────────────────────────┘");
					System.out.println(" - 보유 중인 스탬프 수 : " + ul.user.get(ul.dispUserNumber-1).getStamp());
					System.out.println(" - 보유 중인 쿠폰 수   : " + ul.user.get(ul.dispUserNumber-1).getCoupon());
					CategoryUI.categoryRun();
				}
			}
			// ul.flag == flase인 경우이므로 기존회원이 아니라는 뜻.
			else 
			{
				System.out.println("\n┌────────────────────────────────────────────────────┐");
				System.out.println("│              일치하는 ID가 없습니다!!              │");
				System.out.println("└────────────────────────────────────────────────────┘");
			}
		}
	}
	
	// 쿠폰 사용 선택시 호출되는 할인 메소드
	public static void bargenByCoupon() throws IOException
	{
		int sel;

		System.out.println(">> 쿠폰을 사용할 메뉴 번호를 입력해주세요.");
		System.out.print(">> 메뉴 번호 입력 : ");
		sel = Integer.parseInt(br.readLine());
		
		// 매출액 현황에 쿠폰사용금액을 반영해줌
		Sales.totalCoupon += Cart.vc.get(sel - 1).getPrice();
		
		// 만약 선택한 메뉴번호의 음료갯수가 1개라면 단순하게 가격만 0원으로 설정해줌
		if (Cart.vc.get(sel - 1).getCount() == 1)
			Cart.vc.get(sel - 1).setPrice(0);
		// 1개가 아니라 여러개라면 갯수를 -1 시켜줌. (가격 계산 공식이 해당 객체의 price * count 이므로)
		Cart.vc.get(sel - 1).setCount(Cart.vc.get(sel - 1).getCount() - 1);
		
		Cart.couponUseCount++; // Cart의 couponUseCount를 1로 증가시켜줌. 이 변수가 1이면 쿠폰은 다시 사용 못 함.
		// 해당 음료 객체의 couponUse 변수를 true로 전환시켜줌 (나중에 장바구니나 영수증 출력시 사용)
		Cart.vc.get(sel - 1).setCouponUse(true);
	}
}