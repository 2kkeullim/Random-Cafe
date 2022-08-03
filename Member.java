public class Member
{
	private String phoneNumber;
	private int stamp = 0;
	private int coupon = 0;

	Member()		// default 생성자
	{
	}

	Member(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
		stamp = 0;
		coupon = 0;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public int getStamp()
	{
		return stamp;
	}

	public void setStamp(int stamp)
	{
		this.stamp = stamp;
	}
	
	public int getCoupon()
	{
		return coupon;
	}

	public void setCoupon(int coupon)
	{
		this.coupon = coupon;
	}
}