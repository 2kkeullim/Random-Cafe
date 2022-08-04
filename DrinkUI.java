import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DrinkUI
{
	public static int sel = 1;

	static String[][] category = {{"1. 아메리카노", "2. 카페라떼", "3. 바닐라라떼", "4. 카페모카", "5. 돌체라떼", "6. 랜덤커피", "7. 뒤로가기"},
		{"1. 녹차라떼", "2. 초코라떼", "3. 고구마라떼", "4. 곡물라떼", "5. 딸기라떼", "6. 랜덤라떼", "7. 뒤로가기"},
		{"1. 사과주스", "2. 오렌지주스", "3. 포도주스", "4. 망고주스", "5. 딸기주스", "6. 랜덤주스","7. 뒤로가기"},
		{"1. 오렌지스무디", "2. 청포도스무디", "3. 망고스무디", "4. 딸기스무디", "5. 요거트스무디", "6. 랜덤스무디", "7. 뒤로가기"},
		{"1. 그린티", "2. 얼그레이티", "3. 페퍼민트", "4. 복숭아티", "5. 캐모마일", "6. 랜덤티", "7. 뒤로가기"},
		{"1. 레몬에이드", "2. 유자에이드", "3. 망고에이드", "4. 자몽에이드", "5. 청포도에이드", "6. 랜덤에이드", "7. 뒤로가기"}};
	
	public static void drinkRun() throws IOException
	{
		System.out.println();
		for (int i = 0; i < category[CategoryUI.sel-1].length; i++)
			System.out.printf("%s%n", category[CategoryUI.sel-1][i]);
		System.out.println();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			System.out.print("음료를 선택하세요 : ");
			sel = Integer.parseInt(br.readLine()); 

			if (sel >= 1 && sel <= 6)
				DrinkUI.drinkRun();
			else if (sel != 7)
			{
				System.out.println("\n다시 입력하세요\n");
			}
		}
		while(sel != 7);
	}
}
