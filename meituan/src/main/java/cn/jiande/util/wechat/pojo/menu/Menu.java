package cn.jiande.util.wechat.pojo.menu;

import cn.jiande.util.BasePojo;

/** 
* 整个菜单对象的封装
* @author : MT
* @date 创建时间：2017年10月27日 下午4:01:13 
* @version 1.0 
*/
public class Menu extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5532134135669100963L;
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	/**
	 * @param button
	 */
	public Menu(Button[] button) {
		this.button = button;
	}
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
}
