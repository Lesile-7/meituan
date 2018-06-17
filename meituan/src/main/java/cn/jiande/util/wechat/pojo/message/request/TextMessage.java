package cn.jiande.util.wechat.pojo.message.request;

/**
* 类名: TextMessage </br>
* 描述: 请求消息之文本消息 </br>
* 开发人员： MT </br>
* 创建时间：  2017年10月20日 </br>
* 发布版本：V1.0  </br>
 */

public class TextMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2179970272612260812L;
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}