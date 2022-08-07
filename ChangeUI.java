import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ChangeUI
{
	public static void checkChange()					// 잔돈 보유량확인 메소드
	{
		System.out.println("\n┌────────────────────────────────────────────────────┐");
		System.out.println("│                 [현재 잔돈 보유량]                 │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.out.printf(" ▶    500원 : %3d개 = %8d원\n", Change.change.get(500), 500 * Change.change.get(500));
		System.out.printf(" ▶   1000원 : %3d개 = %8d원\n", Change.change.get(1000), 1000 * Change.change.get(1000));
		System.out.printf(" ▶   5000원 : %3d개 = %8d원\n", Change.change.get(5000), 5000 * Change.change.get(5000));
		System.out.printf(" ▶  10000원 : %3d개 = %8d원\n", Change.change.get(10000), 10000 * Change.change.get(10000));
		System.out.println("──────────────────────────────────────────────────────");
		System.out.printf(" ==> 총액은 %d원입니다.\n\n", Change.sum());
	}

	public static void addChange() throws IOException	// 잔돈 추가 메소드
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		System.out.println("\n┌────────────────────────────────────────────────────┐");
		System.out.println("│                    [잔돈  추가]                    │");
		System.out.println("│                                                    │");
		System.out.println("│          (500원, 1000원, 5000원, 10000원)          │");
		System.out.println("└────────────────────────────────────────────────────┘");

		do
		{
			System.out.print("\n>> 금액 단위와 개수를 입력해 주세요.(공백 구분) : ");

			int unit = sc.nextInt();
			int count = sc.nextInt();

			if ((unit != 500) && (unit != 1000) && (unit != 5000) && (unit != 10000))
				System.out.println("잘못된 금액 단위 입니다. 다시 입력해주세요." + "\n");
			else if ((unit == 500 && count + Change.change.get(unit) > 100) || (unit != 500 && count + Change.change.get(unit) > 50))
				System.out.println("추가하려는 잔돈의 갯수가 너무 많습니다. 다시 입력해주세요." + "\n");
			else
			{
				System.out.printf("\n==> %d원을 %d개 추가 하였습니다.\n\n",unit, count);
				count += Change.change.get(unit);
				Change.change.put(unit, count);
			}
			System.out.print(">> 잔돈 추가 : Y or y, 뒤로 가기 : Ctrl+z : ");
		}
		while ((str=br.readLine()) != null);
	}
}