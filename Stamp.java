public class Stamp extends UserList
{
	public int userStamp;
	public int userCoupon;
	public static int drinkCountForStamp;

	public void stampCal()
	{
		drinkCountForStamp = 0;

		if (Cart.couponUseCount != 0)
		{
			drinkCountForStamp--;
			userCoupon--;
			Cart.couponUseCount = 0;
		}

		for (int i = 0; i < Cart.vc.size(); i++)
		{
			drinkCountForStamp += Cart.vc.get(i).getCount();		// 구매자가 구매한 음료 갯수

			if (Cart.vc.get(i).getCouponUse() == true)
			{
				drinkCountForStamp++;
				Cart.vc.get(i).setCouponUse(false);
			}
		}
		
		userStamp += drinkCountForStamp;							// 스탬프 갯수
		
		if (userStamp >= 10)
		{
			userCoupon += userStamp / 10;
			userStamp = userStamp % 10;
		}
	}

	public static void printStampResult()
	{
		System.out.println("\n┌────────────────────────────────────────────────────┐");
		System.out.println("│            스탬프 적립이 완료되었습니다.           │");
		System.out.println("└────────────────────────────────────────────────────┘");
		
		if (flag == true)
		{
			System.out.println("- 적립 후 스탬프 수 : " + user.get(dispUserNumber - 1).getStamp());
			System.out.println("- 적립 후 쿠폰 수   : " + user.get(dispUserNumber - 1).getCoupon());
			flag = false;
		}
		else
		{
			System.out.println("- 적립 후 스탬프 수 : " + user.get(user.size() - 1).getStamp());
			System.out.println("- 적립 후 쿠폰 수   : " + user.get(user.size() - 1).getCoupon());
		}
		System.out.println("──────────────────────────────────────────────────────");
	}
}