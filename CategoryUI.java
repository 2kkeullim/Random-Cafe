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
		System.out.println("-------------");
		System.out.print("메뉴를 선택하세요(1 ~ 6) : ");
	}

	public static void categorySelect() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{


			if (MenuUI.sel >= 1 && MenuUI.sel <= 6)
			{
				category();
				sel = Integer.parseInt(br.readLine());
				categoryRun();
				break;
			}
			else
			{
				System.out.println("다시 입력하세요");
				category();
			}
		}
		while (true);
	}

	public static void categoryRun()
	{
		switch (sel)
		{
		case 1: 
		case 2: 
		case 3: 
		case 4: 
		case 5: 
		case 6: DrinkUI.drinkUISelect(); break;
		}
	}

	public static void main(String[] args) throws IOException
	{
		//do
		//{
			category();
			categorySelect();
			categoryRun();
		//}
		//while (true);

	}
}