package cn.jiande.util.wechat.pojo;

import java.io.Serializable;
import javax.persistence.*;
import cn.jiande.util.BasePojo;

@Table(name = "wechat_user")
public class WechatUser extends BasePojo implements Serializable {
	// 用户的标识
	@Id
	@Column(name = "open_id")
	private String openId;
	// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
	private Integer subscribe;
	// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	@Column(name = "subscribe_time")
	private String subscribeTime;
	// 昵称
	private String nickname;
	// 用户的性别（1是男性，2是女性，0是未知）
	private Integer sex;
	// 用户所在国家
	private String country;
	// 用户所在省份
	private String province;
	// 用户所在城市
	private String city;
	// 用户的语言，简体中文为zh_CN
	private String language;
	// 用户头像
	@Column(name = "head_img_url")
	private String headImgUrl;

	private static final long serialVersionUID = 1L;

	/**
	 * @return open_id
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	/**
	 * @return subscribe
	 */
	public Integer getSubscribe() {
		return subscribe;
	}

	/**
	 * @param subscribe
	 */
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	/**
	 * @return subscribe_time
	 */
	public String getSubscribeTime() {
		return subscribeTime;
	}

	/**
	 * @param subscribeTime
	 */
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime == null ? null : subscribeTime.trim();
	}

	/**
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	/**
	 * @return sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	/**
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language == null ? null : language.trim();
	}

	/**
	 * @return head_img_url
	 */
	public String getHeadImgUrl() {
		return headImgUrl;
	}

	/**
	 * @param headImgUrl
	 */
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
	}
}