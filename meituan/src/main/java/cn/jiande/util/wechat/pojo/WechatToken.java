package cn.jiande.util.wechat.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import cn.jiande.util.BasePojo;

@Table(name = "wechat_token")
public class WechatToken extends BasePojo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "expires_in")
	private Integer expiresIn;

	@Column(name = "create_time")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return access_token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken == null ? null : accessToken.trim();
	}

	/**
	 * @return expires_in
	 */
	public Integer getExpiresIn() {
		return expiresIn;
	}

	/**
	 * @param expiresIn
	 */
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * @return create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}