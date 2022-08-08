import java.io.IOException;

public class ReturnChange
{
	// 소비자가 지불한 금액
	static int pay; 
	// 소비자가 구매한 총액
	static int drink;
	// pay - drink = 거슬러줘야할 잔돈
	static int change;
	
	// 손님에게 건네준 잔돈을 담을 변수
	private static int returnChangeSum = 0;
	private static int returnChange500 = 0;
	private static int returnChange1000 = 0;
	private static int returnChange5000 = 0;
	private static int returnChange10000 = 0;
	
	// 각 화폐단위가 손님에게 건네진 횟수
	private static int count10000 = 0;
	private static int count5000 = 0;
	private static int count1000 = 0;
	private static int count500 = 0;

	public static void changeCal()	// 잔돈 계산
	{
		// 만약 보유 중인 10000짜리 지폐가 소비자가 낸 돈보다 많다면 true
		// 그렇지 않으면 false 반환
		boolean change10000Flag = 10000 * Change.change.get(10000) >= change;

		if (change10000Flag)
		{
			// 만원짜리가 거슬러줘야할 잔돈보다 많다면 거슬러주기 실행
			// 만약 손님에게 500원을 거슬러줘야 한다면?
			// returnChange10000 += 0
			// count10000 += 0
			// change -= 0
			// ==> 아무런 변화가 없이 다음 Flag변수로 이동함
			returnChange10000 += (10000 * (change/10000));
			count10000 += change/10000;
			change -= returnChange10000;
		}
		// 만약 만원짜리 총액이 거슬러줘야할 돈보다 모자라다면.
		// 동시에 잔돈이 10000단위보다 크고 10000원 보유량이 0이 아니라면
		// 잔돈이 45000원, 10000원 보유량이 4개라고 가정해봄.
		else if (change / 10000 != 0 && Change.change.get(10000) != 0)
		{
			// returnChange10000 += 40000
			// count10000 += 4
			// change -= 40000
			// => 만원짜리 4장만큼 잔돈을 차감시켜주고
			// returnChange10000 변수에 4만을 대입시킴
			// 이후 잔돈보유량 갱신할 때 count10000 수만큼 10000원 보유량 삭감.
			returnChange10000 += (10000 * Change.change.get(10000));
			count10000 += Change.change.get(10000);
			change -= returnChange10000;
		}
		
		// 위에서 거슬러준 45000원 케이스를 계속해서 진행해봄.
		// 4만원을 거슬러줬으므로 5000원만 더 거슬러주면 되는 상황.
		// 즉 change = 5000 이고 5000원 보유량이 1 이상이면
		// 위와 똑같은 로직을 실행해 잔돈을 0으로 만들어줌.
		boolean change5000Flag = 5000 * Change.change.get(5000) >= change;
		
		// 5000원짜리 보유량이 change(5000)보다 크다고 가정
		if (change5000Flag)
		{
			// returnChange 5000 += 5000
			// count5000 += 1
			// change -= 5000
			// => change = 0이 됨
			// 이후 if문에서는 10000원짜리 케이스처럼 전부
			// 아무런 변화가 없이 통과됨
			returnChange5000 += (5000 * (change/5000));
			count5000 += change/5000;
			change -= returnChange5000;
		}
		else if (change/5000 != 0 && Change.change.get(5000)!= 0)
		{
			returnChange5000 += (5000 * Change.change.get(5000));
			count5000 += Change.change.get(5000);
			change -= returnChange5000;
		}
		
		boolean change1000Flag = 1000 * Change.change.get(1000) >= change;

		if (change1000Flag)
		{
			returnChange1000 += (1000 * (change/1000));
			count1000 += change/1000;
			change -= returnChange1000;
		}
		else if (change/1000 != 0 && Change.change.get(1000) != 0) // 3
		{
			returnChange1000 += (1000 * Change.change.get(1000));
			count1000 += Change.change.get(1000);
			change -= returnChange1000;
		}
		
		boolean change500Flag = 500 * Change.change.get(500) >= change;

		if (change500Flag)
		{
			returnChange500 += (500 * (change/500));
			count500 += change/500;
			change -= returnChange500;
		}
		else if (change/500 != 0 && Change.change.get(500)!= 0) // 1
		{
			returnChange500 += (500 * Change.change.get(500));
			count500 += Change.change.get(500);
			change -= returnChange500; // 500
		}
	}

	public static void changePrint() throws IOException	// 잔돈 반환 결과 출력
	{
		// 출력 메소드에서 잔돈계산 메소드 실행
		changeCal();
		// returnChange10000 = 40000
		// returnChange5000 = 5000 이므로 총 45000원을 거슬러줌
		// returnChange1000, 500은 이미 change가 0이 됐으므로 0임
		returnChangeSum = returnChange10000+returnChange5000+returnChange1000+returnChange500;
		// change가 0이라는 말은 거슬러줘야할 잔돈을 전부 거슬러줬다는 의미
		if (change == 0)
		{
			System.out.println("──────────────────────────────────────────────────────");
			if (count10000 != 0)
				System.out.printf(" ▶ 10000원  %d장%n", count10000);
			
			if (count5000 != 0)
				System.out.printf(" ▶  5000원  %d장%n", count5000);

			if (count1000 != 0)
				System.out.printf(" ▶  1000원  %d장%n", count1000);

			if (count500 != 0)
				System.out.printf(" ▶   500원  %d개%n", count500);

			System.out.printf("%n ==> 총 거스름돈 %d원 입니다.%n", returnChangeSum);
			System.out.println("──────────────────────────────────────────────────────");
		}
		// change가 0이 아니라면 잔돈 보유량이 부족하다는 의미이므로
		// 카운터에 문의해달라는 메세지를 출력
		else
		{
			System.out.println("──────────────────────────────────────────────────────");
			System.out.println("       잔돈이 부족하니 카운터로 문의해주세요.");
			System.out.println("──────────────────────────────────────────────────────");
			
			Cart.vc.clear();
			Cart.totalSum = 0;

			// 잔돈이 부족하면 다시 첫화면으로 돌아감
			Cafe.operate();
		}
		// 잔돈이 무사히 거슬러졌다면
		// 잔돈 보유량 갱신 메소드인 changeReNew() 메서드 실행
		changeReNew();
		// 잔돈 계산식을 초기화해주는 메소드
		changeReset();
	}
	
	public static void changeReNew() // 잔돈 보유량 갱신
	{
		// 해쉬맵 put메소드를 활용해 잔돈 보유량 - count액수 변수
		// 계산을 수행해 결과값을 각 화폐 단위 밸류값에 대입시켜줌
		Change.change.put(10000, Change.change.get(10000) - count10000);
		Change.change.put(5000, Change.change.get(5000) - count5000);
		Change.change.put(1000, Change.change.get(1000) - count1000);
		Change.change.put(500, Change.change.get(500) - count500);
	}

	public static int getChangeSum()
	{
		return returnChangeSum;
	}

	public static void changeReset()
	{
		count10000 = 0;
		count5000 = 0;
		count1000 = 0;
		count500 = 0;	
		returnChange500 = 0;
		returnChange1000 = 0;
		returnChange5000 = 0;
		returnChange10000 = 0;
	}
}