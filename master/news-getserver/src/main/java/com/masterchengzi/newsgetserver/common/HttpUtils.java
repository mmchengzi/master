package com.masterchengzi.newsgetserver.common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.PrintWriter;
import java.net.URLConnection;

public class HttpUtils {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return  sb.toString();
	}

	public static JSONObject postRequestFromUrl(String url, String body) throws IOException, JSONException {
		URL realUrl = new URL(url);
		URLConnection conn = realUrl.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		out.print(body);
		out.flush();

		InputStream instream = conn.getInputStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			instream.close();
		}
	}

	public static JSONObject getRequestFromUrl(String url) throws IOException, JSONException {
		URL realUrl = new URL(url);
		URLConnection conn = realUrl.openConnection();
		InputStream instream = conn.getInputStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			instream.close();
		}
	}
	public static void main(String[] args) throws IOException, JSONException {

		// 请求示例 url 默认请求参数已经做URL编码
		//String url = "http://api01.idataapi.cn:8000/news/qihoo?apikey=vZuaffbf38RMVPr2c5JHrmrcutFGpVA9Px2Najsa1xunUG7Cx0KV2sfD3hLExibg&kw=%E7%99%BD&site=163.com";
		String url ="http://v.juhe.cn/toutiao/index?key=d60c052187e8adf3e2de5782409d8049&type=top";
		//String url="http://mobile.ximalaya.com/v1/track/baseInfo?device=android&trackId=24069144";
				JSONObject json = getRequestFromUrl(url);
		System.out.println(json.toString());
	}
}
