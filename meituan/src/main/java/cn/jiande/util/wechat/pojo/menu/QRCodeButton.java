package cn.jiande.util.wechat.pojo.menu;

/** 
 * 
 * 扫码事件按钮 
 * 扫码带提示：scancode_waitmsg
 * 扫码推事件：scancode_push
* @author : MT
* @date 创建时间：2017年10月29日 下午2:39:06 
* @version 1.0 
*/
public class QRCodeButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	private String key;
	private Button[] sub_button;

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
	 * @param type
	 * @param key
	 * @param sub_button
	 */
	public QRCodeButton(String type, String key, Button[] sub_button) {
		this.type = type;
		this.key = key;
		this.sub_button = sub_button;
	}

	/**
	 * @param type 可选扫码带提示 或者扫码推事件
	 * @param key
	 */
	public QRCodeButton(String type, String key) {
		this.type = type;
		this.key = key;
	}
	public QRCodeButton() {
		// TODO Auto-generated constructor stub
	}
}
