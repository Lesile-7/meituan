package cn.jiande.util.wechat.pojo.message.response;

/**
* 类名: VideoMessage
* 描述: 视频消息
* 开发人员： MT
* 创建时间：  2017年10月20日
* 发布版本：V1.0
 */
public class VideoResponseMessage extends BaseResponseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3792170576844904410L;
	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}