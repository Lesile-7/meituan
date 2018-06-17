package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: Article
* 描述: 图文model
* 开发人员： MT
* 创建时间：  2017年10月20日
* 发布版本：V1.0
 */
public class Article extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9197917930690217863L;
	// 图文消息名称
	private String Title;
	// 图文消息描述
	private String Description;
	// 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	private String PicUrl;
	// 点击图文消息跳转链接
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return null == Description ? "" : Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return null == PicUrl ? "" : PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return null == Url ? "" : Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}