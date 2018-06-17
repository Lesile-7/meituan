package cn.jiande.util.wechat.pojo.menu;

/** 
 * 视图跳转菜单
 * type：view
* @author : MT
* @date 创建时间：2017年10月29日 下午2:37:37 
* @version 1.0 
*/
public class ViewButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;
	private String type = "view";

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @param url
	 */
	public ViewButton(String url) {
		this.url = url;
	}

	/**要跳转的地址的Url
	 * @param url
	 */
	public ViewButton(String url, String name) {
		this.url = url;
		this.setName(name);
	}

	public ViewButton() {
		// TODO Auto-generated constructor stub
	}

}
