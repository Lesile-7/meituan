package cn.jiande.util.wechat.pojo.menu;

/** 
 * 点击发送图片按钮
 * type：media_id
* @author : MT
* @date 创建时间：2017年10月29日 下午2:54:31 
* @version 1.0 
*/
public class MediaButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String media_id;
	private String type = "media_id";

	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param media_id
	 */
	public MediaButton(String media_id) {
		this.media_id = media_id;
	}

	public MediaButton() {
		// TODO Auto-generated constructor stub
	}

}
