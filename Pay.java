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
				case card: PayCard.cardInsert(); break;
				case cash: PayCash.cashInsert(); break;
			}
		}
		while (selPay < card || selPay > cash);	
	}

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

			if (str == null)
				cashOrCard();
		}
		while (!(str.equals("y") || str.equals("Y")));
	}

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
			case yes: UserList.userLogin(); UserList.saveStampCash();
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