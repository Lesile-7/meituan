package cn.jiande.util.wechat.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.jiande.util.BasePojo;

@Table(name = "wechat_sns_user")
public class WechatSnsUser extends BasePojo implements Serializable {
	// 用户标识
	@Id
	@Column(name = "open_id")
	private String openId;
	// 用户昵称
	private String nickname;
	// 性别（1是男性，2是女性，0是未知）
	private Integer sex;
	// 国家
	private String country;
	// 省份
	private String province;
	// 城市
	private String city;
	// 用户头像链接
	@Column(name = "head_img_url")
	private String headImgUrl;

	// 用户特权信息
	@Transient
	private List<String> privilegeList;

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

	/**
	 * @return the privilegeList
	 */
	public List<String> getPrivilegeList() {
		return privilegeList;
	}

	/**
	 * @param privilegeList the privilegeList to set
	 */
	public void setPrivilegeList(List<String> privilegeList) {
		this.privilegeList = privilegeList;
	}

}