import java.io.*;

public class initialUI
{
	
	public static final int takeOut = 1;
	public static final int forHere = 2;
	public static final int stampUse = 3;
	public static final int adminLogin = 4;
	public static int sel = 1;
	
	//�޴�ǥ�� �޼���
	public static void menuDisp()
	{
		System.out.println("1. �����̿�");
		System.out.println("2. ����");
		System.out.println("3. ���� ���");
		System.out.println("4. �����ڸ��");
	}
	
	//�޴� ���� �޼���
	public static void menuSelect() throws IOException, NumberFormatException
	{
		//�޴� ���� �Է¹ޱ� ���� BufferedReader �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �޴�����
		do
		{
			System.out.print(">> ����(1~4) : ");
			sel = Integer.parseInt(br.readLine());
			
			//1~4�� �̿��� ��ȣ �Է½� �ٽ� �Է��ش޶�� �޼��� ���
			if (sel >= 1 && sel <= 4)
				break;
			else
				System.out.println("�ٽ� �Է����ּ���.");
		}
		while (true);


	}
	
	// �޴� ���� �� ���� �޼���
	public static void menuRun()
	{
		switch (sel)
		{
			case 1:
			case 2: drink(); break;
			case 3: stamp(); break;
			case 4: adminUI(); break;
		}
	}
	
	// ���� �ֹ� �޼���
	public static void drink()
	{
		System.out.println("����޴� ȭ��");
	}
	
	// ���� ��� �޼���
	public static void stamp()
	{
		System.out.println("���� ��� ����޴� ȭ��");
	}
	
	// ������ ��� ���� �޼���
	public static void adminUI()
	{
		System.out.println("������ ȭ��");
	}


	public static void main(String[] args) throws IOException, NumberFormatException
	{
		
		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while (true);
	}
}
