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
		// 주석을 하나씩 처리해가며 실습
		////////////////////////////////////////////////////////////////////////////////////////////
		

		
//		RestHttpClientProductApp.addProductTest_Codehaus();	
//		RestHttpClientProductApp.updateProductTestget_Codehaus();	
//		RestHttpClientProductApp.updateProductTestpost_Codehaus();	
//		RestHttpClientProductApp.getProductTest_Codehaus();	
		RestHttpClientProductApp.listProductTest_Codehaus();	
		
		
		
	
	}
	
	

	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void getProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8090/product/json/getProduct/10020";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product);
	}
//================================================================//	
	

	
public static void addProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8090/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
//		//[ 방법 1 : String 사용]
//		String data =  "{\"productId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ 방법 2 : JSONObject 사용]
//		JSONObject json = new JSONObject();
//		json.put("productId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ 방법 3 : codehaus 사용]
		Product product01 =  new Product();

		product01.setProdName("통닭");
		product01.setPrice(200000);
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(product01);
		
		
		System.out.println(jsonValue);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		System.out.println("ejflkwjflke"+httpEntity01);
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product);
	}	

public static void updateProductTestget_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol 의 client 추상화 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url= 	"http://127.0.0.1:8090/product/json/updateProduct/10020";

	// HttpGet : Http Protocol 의 GET 방식 Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");
	
	// HttpResponse : Http Protocol 응답 Message 추상화
	HttpResponse httpResponse = httpClient.execute(httpGet);
	
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> 다른 방법으로 serverData 처리 
	//System.out.println("[ Server 에서 받은 Data 확인 ] ");
	//String serverData = br.readLine();
	//System.out.println(serverData);
	
	//==> API 확인 : Stream 객체를 직접 전달 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
	System.out.println(jsonobj);

	ObjectMapper objectMapper = new ObjectMapper();
	 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
	 System.out.println(product);
}

public static void updateProductTestpost_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol 의 client 추상화 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/product/json/updateProduct";
	HttpPost httpPost = new HttpPost(url);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content-Type", "application/json");
	
//	//[ 방법 1 : String 사용]
//	String data =  "{\"productId\":\"admin\",\"password\":\"1234\"}";
//	HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//	//[ 방법 2 : JSONObject 사용]
//	JSONObject json = new JSONObject();
//	json.put("productId", "admin");
//	json.put("password", "1234");
//	HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
	
	//[ 방법 3 : codehaus 사용]
	Product product01 =  new Product();
	product01.setProdNo(10020);
	product01.setPrice(300000);
	product01.setProdName("심석희");
	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value 로 변환
	String jsonValue = objectMapper01.writeValueAsString(product01);
	
	
	System.out.println(jsonValue);
	HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
	System.out.println("ejflkwjflke"+httpEntity01);
	httpPost.setEntity(httpEntity01);
	HttpResponse httpResponse = httpClient.execute(httpPost);
	
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> 다른 방법으로 serverData 처리 
	//System.out.println("[ Server 에서 받은 Data 확인 ] ");
	//String serverData = br.readLine();
	//System.out.println(serverData);
	
	//==> API 확인 : Stream 객체를 직접 전달 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
	System.out.println(jsonobj);

	ObjectMapper objectMapper = new ObjectMapper();
	 Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
	 System.out.println(product);
}	
public static void listProductTest_Codehaus() throws Exception{
	
	// HttpClient : Http Protocol 의 client 추상화 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url = "http://127.0.0.1:8090/product/json/listProduct";
	HttpPost httpPost = new HttpPost(url);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content-Type", "application/json");
	
//	//[ 방법 1 : String 사용]
//	String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//	HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//	//[ 방법 2 : JSONObject 사용]
//	JSONObject json = new JSONObject();
//	json.put("userId", "admin");
//	json.put("password", "1234");
//	HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
	
	//[ 방법 3 : codehaus 사용]
	Search search =  new Search();
	search.setCurrentPage(1);
	//search.setSearchCondition("0");
	//search.setSearchKeyword("10001");
	search.setOrderOption(0);
	
	ObjectMapper objectMapper01 = new ObjectMapper();
	//Object ==> JSON Value 로 변환
	String jsonValue = objectMapper01.writeValueAsString(search);
	
	
	System.out.println(jsonValue);
	HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
	System.out.println("ejflkwjflke"+httpEntity01);
	httpPost.setEntity(httpEntity01);
	HttpResponse httpResponse = httpClient.execute(httpPost);
	
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	//==> 다른 방법으로 serverData 처리 
	System.out.println("[ Server 에서 받은 Data 확인 ] ");
	String serverData = br.readLine();
	System.out.println(serverData);
	
	//==> API 확인 : Stream 객체를 직접 전달 
	JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
	System.out.println(jsonobj);
	JSONArray jsonarray = (JSONArray)(jsonobj.get("list"));
	
	
	for (Object object : jsonarray) {
		Product product = objectMapper01.readValue(object.toString(), Product.class);
		System.out.println(object.toString());
		System.out.println("앙기모찌" + product);
		System.out.println("dddddddddddd");
		
	}//1일2똥진호 작품
	

//	ObjectMapper objectMapper = new ObjectMapper();
//	 User user = objectMapper.readValue(jsonarray.toString(), User.class);
	
	 //System.out.println(jsonarray.toString());
}	



}