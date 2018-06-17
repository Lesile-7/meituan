package cn.jiande.util.wechat.pojo.message.response;

/**
* 类名: ContentMessage 
* 描述: 文本消息 
* 开发人员： MT
* 创建时间：  2017年10月20日 
* 发布版本：V1.0  
 */
public class TextResponseMessage extends BaseResponseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6775154064816272654L;
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}