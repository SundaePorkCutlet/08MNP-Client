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
import com.model2.mvc.service.domain.Search;



public class RestHttpClientProductApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
		////////////////////////////////////////////////////////////////////////////////////////////
		

		
//		RestHttpClientProductApp.addProductTest_Codehaus();	
//		RestHttpClientProductApp.updateProductTestget_Codehaus();	
//		RestHttpClientProductApp.updateProductTestpost_Codehaus();	
//		RestHttpClientProductApp.getProductTest_Codehaus();	
		RestHttpClientProductApp.listProductTest_Codehaus();	
		
		
		
	
	}
	
	

	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8090/product/json/getProduct/10020";

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
		 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product);
	}
//================================================================//	
	

	
public static void addProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8090/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
//		//[ ��� 1 : String ���]
//		String data =  "{\"productId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("productId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ ��� 3 : codehaus ���]
		Product product01 =  new Product();

		product01.setProdName("���");
		product01.setPrice(200000);
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(product01);
		
		
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
		 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product);
	}	

public static void updateProductTestget_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url= 	"http://127.0.0.1:8090/product/json/updateProduct/10020";

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
	 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
	 System.out.println(product);
}

public static void updateProductTestpost_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/product/json/updateProduct";
	HttpPost httpPost = new HttpPost(url);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content-Type", "application/json");
	
//	//[ ��� 1 : String ���]
//	String data =  "{\"productId\":\"admin\",\"password\":\"1234\"}";
//	HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//	//[ ��� 2 : JSONObject ���]
//	JSONObject json = new JSONObject();
//	json.put("productId", "admin");
//	json.put("password", "1234");
//	HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
	
	//[ ��� 3 : codehaus ���]
	Product product01 =  new Product();
	product01.setProdNo(10020);
	product01.setPrice(300000);
	product01.setProdName("�ɼ���");
	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value �� ��ȯ
	String jsonValue = objectMapper01.writeValueAsString(product01);
	
	
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
	 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
	 System.out.println(product);
}	
public static void listProductTest_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/product/json/listProduct";
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
	
	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value �� ��ȯ
	String jsonValue = objectMapper01.writeValueAsString(search);
	
	
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
	System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	String serverData = br.readLine();
	System.out.println(serverData);
	
	//==> API Ȯ�� : Stream ��ü�� ���� ���� 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
	System.out.println(jsonobj);
	JSONArray jsonarray = (JSONArray)(jsonobj.get("list"));
	
	
	for (Object object : jsonarray) {
		Product product = objectMapper01.readValue(object.toString(), Product.class);
		System.out.println(object.toString());
		System.out.println("�ӱ����" + product);
		System.out.println("dddddddddddd");
		
	}//1��2����ȣ ��ǰ
	

//	ObjectMapper objectMapper = new ObjectMapper();
//	 User user = objectMapper.readValue(jsonarray.toString(), User.class);
	
	 //System.out.println(jsonarray.toString());
}	



}