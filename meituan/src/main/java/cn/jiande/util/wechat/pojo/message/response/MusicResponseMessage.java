package cn.jiande.util.wechat.pojo.message.response;

/**
* 类名: MusicMessage
* 描述: 音乐消息 
* 开发人员： MT
* 创建时间： 2017年10月20日
* 发布版本：V1.0
 */
public class MusicResponseMessage extends BaseResponseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7886683452786931371L;
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}