public class Stamp
{
	public int stamp;
	public int coupon;
	public int drinkCountForStamp;

public void stampCal()
	{
	//	drinkCountForStamp = 카트에 담긴 음료수;
		stamp = getStamp();		// Member 클래스 getStamp()
		coupon = getCoupon();	// Member 클래스 getCoupon()
		
		coupon += (drinkCountForStamp / 10);

		if (coupon != 0 && drinkCountForStamp % 10 != 0) 
			stamp += drinkCountForStamp%(coupon * 10); 

		else if (drinkCountForStamp % 10 == 0)
			stamp += 0;

		else if(coupon == 0)
			stamp += drinkCountForStamp;

		if(stamp % 10 == 0)
		{
			coupon++;
			stamp = 0;
		}
	
		setStamp(stamp);		// Member 클래스 setStamp()
		setCoupon(coupon);		// Member 클래스 setCoupon()
	}		
}