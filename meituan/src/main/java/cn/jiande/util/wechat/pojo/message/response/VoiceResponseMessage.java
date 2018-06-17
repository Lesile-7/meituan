package cn.jiande.util.wechat.pojo.message.response;

/**
* 类名: VoiceMessage
* 描述: 语音消息
* 开发人员： MT
* 创建时间： 2017年10月20日
* 发布版本：V1.0 
 */
public class VoiceResponseMessage extends BaseResponseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7784883208271658721L;
	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
