public class Stamp extends UserList
{
	public int stamp;
	public int coupon;
	public int userStamp;
	public int userCoupon;
	public int drinkCountForStamp;

public void stampCal()
	{
		drinkCountForStamp = 0; // 구매자가 구매한 음료 갯수

		coupon += (drinkCountForStamp / 10); // 쿠폰 갯수
		stamp += drinkCountForStamp - (coupon * 10); // 스탬프 갯수
		
		if(stamp % 10 == 0 && stamp != 0)
		{
			coupon++;
			stamp = 0;
		}

		userCoupon += coupon; // 킴 - 2
		userStamp += stamp;   // 킴 - 4

		if (userStamp == 10)
		{
			userCoupon++;
			userStamp = 0;
		}
	}		
}