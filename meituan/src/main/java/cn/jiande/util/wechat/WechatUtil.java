package cn.jiande.util.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiande.util.MyX509TrustManager;
import cn.jiande.util.properties.PropertiesUtil;
import cn.jiande.util.wechat.pojo.WechatOauth2Token;
import cn.jiande.util.wechat.pojo.WechatSnsUser;
import cn.jiande.util.wechat.pojo.WechatToken;
import cn.jiande.util.wechat.pojo.WechatUser;
import cn.jiande.util.wechat.pojo.menu.Menu;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/** 
 * 公众平台通用接口工具类 
* @author : MT
* @date 创建时间：2017年10月27日 下午4:04:19 
* @version 1.0 
*/
public class WechatUtil {

	private static Logger log = LoggerFactory.getLogger(WechatUtil.class);
	private static String AppID;
	private static String AppSecret;
	static {
		PropertiesUtil util = new PropertiesUtil("/config/wechat.properties");
		AppID = util.getProperty("AppID");
		AppSecret = util.getProperty("AppSecret");
		log.info(new Date() + " AppID: " + AppID + " AppSecret: " + AppSecret + " has bean init! ");
	}

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static WechatToken getAccessToken(String appid, String appsecret) {
		WechatToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new WechatToken();
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static WechatToken getAccessToken() {
		WechatToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", AppID).replace("APPSECRET", AppSecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new WechatToken();
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 描述:  发起https请求并获取结果
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	* URL编码（utf-8）
	* 
	* @param source
	* @return
	*/
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType 内容类型
	 * @return
	 */
	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType))
			fileExt = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileExt = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileExt = ".amr";
		else if ("video/mp4".equals(contentType))
			fileExt = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileExt = ".mp4";
		return fileExt;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken 接口访问凭证
	 * @param openId 用户标识
	 * @return weChatUserInfo
	 * @description
	 * 该方法只能用于用户管理类接口中的“获取用户基本信息接口”，是在用户和公众号产生消息交互或关注后事件推送后，
	 * 才能根据用户OpenID来获取用户基本信息。用户管理类接口的其他微信接口，都是需要该用户（即openid）关注了
	 * 公众号后，才能调用成功的
	 *
	 */
	public static WechatUser getUserInfo(String accessToken, String openId) {
		WechatUser weChatUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				weChatUserInfo = new WechatUser();
				// 用户的标识
				weChatUserInfo.setOpenId(jsonObject.getString("openid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weChatUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				weChatUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				weChatUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				weChatUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				weChatUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				weChatUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				weChatUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				weChatUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				weChatUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == weChatUserInfo.getSubscribe()) {
					log.error("用户{}已取消关注", weChatUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
				}
			}
		}
		return weChatUserInfo;
	}

	/**
	 * 
	 * 获取网页授权凭证
	 * @param code
	 * @return WechatOauth2Token
	 * 
	 */
	public static WechatOauth2Token getOauth2AccessToken(String code) {
		WechatOauth2Token wechatOauth2Token = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

		requestUrl = requestUrl.replace("APPID", AppID);
		requestUrl = requestUrl.replace("SECRET", AppSecret);
		requestUrl = requestUrl.replace("CODE", code);

		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				wechatOauth2Token = new WechatOauth2Token();
				wechatOauth2Token.setAccessToken(jsonObject.getString("access_token"));
				wechatOauth2Token.setExpiresIn(jsonObject.getInt("expires_in"));
				wechatOauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
				wechatOauth2Token.setOpenId(jsonObject.getString("openid"));
				wechatOauth2Token.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wechatOauth2Token = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}

		return wechatOauth2Token;
	}

	/**
	 * 通过网页授权获取用户信息
	 * @param accessToken 网页授权接口调用凭证
	 * @param openId 用户标识
	 * @return
	 * @description
	 * 该方法是用于用户在微信客户端中访问第三方网页，公众号可以
	 * 通过微信网页授权机制，来获取用户基本信息，进而实现业务逻辑
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static WechatSnsUser getSNSUserInfo(String accessToken, String openId) {
		WechatSnsUser snsUserInfo = null;

		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new WechatSnsUser();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				// 昵称
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// 性别（1是男性，2是女性，0是未知）
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				snsUserInfo.setCity(jsonObject.getString("city"));
				// 用户头像
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// 用户特权信息
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;
	}

	/**
	 * @return the appID
	 */
	public static String getAppID() {
		return AppID;
	}

	/**
	 * @param appID the appID to set
	 */
	public static void setAppID(String appID) {
		AppID = appID;
	}

	/**
	 * @return the appSecret
	 */
	public static String getAppSecret() {
		return AppSecret;
	}

	/**
	 * @param appSecret the appSecret to set
	 */
	public static void setAppSecret(String appSecret) {
		AppSecret = appSecret;
	}
}
