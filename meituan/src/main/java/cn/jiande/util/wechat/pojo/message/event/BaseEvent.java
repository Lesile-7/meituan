package cn.jiande.util.wechat.pojo.message.event;

import cn.jiande.util.BasePojo;

/**
* 类名: BaseEvent 
* 描述: 事件基类
* 开发人员： MT
* 创建时间：  2017年10月20日 
* 发布版本：V1.0  
 */
public class BaseEvent extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079492293728786282L;
	// 开发者微信号
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型
	private String MsgType;
	// 事件类型
	private String Event;

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

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
}