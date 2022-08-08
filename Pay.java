import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Pay
{
	public static final int card = 1;
	public static final int cash = 2;
	public static final int yes = 1;
	public static final int no = 2;
	public static int sel = 1;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

	public static void cashOrCard() throws IOException
	{
		do
		{
			System.out.print(">> 결제 방식을 선택하여 주십시오. (1: 카드 결제,  2: 현금 결제) : ");
			sel = Integer.parseInt(br.readLine());

			if (sel < card || sel > cash)
			{
				System.out.println("다시 입력해 주십시오.");
				continue;
			}

			switch (sel)
			{
				case card: PayCard.cardInsert(); break;
				case cash: PayCash.cashInsert(); break;
			}
		}
		while (sel < card || sel > cash);	
	}

	public static void insert() throws IOException
	{
		String str;

		if (sel == card)
			System.out.println("\n──────────────────── [카드  결제] ────────────────────");
		else if (sel == cash)
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
			sel = Integer.parseInt(br.readLine());

			if (sel < yes || sel > no)
				System.out.println("다시 입력해 주십시오.");
		}
		while (sel < 1 || sel > no);
		
		switch (sel)
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