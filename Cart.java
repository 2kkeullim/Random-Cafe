import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.IOException;

public class Cart
{
	public static Vector<Drink> vc = new Vector<Drink>();    // 생성된(주문받은) Drink 인스턴스가 장바구니내 벡터 자료구조에 담김
	public static int sel; 
	public static int totalSum = 0;							 // 총 금액 변수
	public static int couponUseCount = 0;					 

	public static void printVC() throws IOException
	{
		total();										     // 주문한 내역의 총합의 금액이 totalSum에 저장됨.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n                     [장바구니]");
		System.out.println("──────────────────────────────────────────────────────");

		for (int i = 0; i < vc.size(); i++)
		{
			if (vc.get(i).getCouponUse() == true)    //쿠폰을 사용할 경우
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
					, vc.get(i).getPrice() * vc.get(i).getCount(), vc.get(i).getCount() + 1);
			else					
				System.out.printf("%2d번 %6s %6s %6s %8d원 %2d개\n", i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
					, vc.get(i).getPrice() * vc.get(i).getCount(), vc.get(i).getCount());
		}

		System.out.println("──────────────────────────────────────────────────────");
		System.out.println("                                총 금액 : " + totalSum + "원");
		System.out.println("1. 결제하기    2.항목 삭제하기    3. 뒤로가기\n");

		System.out.print(">> 원하는 항목 : ");
		sel = Integer.parseInt(br.readLine());
		System.out.println();

		switch (sel)
		{
			case 1 : 
				if(InitialUI.sel == InitialUI.couponUse && couponUseCount == 0)
				{
					CouponUse.bargenByCoupon();
					printVC();
				}
				Pay.cashOrCard(); 
				break;
			case 2 : remove();						// 삭제하면 다시 카테고리로 들어감.
			case 3 : CategoryUI.categoryRun(); break;
		}
	}

	public static void overLap(Drink dr)
	{
		for(int i = 0; i < vc.size() - 1; i++)
		{
			if ((dr.getName()).equals(vc.get(i).getName()) && (dr.getHoc()).equals(vc.get(i).getHoc()) && dr.getIce().equals(vc.get(i).getIce()))
			{
				int x = vc.get(i).getCount();		// 이름, 옵션이 같은경우 -> 갯수를 
				x += dr.getCount();					// 상위 주문내역에 추가함
				vc.get(i).setCount(x);           
				vc.remove(vc.size()-1);				// 그리고 마지막 주문내역(중복된 메뉴)을 벡터에서 지움 ,
			}
		}	
	}

	public static void remove() throws IOException     //주문내역의 원하는 번호를 삭제할 수 있다.
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.print(">> 삭제할 항목의 번호를 입력하세요 : ");				
		int temp = Integer.parseInt(br.readLine());
		totalSum -= vc.get(temp-1).getPrice() * vc.get(temp-1).getCount();		// 장바구니 총액에서 삭제하고 싶은 항목의 가격을 뺌.	
		vc.remove(temp-1);		
	}

	public static void total()    //현재까지 주문한 총액을 계산하는 메소드
	{
		int temp = 0;
		for (int i = 0; i < vc.size(); i++)
			temp += vc.get(i).getPrice() * vc.get(i).getCount();    
		totalSum = temp;                     
	}
}