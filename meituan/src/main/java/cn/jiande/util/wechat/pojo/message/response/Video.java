package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: Video
* 描述: 视频model
* 开发人员： MT
* 创建时间：  2017年10月20日
* 发布版本：V1.0
 */
public class Video extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2517477807139841176L;
	// 媒体文件id
	private String MediaId;
	// 缩略图的媒体id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}