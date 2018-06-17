package cn.jiande.util.wechat.pojo.menu;

/** 
 * 图片按钮
 * 系统拍照发图：pic_sysphoto
 * 拍照或者相册发图：pic_photo_or_album
 * 微信相册发图：pic_weixin
* @author : MT
* @date 创建时间：2017年10月29日 下午2:48:24 
* @version 1.0 
*/
public class PicButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String type;
	private Button[] sub_button;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * @return the sub_button
	 */
	public Button[] getSub_button() {
		return sub_button;
	}

	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param key
	 * @param type
	 * @param sub_button
	 */
	public PicButton(String key, String type, Button[] sub_button) {
		this.key = key;
		this.type = type;
		this.sub_button = sub_button;
	}

	/**
	 * @param key
	 * @param type
	 */
	public PicButton(String key, String type) {
		this.key = key;
		this.type = type;
	}
	public PicButton() {
		// TODO Auto-generated constructor stub
	}
}
