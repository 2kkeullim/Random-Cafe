import java.util.HashMap;
import java.util.Map;

public class AdminData
{
	private static final String[] id = {"��", "��", "��", "��"};
	private static final String[] pw = {"1", "2", "3", "4"};

	public static void main(String[] args)
	{
		// �迭(id, pw)�� ����ִ� �����͸� ��ҷ� ��Ƴ���
		for (int i=0; i<id.length; i++)
		{
			AdminList.account.put(id[i], pw[i]);
		}
		// �迭�� �ִ� ������ ���
		for (int j=0; j<id.length; j++)
		{
			System.out.println(id[j] + "," + AdminList.account.get(id[j]));
		}
	}
}