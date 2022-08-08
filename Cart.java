import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.IOException;

public class Cart
{
	public static Vector<Drink> vc = new Vector<Drink>();
	public static int sel; 
	public static int totalSum = 0; // 총 금액 변수
	public static int couponUseCount = 0;

	public static void printVC() throws IOException
	{
		total();  // 주문한 내역의 총합의 금액이 totalSum에 저장됨.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n                     [장바구니]");
		System.out.println("──────────────────────────────────────────────────────");

		for (int i = 0; i < vc.size(); i++)
		{
			// 만약 장바구니의 i번째에 해당하는 메뉴가 쿠폰을 사용했다면
			// 할인 메소드에 의해 갯수가 하나 줄어들었으므로 출력을 해줄 때는
			// 갯수에 +1을 해줌.
			if (vc.get(i).getCouponUse() == true)
				System.out.printf("%2d번 %6s %6s %8s %8d원 %2d개\n", i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
					, vc.get(i).getPrice() * vc.get(i).getCount(), vc.get(i).getCount() + 1);
			else
				System.out.printf("%2d번 %6s %6s %8s %8d원 %2d개\n", i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
					, vc.get(i).getPrice() * vc.get(i).getCount(), vc.get(i).getCount());
		}

		System.out.println("──────────────────────────────────────────────────────");
		System.out.println("                                  총 금액 : " + totalSum + "원");
		System.out.println("1. 결제하기       2.항목 삭제하기       3. 뒤로 가기\n");

		System.out.print(">> 원하는 항목 : ");
		sel = Integer.parseInt(br.readLine());
		System.out.println();

		switch (sel)
		{
			case 1 : 
				if(InitialUI.sel == InitialUI.couponUse && couponUseCount == 0)
				{
					// InitailUI.sel이 InitialUI.couponUse란 말은
					// 초기화면에서 쿠폰사용을 통해 카테고리에 진입했다는 뜻이고
					// couponUseCount가 0이라는 말은 이번 주문에서 아직 쿠폰을
					// 사용하지 않았다는 뜻이므로 쿠폰 할인 메서드를 호출
					CouponUse.bargenByCoupon();
					// 할인된 가격을 확인하기 위해 다시 한 번 장바구니 호출
					printVC();
				}
				// Pay클래스에서 카드결제, 현금결제 여부 선택
				Pay.cashOrCard(); 
				break;
			case 2 : remove();						// 삭제하면 다시 카테고리로 들어감.
			case 3 : CategoryUI.categoryRun(); break;
		}
	}
	
	// 완전히 동일한 이름, 옵션을 가진 메뉴는 중첩시켜서 갯수만 증가시키는 메소드
	public static void overLap(Drink dr)
	{
		for(int i = 0; i < vc.size() - 1; i++)
		{
			if ((dr.getName()).equals(vc.get(i).getName()) && (dr.getHoc()).equals(vc.get(i).getHoc()) && dr.getIce().equals(vc.get(i).getIce()))
			{
				int x = vc.get(i).getCount();		// 이름, 옵션이 같은경우 -> 갯수를 
				x += dr.getCount();					// 상위 주문내역에 추가함
				vc.get(i).setCount(x);           
				vc.remove(vc.size()-1);				// 그리고 마지막 주문내역(중복된 메뉴)을 벡터에서 지움
			}
		}	
	}
	
	// 장바구니에서 항목을 삭제하는 메소드
	public static void remove() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">> 삭제할 항목의 번호를 입력하세요 : ");
		int temp = Integer.parseInt(br.readLine());
		totalSum -= vc.get(temp-1).getPrice() * vc.get(temp-1).getCount();
		vc.remove(temp-1);
	}
	
	// 장바구니에 들어있는 가격을 변수 totalSum에 더해주는 메소드
	public static void total()
	{
		int temp = 0;
		for (int i = 0; i < vc.size(); i++)
			temp += vc.get(i).getPrice() * vc.get(i).getCount();
		totalSum = temp;                     
	}
}