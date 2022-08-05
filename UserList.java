import java.util.Vector;
import java.util.Scanner;

public class UserList extends User
{
	static Vector<User> user = new Vector<User>(); // 개인 정보를 담는 그릇
	static Stamp sp = new Stamp();
	public static boolean flag;
	public static String pn;
	public static int couponForLogIn; 

	public static void userLogin()
	{
		Scanner sc = new Scanner(System.in);
		user.add(new User("김"));
		user.add(new User("이"));
		user.add(new User("박"));

		user.get(1).setCoupon(1);
		user.get(2).setCoupon(2);
		System.out.print("번호를 입력하세요 : " );
		pn = sc.next(); 

			for (int i = 0; i < user.size(); i++)
			{
				if (user.get(i).getPhoneNumber().equals(pn))
				{
					sp.userStamp = user.get(i).getStamp();
					sp.userCoupon = user.get(i).getCoupon();
					sp.stampCal();
					user.get(i).setStamp(user.get(i).getStamp()+sp.stamp);
					user.get(i).setCoupon(user.get(i).getCoupon()+sp.coupon);

					if (user.get(i).getStamp() >= 10)
					{
						user.get(i).setStamp(user.get(i).getStamp()%10);
						user.get(i).setCoupon(user.get(i).getCoupon()+1);
					}
					flag = true;
					couponForLogIn = user.get(i).getCoupon();
					break;
					
					
				}
				else if(!user.get(i).getPhoneNumber().equals(pn) && i == user.size()-1)
				{
					//System.out.println("수행돼버렸네?");
					user.add(new User(pn));
					sp.userStamp = user.get(i).getStamp();
					sp.userCoupon = user.get(i).getCoupon();
					sp.stampCal();
					user.get(user.size()-1).setStamp(user.get(user.size()-1).getStamp()+sp.stamp);
					user.get(user.size()-1).setCoupon(user.get(user.size()-1).getCoupon()+sp.coupon);

					if (user.get(user.size()-1).getStamp() >= 10)
					{
						user.get(user.size()-1).setStamp(user.get(user.size()-1).getStamp()%10);
						user.get(user.size()-1).setCoupon(user.get(user.size()-1).getCoupon()+1);
					}
					break;
				}
			}
	}

	public static void userVerify()
	{
		
	}
}