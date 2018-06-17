package cn.jiande.util.yunzhijia.pojo;

import java.io.Serializable;

import cn.jiande.util.BasePojo;

/** 
* @author mail: httpsession@qq.com
* @date 创建时间：2018年3月12日 上午9:45:22 
* @description 封装向云之家开放平台获取AccessToken返回的数据
*/
public class AccessToken extends BasePojo implements Serializable {
	private static final long serialVersionUID = 3794176262851359582L;
	/*
	 * 云之家开放平台accessToken
	 */
	private String accessToken;
	/*
	 * 有效时间(秒)
	 */
	private Integer expiresIn;
	/*
	 * token刷新令牌
	 */
	private String refreshToken;
	/**
	 * 错误码
	 */
	private Integer errorCode;
	/**
	 * 错误信息
	 */
	private String error;
	/**
	 * 是否获取成功
	 */
	private Boolean success;
	public AccessToken(String accessToken, Integer expiresIn, String refreshToken, Integer errorCode, String error,
			Boolean success) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
		this.errorCode = errorCode;
		this.error = error;
		this.success = success;
	}
	public AccessToken() {
		super();
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshToken=" + refreshToken
				+ ", errorCode=" + errorCode + ", error=" + error + ", success=" + success + "]";
	}
	
}
