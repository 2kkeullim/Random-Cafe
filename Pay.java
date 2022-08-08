import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Pay
{
	public static final int card = 1;
	public static final int cash = 2;
	public static final int yes = 1;
	public static final int no = 2;
	public static int selPay = 1;
	public static int selStamp = 1;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
	// 사용자로부터 값을 입력받아 카드결제, 현금결제를 선택받는 메서드
	public static void cashOrCard() throws IOException
	{
		do
		{
			System.out.print(">> 결제 방식을 선택하여 주십시오. (1 : 카드 결제,  2 : 현금 결제) : ");
			selPay = Integer.parseInt(br.readLine());

			if (selPay < card || selPay > cash)
			{
				System.out.println("다시 입력해 주십시오.");
				continue;
			}

			switch (selPay)
			{
				// 사용자가 입력받는 값에 따라 PayCard 혹은 PayCash 클래스의
				// 결제 메소드를 호출함
				case card: PayCard.cardInsert(); break;
				case cash: PayCash.cashInsert(); break;
			}
		}
		while (selPay < card || selPay > cash);	
	}
	
	// 카드, 혹은 현금 결제를 선택했으면 insert()메서드 실행.
	public static void insert() throws IOException
	{
		String str;

		if (selPay == card)
			System.out.println("\n──────────────────── [카드  결제] ────────────────────");
		else if (selPay == cash)
			System.out.println("\n──────────────────── [현금  결제] ────────────────────");

		do
		{
			System.out.print(">> 투입 : Y or y, 뒤로 가기 : Ctrl+z : ");
			str = br.readLine();
			
			// 뒤로가기를 선택했으면 다시 결제방식 선택 단계로 돌아감
			if (str == null)
				cashOrCard();
		}
		while (!(str.equals("y") || str.equals("Y")));
	}
	
	// 결제완료 후 적립과 매출처리를 동시에 처리하는 메소드
	public static void pay(String str) throws IOException
	{
		do
		{
			System.out.print(">> 스탬프를 적립하시겠습니까? (예 : 1 , 아니오 : 2) : ");
			selStamp = Integer.parseInt(br.readLine());

			if (selStamp < yes || selStamp > no)
				System.out.println("다시 입력해 주십시오.");
		}
		while (selStamp < 1 || selStamp > no);
		
		switch (selStamp)
		{
			// 적립하기를 눌렀다면 다시 로그인메소드 호출하고
			// stamp 클래스의 적립결과출력 메소드인 printStampResult() 호출
			case yes: UserList.userLogin(); Stamp.printStampResult();
			// 적립하지 않기를 눌렀다면 바로 영수증 출력
			case no: Receipt.receiptDispRun(); break;
		}

		if (str.equals("card"))
			Sales.totalCard += Cart.totalSum;		// 카드 총매출 누적합
		else if (str.equals("cash"))
			Sales.totalCash += Cart.totalSum;		// 현금 총매출 누적합
		Sales.totalSale += Cart.totalSum;			// 총매출 누적합

		Cart.vc.clear();
		Cart.totalSum = 0;

		System.out.println();

		Cafe.operate();
	}
}