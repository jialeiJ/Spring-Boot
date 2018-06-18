package spring.boot.okhttp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Company:  Jaray.com
 *  Author:  JiaLei
 *    Date:  2018年5月18日
 */
public class OKHttp {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	private final OkHttpClient okHttpClient = new OkHttpClient();

	public static void main(String[] args) throws IOException {
		new OKHttp().SendGetOfAsynchronized();
		new OKHttp().SendGetOfSynchronized();
	}
	
	/**
	 * TODO:  使用OKHttp实现Get同步请求
	 * @throws IOException
	 */
	public void SendGetOfSynchronized() throws IOException {
		/*封装请求参数*/
        FormBody body = new FormBody.Builder()
                .add("name","张三")
                .build();
		
		Request request = new Request.Builder().url("http://localhost:8080/http").put(body).build();
		//Request request = new Request.Builder().url("http://localhost:8080/http").post(body).build();
		//Request request = new Request.Builder().url("http://www.baidu.com").build();
		Response response = okHttpClient.newCall(request).execute();
		if(response.isSuccessful()) {
			System.out.println("请求成功！" + response.body().string());
		}else {
			throw new IOException("Unexpeected code " + response);
		}
		Headers headers = response.headers();
		for (int i = 0; i < headers.size(); i++) {
			System.out.println(headers.name(i) + ": " + headers.value(i));
		}
		for (int i = 0; i < 30; i++) {
			System.out.println(new SimpleDateFormat("yyyyMMdd-hh:mm:ss").format(new Date(System.currentTimeMillis())) + " ---同步--- " +i);
		}
	}
	
	/**
	 * TODO:  使用OKHttp实现Get异步请求
	 * @throws IOException
	 */
	public void SendGetOfAsynchronized() throws IOException {
		/*封装请求参数*/
        FormBody body = new FormBody.Builder()
                .add("name","李四")
                .build();
		
		Request request = new Request.Builder().url("http://localhost:8080/http").put(body).build();
		//Request request = new Request.Builder().url("http://localhost:8080/http").post(body).build();
		//Request request = new Request.Builder().url("http://www.baidu.com").build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Headers headers = response.headers();
				System.out.println(response.body().string());
				//System.out.println("请求成功！" + response.body().string());
				for (int i = 0; i < headers.size(); i++) {
					System.out.println(headers.name(i) + ": " + headers.value(i));
				}
				
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println("Fail");
				try {
					throw new IOException("Unexpeected code " + e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		for (int i = 0; i < 30; i++) {
			System.out.println(new SimpleDateFormat("yyyyMMdd-hh:mm:ss").format(new Date(System.currentTimeMillis())) + " ---异步--- " +i);
		}
	}

}
