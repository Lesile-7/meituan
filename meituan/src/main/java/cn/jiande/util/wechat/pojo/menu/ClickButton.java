package cn.jiande.util.wechat.pojo.menu;

/** 
 * 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。
 * 点击菜单type：click
* @author : MT
* @date 创建时间：2017年10月27日 下午3:51:00 
* @version 1.0 
*/
public class ClickButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = -903098727876190001L;
	private String type = "click";
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param key
	 */
	public ClickButton(String key) {
		this.key = key;
	}

	public ClickButton() {
		// TODO Auto-generated constructor stub
	}
}
