import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NonCoffee
{
	public static final int cost = 2000;
	public String hotOrCold; 
	public String ice; 
	public int drinkCount;     //음료 선택 갯수
	
	public void option() throws IOException
	{
		String temp; 
		int tempIce;
		drinkCount = 0;
		do
		{
			System.out.print("Hot 또는 Cold 를 선택하세요. (h(H) or c(C)) 입력 : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			temp = br.readLine();
			if(temp.equals("c") || temp.equals("C"))
			{	
				hotOrCold = "cold";
				do
				{
					System.out.print("얼음양을 선택해 주세요. (1: 없음 2: 보통 3: 많이) 입력 : ");
					tempIce = Integer.parseInt(br.readLine());
					if(tempIce <1 || tempIce >3)
						System.out.println("얼음양을 다시 선택해 주세요.");
				}
				while (tempIce <1 || tempIce >3 );
				
				switch (tempIce)
				{
					case 1: ice = "얼음 없음" ; break;
					case 2: ice = "얼음 보통" ; break;
					case 3: ice = "얼음 많이" ; break;
				}

				cupsCount();
			}
			else if(temp.equals("h") || temp.equals("H"))
			{
				hotOrCold = "hot";
				ice = " ";

				cupsCount();
			}
			else
			{
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 (h(H) 또는 c(C)) ");
			}
		}
		while (!((temp.equals("c") || temp.equals("C") || temp.equals("h") || temp.equals("H"))));
	}

	public void cupsCount() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
			{
				System.out.print("선택하신 음료의 개수를 선택하세요(최대 주문 갯수 : 30). : ");
				drinkCount = Integer.parseInt(br.readLine());
				if(drinkCount < 1 || drinkCount > 30)
					System.out.println("음료의 개수를 다시 입력해주세요.");
			}
			while (drinkCount < 1 || drinkCount > 30);
	}

}