package cn.jiande.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
* 类名: MyX509TrustManager 
* 描述: 信任管理器
* 这个证书管理器的作用就是让它信任我们指定的证书，
* 下面的代码意味着信任所有证书，不管是否权威机构颁发。
* 开发人员： MT
* 创建时间：  2017年10月21日
* 发布版本：V1.0
 */
public class MyX509TrustManager implements X509TrustManager {

	// 检查客户端证书
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// 检查服务器端证书
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// 返回受信任的X509证书数组
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
