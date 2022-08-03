import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AdminList	// 관리자 id와 pw를 담을 구조생성
{	
	// key : id, value: pw
	// account라는 Hashtable 자료구조 생성
	public static HashMap<String, String> account;
	//					 ------key
	//							  ------value
	
	private static final String[] tempID = {"조","최","정","반"};
	private static final String[] tempPW = {"1","2","3","4"};
	private static final Vector<String> id;							//{"조", "최", "정", "반"};
	private static final Vector<String> pw;							//{"1", "2", "3", "4"};
	
	static
	{
		//account 인스턴스 생성
		account = new HashMap<String, String>();
		id = new Vector<String>();
		pw = new Vector<String>();

		//Vector 변수 초기화
		for (String temp : tempID)
			id.add(temp);
		for (String temp : tempPW)
			pw.add(temp);
		for (int i=0; i<id.size(); i++)
		{
			AdminList.account.put(id.elementAt(i), pw.elementAt(i));
		}
	}
}