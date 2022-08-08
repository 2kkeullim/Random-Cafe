import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PayCash 
{
	public static void cashInsert() throws IOException
	{
		// 현금 계산시에도 pay 메서드 매개변수에 "cash" 대입.
		Pay.insert();
		// 현금은 액수를 입력받고 잔돈도 반환해줘야 하므로
		// 따로 cashCheck() 메서드를 한 번 더 수행
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
			
			// 음료가 500원 단위로 떨어지고
			// 잔돈의 최소 액수가 500원이므로 100원 단위는 받지 않음.
			// 액수가 500원 단위로 나누어 떨어지지 않으면 
			// 다시 입력해달라는 안내 메세지 출력
			if (cash % 500 != 0)
			{
				System.out.println("\n다시 입력해 주십시오.\n");
				continue;
			}
			
			// 장바구니 총액보다 부족한 현금을 제시하면
			// 다시 입력해달라는 안내문구 출력.
			if (cash < Cart.totalSum)
			{
				System.out.println("\n잘못된 투입금액입니다. 다시 입력해 주십시오.\n");
				continue;
			}
			
			// 잔돈 반환을 위해 ReturnChage.pay 에는 
			// 소비자가 지불한 금액을 대입
			ReturnChange.pay = cash;
			// ReturnChange.drink 에는 구매 총액을 대입
			ReturnChange.drink = Cart.totalSum;
			// change 변수에는 pay - drink. 즉 낸 돈 - 구매총액을 대입
			ReturnChange.change = ReturnChange.pay - ReturnChange.drink;
			ReturnChange.changePrint();				// 잔돈 반환 결과
		}
		while (cash % 500 != 0 || cash < Cart.totalSum);
	}
}
