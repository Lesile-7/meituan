package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: ImageMessage 
* 描述: 图片消息
* 开发人员： MT 
* 创建时间：  2017年10月20日
* 发布版本：V1.0
 */
public class ImageResponseMessage extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1004495030571031500L;
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
