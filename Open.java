import java.io.IOException;

public class Open
{

	public static void openProcess() throws IOException
	{
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.println("��   Random Cafe ���� �غ� �����մϴ�!!   ��");
		System.out.println("����������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println(">> �����ڸ��� �α��� �� �ܵ��� �־��ּ���~!!!");
		System.out.println();

		InitialUI init = new InitialUI();
		
		do
		{
			init.menuDisp();
			init.menuSelect();
			if (init.sel != 4)
			{
				System.out.println("\n4���� ������ ������ ���� ���ּ���!\n");
				continue;
			}
			init.menuRun();
		}
		while (init.sel != 4);
	}

	public static void main(String[] args) throws IOException
	{
		openProcess();
	}
}