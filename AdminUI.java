
import java.io.*;

public class AdminUI
{	
	
	static int sel;
	static BufferedReader br ;
	
	static  //�ʱ�ȭ
	{
		br = new BufferedReader(new InputStreamReader(System.in));    
		sel = 1;
	}
	public static void menuDisp()                                                  //�޴� ��� �޼ҵ�
	{
		System.out.println();
		System.out.println("1.����� ����");
		System.out.println("2.�޴��� �Ǹź���");
		System.out.println("3.�ܵ� ������");
		System.out.println("4.�ܵ� �߰�");
		System.out.println("5.����");
		System.out.println("====================");
		System.out.print(">>�޴� ���� (1~5) : ");
	}
	public static void menuSelect() throws IOException , NumberFormatException     //�޴����� �޼ҵ�
	{
		do
		{
			sel = Integer.parseInt(br.readLine());
			if(sel < 1 || sel > 5)
			{
				System.out.println();
				System.out.println("�Է°��� ������ϴ�.");
				menuDisp();       //�Է°� ������� �޴� �ٽ����
			}
		}
		while (sel < 1 || sel > 5);
	}
	public static void menuRun()												   //������ �޴����࿡ ���� ���ȣ�� �޼ҵ�
	{
		switch(sel)
		{
			case 1: sales(); break;
			case 2: salesRatio(); break;
			case 3: changes(); break;
			case 4: addChanges(); break;
			case 5: exit(); break;
		}
	}

	
	public static void sales()  //����� ���� �޼ҵ�
	{
		System.out.println("sales");
		
	}
	public static void salesRatio()  //�޴��� �Ǹ� ���� �޼ҵ�
	{ 
		System.out.println("salesRatio");
	}
	public static void changes()    //�ܵ� ������Ȯ�� �޼ҵ�
	{
		System.out.println("changes");
	}
	public static void addChanges()   //�ܵ� �߰� �޼ҵ�
	{
		System.out.println("addchanges");
	}
	public static void exit()     //���α׷����� �޼ҵ�
	{
		System.out.println("���α׷� ����!!!");
		System.exit(0);
	}



	public static void main(String[] args) throws IOException , NumberFormatException
	{
		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while(true);
		
	}

}