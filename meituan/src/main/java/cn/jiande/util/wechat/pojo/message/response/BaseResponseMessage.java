package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: BaseMessage 
* 描述: 消息基类（公众帐号 -> 普通用户） 
* 开发人员： MT 
* 创建时间：  2017年10月20日 
* 发布版本：V1.0  
 */
public class BaseResponseMessage extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7541533704475726290L;
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}