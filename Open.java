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

		init.menuDisp();
		init.menuSelect();
		init.menuRun();
	}

	public static void main(String[] args) throws IOException
	{
		openProcess();
	}
}