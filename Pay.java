import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Pay
{
	public static int sel=1;

	public static void cashOrCard() throws IOException
	{
		do
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
			System.out.print("결제 방식을 선택하여 주십시오. (1: 카드 결제  2: 현금 결제 ) : ");
			sel = Integer.parseInt(br.readLine());
			if(sel<1 || sel>2)
			{
				System.out.println("다시 입력해 주십시오.");
				continue;
			}
			switch(sel)
			{
				case 1: cardInsert(); break;
				case 2: cashInsert(); break;
			}
			
		
		}
		while (sel<1 || sel>2);
			
	}
	public static void cardInsert() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		do
		{
			System.out.print(">> 카드투입 : Y or y, 뒤로 가기 : Ctrl+z : ");
			str = br.readLine();
			if(str==null)
				cashOrCard();
		}
		while (str != null);
		
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
		}
		while (temp<1 || temp>2);
	}

	public static void cashInsert() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		do
		{
			System.out.print(">> 현금투입 : Y or y, 뒤로 가기 : Ctrl+z : ");
			str = br.readLine();
			if(str == null)
				cashOrCard();;
		}
		while (str != null);
		
		
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
			ReturnChange.drink = Cart.totalSum;  //이게 걱정
			ReturnChange.changeCal();       //잔돈계산
			ReturnChange.changePrint();		//잔돈반환결과
			ReturnChange.changeReNew();		//잔돈보유량 갱신
		}
		while (temp%500 != 0);
		
	}

}