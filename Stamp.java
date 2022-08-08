public class Stamp extends UserList
{
	// 로그인 후 유저가 보유중인 스탬프 수
	public static int userStamp;
	// 로그인 후 유저가 보유중인 쿠폰 수
	public static int userCoupon;
	public static int drinkCountForStamp;

	public static void stampCal()
	{
		// 구매한 음료의 갯수를 담을 변수
		drinkCountForStamp = 0;
		
		// couponUseCount가 0이 아니라는 말은 쿠폰을 사용한 음료가 있다는 말이므로
		// 유저 보유 쿠폰수를 -1 시켜줌.
		// 그리고 couponUseCount는 역할을 여기서 다했으므로 다시 0으로 초기화시켜줌.
		if (Cart.couponUseCount != 0)
		{
			drinkCountForStamp--;
			userCoupon--;
			Cart.couponUseCount = 0;
		}
		
		// 장바구니에 담긴 음료 객체를 반복문으로 찾아서
		// 구매자가 구매한 음료 갯수만큼 drinkCountForStamp 변수를 증가시켜줌
		for (int i = 0; i < Cart.vc.size(); i++)
		{
			drinkCountForStamp += Cart.vc.get(i).getCount();		// 구매자가 구매한 음료 갯수
			
			// 장바구니 음료 객체 중 쿠폰을 사용한 메뉴가 있다면 if문 수행
			if (Cart.vc.get(i).getCouponUse() == true)
			{
				// 위에 코드와 충돌을 일으키는 코드인데
				// 처음에는 쿠폰 할인메소드를 작성할 때 가격정보를 조정해서 수행하려고 했으나
				// 실패하고 갯수를 조정하는 방식으로 바꿈.
				// 가격을 조정할때는 위에서 -1을 시켜줘서 딱 맞았었는데
				// 갯수를 조정하는 방식으로 바꾸니까 음료갯수가 -2가 돼서
				// 여기서 다시 +1을 시켜주는 방식으로 오차를 조정해줌.
				drinkCountForStamp++;
				// 해당 음료객체의 CouponUse를 다시 false로 전환해줌
				Cart.vc.get(i).setCouponUse(false);
			}
		}
		
		// 유저 스탬프를 음료수만큼 증가시켜줌
		userStamp += drinkCountForStamp;
		
		// 유저스탬프가 10개가 넘어가면 if문 수행
		if (userStamp >= 10)
		{
			// 쿠폰 수는 userStamp를 10으로 나눈 몫만큼 증가시켜줌
			userCoupon += userStamp / 10;
			// 스탬프 수는 10으로 나눈 나머지 만큼을 다시 대입시켜줌
			userStamp = userStamp % 10;
		}
	}
	
	// 적립 결과 출력 메소드
	public static void printStampResult()
	{
		System.out.println("\n┌────────────────────────────────────────────────────┐");
		System.out.println("│            스탬프 적립이 완료되었습니다.           │");
		System.out.println("└────────────────────────────────────────────────────┘");
		
		// 기존 회원으로 로그인 했을때의 flag 변수는 true
		if (flag == true)
		{
			// UserList에서 설정한 회원번호가 여기서 로그인한 유저 정보를 불러오기 위한 인덱스 번호로 쓰임
			System.out.println("- 적립 후 스탬프 수 : " + user.get(dispUserNumber - 1).getStamp());
			System.out.println("- 적립 후 쿠폰 수   : " + user.get(dispUserNumber - 1).getCoupon());
			flag = false;
		}
		else
		{
			// flag가 false인 경우는 신규회원인 경우
			// 인덱스 번호는 어차피 add변수로 인해 맨 끝이므로 user.size()-1 번째의 객체를 조회해줌
			System.out.println("- 적립 후 스탬프 수 : " + user.get(user.size() - 1).getStamp());
			System.out.println("- 적립 후 쿠폰 수   : " + user.get(user.size() - 1).getCoupon());
		}
		System.out.println("──────────────────────────────────────────────────────");
	}
}