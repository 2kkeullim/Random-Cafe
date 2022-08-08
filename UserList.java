import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;

public class UserList extends User
{
	static Vector<User> user = new Vector<User>(); // 개인 정보를 담는 그릇
	public static boolean flag;
	public static String pn;
	public static int couponForLogIn; 
	public static int dispUserNumber;
	
	// 실험용 임시 기존회원들
	static
	{
		user.add(new User("김"));
		user.add(new User("이"));
		user.add(new User("박"));
		user.get(1).setCoupon(1);
		user.get(2).setCoupon(2);
	}
	
	// 쿠폰 사용 및 스탬프 적립시 호출되는 로그인 메소드
	public static void userLogin() throws IOException
	{
		// 로그인 메소드가 호출되면 번호를 입력받고 이를 변수 pn에 저장함
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 번호를 입력하세요 : " );
		pn = sc.next();

		for (int i = 0; i < user.size(); i++)
		{
			// 반복문을 활용해 User객체가 담긴 user 벡터를 탐색
			// getPhoneNumber() 메서드는 저장되어있는 핸드폰 번호를 반환하는 메소드
			// 그게 pn과 일치하면 기존회원이라는 뜻
			if (user.get(i).getPhoneNumber().equals(pn)) // 기존 회원
			{
				// 로그인에 성공했으면 enroll 메소드 수행
				enroll(i);

				flag = true;
				couponForLogIn = user.get(i).getCoupon();
				break;
			}
			// pn과 일치하는 번호가 없으면 신규회원
			else if (!user.get(i).getPhoneNumber().equals(pn) && i == user.size() - 1) // 신규 회원
			{
				// 신규 회원가입을 위해 벡터의 add메서드를 활용해주고 생성자 매개변수로 pn을 넣어줌
				user.add(new User(pn));
				// 가입이 성공했으면 마찬가지로 enroll 메소드 수행
				enroll(user.size() - 1);
				
				break;
			}
		}
	}
	
	public static void enroll(int i)
	{
		// 회원 번호 설정. (로그인 성공한 객체를 다룬 곳에서도 다루기 위해서)
		user.get(i).setUserNumber(i + 1);
		dispUserNumber = user.get(i).getUserNumber();
		
		// Stamp 클래스의 userStamp와 userCoupon 변수에
		// 회원 객체에 담겨있는 스탬프 갯수 정보 (보유 중인 스탬프 갯수)를 대입
		Stamp.userStamp = user.get(i).getStamp();
		Stamp.userCoupon = user.get(i).getCoupon();
		// 스탬프 계산 메소드 실행
		Stamp.stampCal();
		
		// 스탬프 계산이 종료된 후 정리된 스탬프와 쿠폰 정보를 다시 유저 객체에 저장
		user.get(i).setStamp(Stamp.userStamp);
		user.get(i).setCoupon(Stamp.userCoupon);
	}
}