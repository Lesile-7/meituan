package cn.jiande.util.wechat.pojo.menu;

/** 
 *发送位置按钮
 *发送位置:location_select
* @author : MT
* @date 创建时间：2017年10月29日 下午2:50:55 
* @version 1.0 
*/
public class LocationButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	private String type = "location_select";

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param key
	 */
	public LocationButton(String key) {
		this.key = key;
	}
	public LocationButton() {
		// TODO Auto-generated constructor stub
	}

}
