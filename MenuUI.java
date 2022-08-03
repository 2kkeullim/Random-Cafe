import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DrinkUI
{
	public static int sel = 1;

	static String[] coffee = {"1. 아메리카노", "2. 카페라떼", "3. 바닐라라떼", "4. 카페모카", "5. 돌체라떼", "6. 랜덤커피" };
	static String[] nonCoffee = {"1. 녹차라떼","2. 초코라떼","3. 고구마라떼","4. 곡물라떼","5. 딸기라떼","6. 랜덤라떼"};
	static String[] juice = {"1. 사과주스","2. 오렌지주스","3. 포도주스","4. 망고주스","5. 딸기주스","6. 랜덤주스"};
	static String[] smoothie = {"1. 오렌지스무디","2. 청포도스무디","3. 망고스무디","4. 딸기스무디","5. 요거트스무디","6. 랜덤스무디"};
	static String[] tea = {"1. 그린티","2. 얼그레이티","3. 페퍼민트","4. 복숭아티","5. 캐모마일","6. 랜덤티"};
	static String[] ade = {"1. 레몬에이드","2. 유자에이드","3. 망고에이드","4. 자몽에이드","5. 청포도에이드","6. 랜덤에이드"};
	
	public static void drinkUISelect() throws IOException
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("카테고리 번호 선택 (1~6) : ");
			sel = Integer.parseInt(br.readLine());

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
		for (int i=0;i<coffee.length ;i++ )
			System.out.printf("%s%n", coffee[i]);
	}
	
	public static void nonCoffee()
	{
		for (int i=0;i<nonCoffee.length ;i++ )
			System.out.printf("%s%n", nonCoffee[i]);
	}
	
	public static void juice()
	{
		for (int i=0;i<juice.length ;i++ )
			System.out.printf("%s%n", juice[i]);
	}
	
	public static void smoothie()
	{
		for (int i=0;i<smoothie.length ;i++ )
			System.out.printf("%s%n", smoothie[i]);
	}
	
	public static void tea()
	{
		for (int i=0;i<tea.length ;i++ )
			System.out.printf("%s%n", tea[i]);
	}
	
	public static void ade()
	{
		for (int i=0;i<ade.length ;i++ )
			System.out.printf("%s%n", ade[i]);
	}
	

	public static void main(String[] args) throws IOException
	{
		drinkUISelect();
	}

}
