package cn.jiande.util.wechat.pojo.menu;

/** 
 * 点击发送图文消息按钮
* @author : MT
* @date 创建时间：2017年10月29日 下午2:56:08 
* @version 1.0 
*/
public class ViewLimitedButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type = "view_limited";
	private String media_id;

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 推送图文消息在微信素材库中的ID
	 * @param media_id
	 */
	public ViewLimitedButton(String media_id) {
		this.media_id = media_id;
	}
	public ViewLimitedButton() {
		// TODO Auto-generated constructor stub
	}

}
