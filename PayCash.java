import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayCash 
{
	public static void cashInsert() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		do
		{
			System.out.print(">> 현금투입 : Y or y, 뒤로 가기 : Ctrl+z : ");
			str = br.readLine();
			if(str == null)
				Pay.cashOrCard();
		}
		while (!(str.equals("y") || str.equals("Y")));
		
		
		int temp;
		do
		{
			System.out.print("현금 얼마를 투입하시겠니까? :");
			temp = Integer.parseInt(br.readLine());
			if(temp%500 != 0)
			{
				System.out.println("다시 입력해 주십시오.");
				continue;
			}
			ReturnChange.pay   = temp;
			ReturnChange.drink = Cart.totalSum;  
			ReturnChange.change = ReturnChange.pay-ReturnChange.drink ;
			ReturnChange.changePrint();		//잔돈반환결과
			Receipt.receiptDispForCash();
	
		}
		while (temp%500 != 0);
	}

}
