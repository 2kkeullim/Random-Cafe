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
		}
		while (temp%500 != 0);
	
		
		do
		{
			System.out.print("스탬프를 적립하시겠습니까? (예 : 1 , 아니오 : 2) : ");
			temp = Integer.parseInt(br.readLine());
			if(temp<1 || temp>2)
				System.out.println("다시 입력해 주십시오.");
		}
		while (temp<1 || temp>2);
		
		switch(temp)
		{
			case 1: UserList.userLogin(); break;
			case 2: Receipt.receiptDispForCash(); break;
		}
		Sales.totalCard += Cart.totalSum;     //카드 총매출 누적합.

		Cart.vc.clear();
		Cart.totalSum = 0;
		System.out.println();
		do
		{
			InitialUI.menuDisp();
			InitialUI.menuSelect();
			InitialUI.menuRun();
		}
		while (true);
	}

}
