package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.Search;
import com.model2.mvc.service.domain.User;



public class RestHttpClientPurchaseApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
		////////////////////////////////////////////////////////////////////////////////////////////
		

		
//		RestHttpClientPurchaseApp.addPurchaseTest_Codehaus();	
//		RestHttpClientPurchaseApp.updatePurchaseTestget_Codehaus();	
//		RestHttpClientPurchaseApp.updatePurchaseTestpost_Codehaus();	
//		RestHttpClientPurchaseApp.getPurchaseTest_Codehaus();	
		RestHttpClientPurchaseApp.listPurchaseTest_Codehaus();	
		
		
		
	
	}
	
	

	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getPurchaseTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8090/purchase/json/getPurchase/10020";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		 System.out.println(purchase);
	}
//================================================================//	
	

	
public static void addPurchaseTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8090/purchase/json/addPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
//		//[ ��� 1 : String ���]
//		String data =  "{\"purchaseId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("purchaseId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ ��� 3 : codehaus ���]
		
		User user01 = new User();
		user01.setUserId("user01");
		user01.setPassword("0000");
		user01.setUserName("õ����");
		
		Product product01 = new Product();
		product01.setProdNo(10005);
		product01.setProdName("����");
		product01.setPrice(3333);
		
		Purchase purchase01 =  new Purchase();

		purchase01.setPurchaseProd(product01);
		purchase01.setBuyer(user01);
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(purchase01);
		
		
		System.out.println(jsonValue);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		System.out.println("ejflkwjflke"+httpEntity01);
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		System.out.println("brbrb"+br);
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
		JSONArray jsonarray = (JSONArray)(jsonobj.get("list"));
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		 Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
//		 System.out.println(purchase);
		 
		 for (Object object : jsonarray) {
			System.out.println(jsonarray);
				
			}//1��2����ȣ ��ǰ
	}	

public static void updatePurchaseTestget_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url= 	"http://127.0.0.1:8090/purchase/json/updatePurchase/10001";

	// HttpGet : Http Protocol �� GET ��� Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");
	
	// HttpResponse : Http Protocol ���� Message �߻�ȭ
	HttpResponse httpResponse = httpClient.execute(httpGet);
	
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> �ٸ� ������� serverData ó�� 
	//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	//String serverData = br.readLine();
	//System.out.println(serverData);
	
	//==> API Ȯ�� : Stream ��ü�� ���� ���� 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
	System.out.println(jsonobj);

	ObjectMapper objectMapper = new ObjectMapper();
	 Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
	 System.out.println(purchase);
}

public static void updatePurchaseTestpost_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/purchase/json/updatePurchase";
	HttpPost httpPost = new HttpPost(url);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content-Type", "application/json");
	
//	//[ ��� 1 : String ���]
//	String data =  "{\"purchaseId\":\"admin\",\"password\":\"1234\"}";
//	HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//	//[ ��� 2 : JSONObject ���]
//	JSONObject json = new JSONObject();
//	json.put("purchaseId", "admin");
//	json.put("password", "1234");
//	HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
	
	//[ ��� 3 : codehaus ���]
	
	User user01 = new User();
	user01.setUserId("user01");
	user01.setPassword("1111");
	user01.setUserName("�ռ���");
	
	Product product01 = new Product();
	product01.setProdName("����");
	product01.setPrice(3333222);
	
	
	Purchase purchase01 =  new Purchase();
	purchase01.setPurchaseProd(product01);
	purchase01.setBuyer(user01);
	purchase01.setTranNo(10001);
	purchase01.setReceiverName("�輮��");

	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value �� ��ȯ
	String jsonValue = objectMapper01.writeValueAsString(purchase01);
	
	
	System.out.println(jsonValue);
	HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
	System.out.println("ejflkwjflke"+httpEntity01);
	httpPost.setEntity(httpEntity01);
	HttpResponse httpResponse = httpClient.execute(httpPost);
	
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> �ٸ� ������� serverData ó�� 
	//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	//String serverData = br.readLine();
	//System.out.println(serverData);
	
	//==> API Ȯ�� : Stream ��ü�� ���� ���� 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
	System.out.println(jsonobj);

	ObjectMapper objectMapper = new ObjectMapper();
	 Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
	 System.out.println(purchase);
}	
public static void listPurchaseTest_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/purchase/json/listPurchase";
	HttpPost httpPost = new HttpPost(url);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content-Type", "application/json");
	
//	//[ ��� 1 : String ���]
//	String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//	HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//	//[ ��� 2 : JSONObject ���]
//	JSONObject json = new JSONObject();
//	json.put("userId", "admin");
//	json.put("password", "1234");
//	HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
	
	//[ ��� 3 : codehaus ���]
	Search search =  new Search();
	search.setCurrentPage(1);
	//search.setSearchCondition("0");
	//search.setSearchKeyword("10001");
	search.setOrderOption(0);
	
	User user = new User();
	user.setUserId("user01");
	
	Purchase purchase = new Purchase();
	purchase.setBuyer(user);
	
	
	
	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value �� ��ȯ


	
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("search", search);
	jsonObject.put("purchase", purchase);
	String strr = objectMapper01.writeValueAsString(jsonObject);
	System.out.println(strr);


	HttpEntity entity = new StringEntity(strr,"UTF-8");
	httpPost.setEntity(entity);
	HttpResponse httpResponse = httpClient.execute(httpPost);
	
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> �ٸ� ������� serverData ó�� 
	System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	String serverData = br.readLine();
	System.out.println(serverData);
	
	//==> API Ȯ�� : Stream ��ü�� ���� ���� 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
	System.out.println(jsonobj);
	JSONArray jsonarray = (JSONArray)(jsonobj.get("list"));
	
	
	for (Object object : jsonarray) {
		Purchase purchase01 = objectMapper01.readValue(object.toString(), Purchase.class);
		System.out.println(object.toString());
		System.out.println("�ӱ����" + purchase01);
		System.out.println("dddddddddddd");
		
	}//1��2����ȣ ��ǰ
	

//	ObjectMapper objectMapper = new ObjectMapper();
//	 User user = objectMapper.readValue(jsonarray.toString(), User.class);
	
	 //System.out.println(jsonarray.toString());
}	



}