import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MainUI
{
	public static int sel = 1;

	public static void categories()
	{
		System.out.println("1. coffee");
		System.out.println("2. non-coffee");
		System.out.println("3. juice");
		System.out.println("4. smoothie");
		System.out.println("5. tea");
		System.out.println("6. ade");
		System.out.println("-------------");
		System.out.print("메뉴를 선택하세요(1 ~ 6)");
	}

	public static void ctgSelect() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			sel = Integer.parseInt(br.readLine());

			if (sel >=1 && sel <=6)
				break;
			else
			{
				System.out.println("다시 입력하세요");
				categories();
			}
		}
		while (true);
	}

	public static void ctgRun()
	{
		switch (sel)
		{
		case 1: coffee(); break;
		case 2: nonCoffee(); break;
		case 3: juice(); break;
		case 4: smoothie(); break;
		case 5: tea(); break;
		case 6: ade(); break;
		}
	}

	public static void coffee()
	{
		System.out.println("1. 커피 입니다");
	}

	public static void nonCoffee()
	{
		System.out.println("2. 논커피 입니다");
	}

	public static void juice()
	{
		System.out.println("3. 주스 입니다");
	}

	public static void smoothie()
	{
		System.out.println("4. 스무디 입니다");
	}

	public static void tea()
	{
		System.out.println("5. 티 입니다");
	}

	public static void ade()
	{
		System.out.println("6. 에이드 입니다");
	}

	public static void main(String[] args) throws IOException
	{
		do
		{
			categories();
			ctgSelect();
			ctgRun();
		}
		while (true);

	}
}