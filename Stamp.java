public class Stamp extends UserList
{
	public int stamp;
	public int coupon;
	public int userStamp;
	public int userCoupon;
	public static int drinkCountForStamp;

public void stampCal()
	{
		for(int i=0;i < Cart.vc.size();i++)
			drinkCountForStamp	+= Cart.vc.get(i).getCount(); // 구매자가 구매한 음료 갯수
		
		
		coupon += (drinkCountForStamp / 10); // 쿠폰 갯수
		stamp += drinkCountForStamp - (coupon * 10); // 스탬프 갯수
		
		
		if(stamp % 10 == 0 && stamp != 0)
		{
			coupon++;
			stamp = 0;
		}
		

		userCoupon += coupon; // 킴 - 2
		userStamp += stamp;   // 킴 - 4
		
		/*
		if (userStamp == 10)
		{
			userCoupon++;
			userStamp = 0;
		}
		*/
	}

	public void printStampResult()
	{
		if (Cart.couponUseCount != 0)
		{
			userStamp --;
			userCoupon--;
		}
		System.out.println("스탬프 적립이 완료되었습니다.");
		System.out.println("==============================");
		System.out.println("구매하신 음료 수  : " + drinkCountForStamp);
		System.out.println("적립 후 스탬프 수 : " + user.get(dispUserNumber-1).getStamp());
		System.out.println("적립 후 쿠폰 수   : " + user.get(dispUserNumber-1).getCoupon());
		System.out.println("==============================");
	}
}