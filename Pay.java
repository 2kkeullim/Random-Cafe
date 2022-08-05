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
				case 1: PayCard.cardInsert(); break;
				case 2: PayCash.cashInsert(); break;
			}
		}
		while (sel<1 || sel>2);	
	}
}