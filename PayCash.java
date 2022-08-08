import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PayCash 
{
	public static void cashInsert() throws IOException
	{
		Pay.insert();
		cashCheck();
		Pay.pay("cash");
	}

	public static void cashCheck() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cash;

		do
		{
			System.out.print(">> 현금 얼마를 투입하시겠습니까? : ");
			cash = Integer.parseInt(br.readLine());

			if (cash % 500 != 0)
			{
				System.out.println("\n다시 입력해 주십시오.\n");
				continue;
			}

			if (cash < Cart.totalSum)
			{
				System.out.println("\n잘못된 투입금액입니다. 다시 입력해 주십시오.\n");
				continue;
			}

			ReturnChange.pay = cash;
			ReturnChange.drink = Cart.totalSum;
			ReturnChange.change = ReturnChange.pay - ReturnChange.drink;
			ReturnChange.changePrint();				// 잔돈 반환 결과
		}
		while (cash % 500 != 0 || cash < Cart.totalSum);
	}
}
