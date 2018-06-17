package cn.jiande.util.yunzhijia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiande.util.MyX509TrustManager;
import cn.jiande.util.properties.PropertiesUtil;
import cn.jiande.util.yunzhijia.pojo.AccessToken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/** 
* @author mail: httpsession@qq.com
* @date 创建时间：2018年3月12日 上午8:48:17 
* @description 获取云之家开放平台的AccessToken的工具类
*/

/*
* app授权级别所需参数
* appId(轻应用id,参数类型:string,为必填参数)
* secret(轻应用secret,参数类型:string,为必填参数)
* timestamp(当前时间戳,参数类型:string,为必填参数)
* scope(授权级别,参数类型:string,为必填参数)
* =====================================
* team授权级别所需参数
* appId(轻应用id,参数类型:string,为必填参数)
* eid(团队id,参数类型:string,为必填参数)
* secret(轻应用secret,参数类型:string,为必填参数)
* timestamp(当前时间戳,参数类型:string,为必填参数)
* scope(授权级别,参数类型:string,为必填参数)
* =====================================
* resgroupSecret授权级别所需参数
* eid(团队id,参数类型:string,为必填参数)
* secret(资源授权秘钥secret,参数类型:string,为必填参数)
* timestamp(当前时间戳,参数类型:string,为必填参数)
* scope(授权级别,参数类型:string,为必填参数)
*/
public class TokenUtil {
	private static Logger log = LoggerFactory.getLogger(TokenUtil.class);

	// 读取云之家配置文件
	private static PropertiesUtil util = new PropertiesUtil("/config/yunzhijia.properties");
	private static String APPID = util.getProperty("appId");
	private static String SECRET = util.getProperty("secret");
	private static String SCOPE = util.getProperty("scope");
	private static String EID = util.getProperty("eid");
	/*
	 * 获取AccessToken的请求URL,不同的授权级别所携带的参数由差异
	 * token_url_app:授权级别为app时的请求URL与参数
	 * token_url_team:授权级别为team时的请求URL与参数
	 * token_url_resGroupSecret:授权级别为resGroupSecret时的请求URL与参数
	 */
	private final static String token_url_app = "https://www.yunzhijia.com/gateway/oauth2/token/getAccessToken?appId=APPID&secret=SECRET&timestamp=TIMESTAMP&scope=SCOPE";
	private final static String token_url_team = "https://www.yunzhijia.com/gateway/oauth2/token/getAccessToken?appId=APPID&eid=EID&secret=SECRET&timestamp=TIMESTAMP&scope=SCOPE";
	private final static String token_url_resGroupSecret = "https://www.yunzhijia.com/gateway/oauth2/token/getAccessToken?eid=EID&secret=SECRET&timestamp=TIMESTAMP&scope=SCOPE";
	/*
	 * 刷新AccessToken的请求URL,不同的授权级别所携带的参数由差异
	 * refresh_url_app:授权级别为app时的请求URL与参数
	 * refresh_url_team:授权级别为team时的请求URL与参数
	 * refresh_url_resGroupSecret:授权级别为resGroupSecret时的请求URL与参数
	 */
	private final static String refresh_url_app="https://www.yunzhijia.com/gateway/oauth2/token/refreshToken?appId=APPID&refreshToken=REFRESHTOKEN&timestamp=TIMESTAMP&scope=SCOPE";
	private final static String refresh_url_team="https://www.yunzhijia.com/gateway/oauth2/token/refreshToken?appId=APPID&eid=EID&&refreshToken=REFRESHTOKEN&timestamp=TIMESTAMP&scope=SCOPE";
	private final static String refresh_url_resGroupSecret="https://www.yunzhijia.com/gateway/oauth2/token/refreshToken?eid=EID&&refreshToken=REFRESHTOKEN&timestamp=TIMESTAMP&scope=SCOPE";
	/**
	 * 获取接口访问凭证通过默认的云之家配置
	 * "/config/yunzhijia.properties"
	 * @param appid 轻应用id
	 * @param appsecret 轻应用secret
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken getToken() {
		AccessToken token = null;
		String requestUrl= null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		System.out.println("SCOPE: "+SCOPE);
		if(SCOPE.equals("app")||SCOPE.equals("APP")){
			requestUrl = token_url_app.replace("APPID", APPID).replace("SECRET", SECRET).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE",SCOPE);
		}else if(SCOPE.equals("team")||SCOPE.equals("TEAM")){
			requestUrl = token_url_team.replace("APPID", APPID).replace("EID", EID).replace("SECRET", SECRET).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE", SCOPE);
		}else if(SCOPE.equals("resGroupSecret")||SCOPE.equals("RESGROUPSECRET")){
			requestUrl = token_url_resGroupSecret.replace("EID", EID).replace("SECRET", SECRET).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE",SCOPE);
		}
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);
		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	
	/**
	 * 使用app授权级别获取云之家开放平台AccessToken
	 * @param appId 轻应用id
	 * @param secret 轻应用secret
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken getTokenByApp(String appId,String secret){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = token_url_app.replace("APPID", appId).replace("SECRET", secret).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","app");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);
		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	/**
	 * 使用team授权级别获取云之家开放平台AccessToken
	 * @param appId 轻应用id 
	 * @param eid 团队id
	 * @param secret 轻应用secret
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken getTokenByTeam(String appId,String eid,String secret){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = token_url_team.replace("APPID", appId).replace("EID", eid).replace("SECRET", secret).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","team");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	
	/**
	 * 使用resGroupSecret授权级别获取云之家开放平台AccessToken
	 * @param eid 团队id
	 * @param secret 资源授权秘钥secret
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken getTokenByResGroupSecret(String eid,String secret){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = token_url_resGroupSecret.replace("EID", eid).replace("SECRET", secret).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","resGroupSecret");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	
	/**
	 * 使用app授权级别刷新AccessToken
	 * @param appId 轻应用id
	 * @param refreshToken token刷新令牌
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken refreshTokenByApp(String appId,String refreshToken){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = refresh_url_app.replace("APPID", appId).replace("REFRESHTOKEN", refreshToken).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","app");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	/**
	 * 使用team授权级别刷新AccessToken
	 * @param appId 轻应用id
	 * @param eid 团队id
	 * @param refreshToken token刷新令牌
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken refreshTokenByTeam(String appId,String eid,String refreshToken){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = refresh_url_team.replace("APPID", appId).replace("EID",eid).replace("REFRESHTOKEN", refreshToken).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","team");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	/**
	 * 使用resGroupSecret授权级别刷新AccessToken
	 * @param eid 团队id
	 * @param refreshToken token刷新令牌
	 * @return AccessToken 云之家开放平台AccessToken
	 */
	public static AccessToken refreshTokenByResGroupSecret(String eid,String refreshToken){
		AccessToken token = null;
		String TIMESTAMP=String.valueOf(new Date().getTime());
		String requestUrl = refresh_url_resGroupSecret.replace("EID",eid).replace("REFRESHTOKEN", refreshToken).replace("TIMESTAMP", TIMESTAMP).replace("SCOPE","resGroupSecret");
		// 发起POST请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "POST", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setErrorCode(new Integer(jsonObject.getInt("errorCode")));
				token.setSuccess((Boolean)jsonObject.get("success"));
				token.setError(jsonObject.get("success").toString());
				if(token.getSuccess()==false){//获取accessToken失败,抛出异常
					throw new JSONException();
				}
				token.setAccessToken(jsonObject.getJSONObject("data").getString("accessToken"));
				token.setExpiresIn(jsonObject.getJSONObject("data").getInt("expireIn"));
				token.setRefreshToken(jsonObject.getJSONObject("data").getString("refreshToken"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} success:{} error:{}", jsonObject.getInt("errorCode"),
						jsonObject.get("success"),jsonObject.get("error"));
			}
		}
		return token;
	}
	
	/**
	 * 发送https请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("连接超时：{}", ce);
		} catch (Exception e) {
			log.error("https请求异常：{}", e);
		}
		return jsonObject;
	}
}
