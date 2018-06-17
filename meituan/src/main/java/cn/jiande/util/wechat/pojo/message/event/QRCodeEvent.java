package cn.jiande.util.wechat.pojo.message.event;

/**
* 类名: QRCodeEvent 
* 描述: 扫描带参数二维码事件 
* 开发人员： MT 
* 创建时间：  2017年10月20日
* 发布版本：V1.0  </br>
 */
public class QRCodeEvent extends BaseEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5180691289217589252L;
	// 事件KEY值
	private String EventKey;
	// 用于换取二维码图片
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}