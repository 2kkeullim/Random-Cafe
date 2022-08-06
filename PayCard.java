import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayCard 
{
	public static void cardInsert() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		do
		{
			System.out.print(">> 카드투입 : Y or y, 뒤로 가기 : Ctrl+z : ");
			str = br.readLine();
			if(str==null)
				Pay.cashOrCard();
		}
		while (!(str.equals("y") || str.equals("Y")));
		
		int temp;
		do
		{
			System.out.print("결제되었습니다. 스탬프를 적립하시겠습니까? (예 : 1 , 아니오 : 2) : ");
			temp = Integer.parseInt(br.readLine());
			if(temp<1 || temp>2)
			{
				System.out.println("다시 입력해 주십시오.");
				continue;
			}
			switch(temp)
			{
				case 1: UserList.userLogin(); break;
				case 2: Receipt.receiptDispForCard(); break;
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
		while (temp<1 || temp>2);
	}

}
