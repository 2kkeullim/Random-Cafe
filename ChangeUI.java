public class ChangeUI
{
	public static void change()    // 잔돈 보유량확인 메소드
	{
		System.out.println();
		System.out.println("┌────────────────────────────────┐");
		System.out.println("│       [현재 잔돈 보유량]       │");
		System.out.println("└────────────────────────────────┘");

		System.out.printf(" ▶    500원 : %3d개 = %6d원\n", Change.change.get(500), 500 * Change.change.get(500));
		System.out.printf(" ▶   1000원 : %3d개 = %6d원\n", Change.change.get(1000), 1000 * Change.change.get(1000));
		System.out.printf(" ▶   5000원 : %3d개 = %6d원\n", Change.change.get(5000), 5000 * Change.change.get(5000));
		System.out.printf(" ▶  10000원 : %3d개 = %6d원\n", Change.change.get(10000), 10000 * Change.change.get(10000));
		System.out.println("──────────────────────────────────");
		System.out.printf(" ==> 총액은 %d원입니다.\n\n", Change.sum());

	}
}