package cn.jiande.util.wechat.pojo.menu;

import cn.jiande.util.BasePojo;

/**
 * 菜单项的基类  菜单项的基类，所有一级菜单、二级菜单都共有一个相同的属性，那就是name
* @author : MT
* @date 创建时间：2017年10月27日 下午3:49:52 
* @version 1.0 
*/
public class Button extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3562554028949815033L;

	private String name;// 所有一级菜单、二级菜单都共有一个相同的属性，那就是name

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 */
	public Button(String name) {
		this.name = name;
	}

	public Button() {
		// TODO Auto-generated constructor stub
	}
}
