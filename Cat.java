public class Cat
{
	// 오픈시 힘낼 수 있게 해주는 고양이 메소드
	public static void open()
	{
		System.out.println();
		System.out.println("           A____A     A____A     A____A                ");
		System.out.println("          |·ㅅ·|   |·ㅅ·|   |·ㅅ·|               ");
		System.out.println("          |      |   |　　  |   |      |               ");
		System.out.println("          | u　u |   | b　d |   | u　u |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("           U￣￣U     U￣￣U     U￣￣U                ");
		System.out.println();
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│  <---------- Random Cafe 오픈합니다!! ---------->  │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.out.println();
	}
	
	// 마감시 아쉬워하는 고양이 메소드
	public static void close()
	{
		System.out.println();
		System.out.println("           A____A     A____A     A____A                ");
		System.out.println("          | · ·|   | · ·|   | · ·|               ");
		System.out.println("          |  ^   |   |  ^   |   |  ^   |               ");
		System.out.println("          | u　u |   | u　u |   | u　u |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("          |      |   |      |   |      |               ");
		System.out.println("           U￣￣U     U￣￣U     U￣￣U                ");
		System.out.println();
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│  <---------- Random Cafe 마감합니다!! ---------->  │");
		System.out.println("└────────────────────────────────────────────────────┘");
		// 마감시 고양이를 출력해주고 동시에 프로그램 전체 종료
		System.exit(0);
	}	
}