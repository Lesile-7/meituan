package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: Voice 
* 描述: 语音model
* 开发人员： MT 
* 创建时间：  2017年10月20日 
* 发布版本：V1.0 
 */
public class Voice extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4912513360756744848L;
	// 媒体文件id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}