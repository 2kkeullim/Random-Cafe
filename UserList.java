import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;

public class UserList extends User
{
	static Vector<User> user = new Vector<User>(); // 개인 정보를 담는 그릇
	static Stamp sp = new Stamp();
	public static boolean flag;
	public static String pn;
	public static int couponForLogIn; 
	public static int dispUserNumber;

	static
	{
		user.add(new User("김"));
		user.add(new User("이"));
		user.add(new User("박"));
		user.get(1).setCoupon(1);
		user.get(2).setCoupon(2);
	}

	public static void userLogin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 번호를 입력하세요 : " );
		pn = sc.next();

		for (int i = 0; i < user.size(); i++)
		{
			if (user.get(i).getPhoneNumber().equals(pn)) // 기존 회원
			{
				user.get(i).setUserNumber(i + 1);
				enroll(i);

				flag = true;
				couponForLogIn = user.get(i).getCoupon();
				break;
			}
			else if (!user.get(i).getPhoneNumber().equals(pn) && i == user.size() - 1) // 신규 회원
			{
				user.add(new User(pn));
				enroll(user.size() - 1);
				
				break;
			}
		}
	}

	public static void enroll(int i)
	{
		user.get(i).setUserNumber(i + 1);
		dispUserNumber = user.get(i).getUserNumber();

		sp.userStamp = user.get(i).getStamp();
		sp.userCoupon = user.get(i).getCoupon();
		sp.stampCal();

		user.get(i).setStamp(sp.userStamp);
		user.get(i).setCoupon(sp.userCoupon);
	}

	public static void saveStampCard()
	{
		sp.printStampResult();
	}

	public static void saveStampCash()
	{
		sp.printStampResult();
	}
}