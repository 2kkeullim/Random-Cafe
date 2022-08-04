import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CategoryUI
{
	public static int sel = 1;

	public static void category()
	{
		System.out.println("1. coffee");
		System.out.println("2. non-coffee");
		System.out.println("3. juice");
		System.out.println("4. smoothie");
		System.out.println("5. tea");
		System.out.println("6. ade");
		System.out.println("7. 장바구니");
		System.out.println("8. 뒤로가기");
		System.out.println("-------------");
		System.out.print("메뉴를 선택하세요(1 ~ 8) : ");
	}

	public static void categoryRun() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			sel = Integer.parseInt(br.readLine());

			if (sel >= 1 && sel <= 6)
			{
				DrinkUI.drinkRun();
				category();
			}
			else if (sel != 7 && sel != 8)
			{
				System.out.println("\n다시 입력하세요\n");
				category();
			}
			if (sel == 7)
			{
				cart(); 
				break;
			}
		}
		while (sel != 7 && sel != 8);
	}

	public static void cart()
	{
		System.out.println("cart 입니다");
	}

	
}