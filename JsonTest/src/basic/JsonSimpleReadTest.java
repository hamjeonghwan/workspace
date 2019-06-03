package basic;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleReadTest {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader("D:\\myJsonFile.txt");
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(fr);
		JSONObject jsonfile = (JSONObject)obj;
		
		String name = (String)jsonfile.get("name");
		String job = (String)jsonfile.get("job");
		String age = (String)jsonfile.get("age");
		String addr = (String)jsonfile.get("addr");
		
		JSONArray list = (JSONArray)jsonfile.get("singerList");
		
		System.out.println("name : "+name);
		System.out.println("job: "+job);
		System.out.println("age: "+age);
		System.out.println("addr: "+addr);
		
		@SuppressWarnings("unchecked")
		Iterator<String> it = list.iterator();
		System.out.println("--------- ");
		System.out.println("가수 목록");
		System.out.println("========= ");
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
