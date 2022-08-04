public class ChangeUI
{
	public static void change()    // 잔돈 보유량확인 메소드
	{
		System.out.println("\n현재 보유한 잔돈은");
		System.out.printf("500원   %d개 입니다.\n", Change.change.get(500));
		System.out.printf("1000원  %d개 입니다.\n", Change.change.get(1000));
		System.out.printf("5000원  %d개 입니다.\n", Change.change.get(5000));
		System.out.printf("10000원 %d개 입니다.\n", Change.change.get(10000));
		System.out.printf("총액은 %d입니다.\n\n", Change.sumCal());
	}
}