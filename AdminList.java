import java.util.HashMap;
import java.util.Map;

public class AdminList	// ������ id�� pw�� ���� ��������
{	
	// key : id, value: pw
	// account��� Hashtable �ڷᱸ�� ����
	public static HashMap<String, String> account;
	//					 ------key
	//							  ------value
	
	static
	{
		//account �ν��Ͻ� ����
		account = new HashMap<String, String>();
	}
}