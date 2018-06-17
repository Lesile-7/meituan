package cn.jiande.util.wechat.pojo.menu;

/** 
 * 父菜单项 :包含有二级菜单项的一级菜单。这类菜单项包含有二个属性：
 * name和sub_button，而sub_button以是一个子菜单项数组
* @author : MT
* @date 创建时间：2017年10月27日 下午4:00:11 
* @version 1.0 
*/
public class ComplexButton extends Button {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1721264150785100737L;
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

	/**
	 * @param sub_button
	 */
	public ComplexButton(Button[] sub_button) {
		this.sub_button = sub_button;
	}

	public ComplexButton() {
		// TODO Auto-generated constructor stub
	}
}
