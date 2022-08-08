import java.util.HashMap;
import java.util.Vector;

public class AdminList // 관리자 id와 pw를 담을 구조생성
{	
	// key : id, value: pw
	// account라는 Hashtable 자료구조 생성
	public static HashMap<String, String> account = new HashMap<String, String>();
	private static final String[] ID = {"조", "최", "정", "반"};
	private static final String[] PW = {"1", "2", "3", "4"};	
	private static final Vector<String> id = new Vector<String>();
	private static final Vector<String> pw = new Vector<String>();
	
	static
	{
		// Vector 변수 초기화
		for (String strID : ID)
			id.add(strID);

		for (String strPW : PW)
			pw.add(strPW);

		for (int i = 0; i < id.size(); i++)
			account.put(id.elementAt(i), pw.elementAt(i));
	}
}