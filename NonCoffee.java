import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;




public class NonCoffee
{
	public static final int cost = 2000;
	Vector<Object> ncVec;
	NonCoffee()
	{
		 ncVec = new Vector<Object>();
	}
	
	public void option() throws IOException
	{
		String temp; 
		int tempIce;
		do
		{
			System.out.print("Hot 또는 Cold 를 선택하세요. (h(H) or c(C)) 입력 : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			temp = br.readLine();
			if(temp.equals("c") || temp.equals("C"))
			{	
				ncVec.add(2,"cold");
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
					case 1: ncVec.add(3, "얼음 없음") ; break;
					case 2: ncVec.add(3, "얼음 보통") ; break;
					case 3: ncVec.add(3, "얼음 보통") ; break;
				}

				cupsCount();
			}
			else if(temp.equals("h") || temp.equals("H"))
			{
				ncVec.add(2,"hot");
				ncVec.add(3," ");
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
		int drinkCount = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
			{
				System.out.print("선택하신 음료의 개수를 선택하세요(최대 주문 갯수 : 30) : ");
				drinkCount = Integer.parseInt(br.readLine());
				ncVec.add(4, drinkCount);
				if(drinkCount < 1 || drinkCount > 30)
					System.out.println("음료의 개수를 다시 입력해주세요.");
			}
			while (drinkCount < 1 || drinkCount > 30);
	}
	
	public Vector<Object> greenTeaLatte() throws IOException
	{
		ncVec.add(0,"녹차라떼");
		ncVec.add(1,1500);
		option();
		return ncVec;
	}

	public Vector<Object> chocoLatte() throws IOException
	{
		ncVec.add(0, "초코라떼");
		ncVec.add(1,3500);
		option();
		return ncVec;
	}

	public Vector<Object> sweetPotatoLatte() throws IOException
	{
		ncVec.add(0, "고구마라떼");
		ncVec.add(1,4000);
		option();
		return ncVec;
	}

	public Vector<Object> grainLatte() throws IOException
	{
		ncVec.add(0, "곡물라떼");
		ncVec.add(1,4000);
		option();
		return ncVec;
	}

	public Vector<Object> strawBerryLatte() throws IOException
	{
		ncVec.add(0, "딸기라떼");
		ncVec.add(1,4500);
		option();
		return ncVec;
	}

}
