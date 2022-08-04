import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AddChange
{
	public static void addChanges() throws IOException  // 잔돈 추가 메소드
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		System.out.println("입력 가능 금액 단위 (500원 1000원 5000원 10000원)");

		do
		{
			System.out.print("금액 단위와 개수를 입력해 주세요. (공백 구분) : ");

			int unit = sc.nextInt();

			if ((unit != 500) && (unit != 1000) && (unit != 5000) && (unit != 10000))
			{
				System.out.println("잘못된 금액 단위 입니다. 다시 입력 해주세요." + "\n");
				continue;
			}

			int existingCount = Change.change.get(unit);
			int count = sc.nextInt();

			if ((unit == 500 && count > 100) || (unit != 500 && count > 50))
			{
				System.out.println("추가하려는 잔돈의 갯수가 너무 많습니다. 다시 입력해주세요." + "\n");
				continue;
			}

			Change.change.put(unit,count + existingCount);

			System.out.printf("%d원을 %d개 추가 하였습니다.\n", unit, count);

			System.out.print("잔돈 추가를 계속하시려면 아무 키나 누르세요!(종료: Ctrl+z) : ");
		}
		while ((str=br.readLine()) != null);
	}
}