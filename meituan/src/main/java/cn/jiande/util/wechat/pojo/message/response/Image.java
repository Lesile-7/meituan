package cn.jiande.util.wechat.pojo.message.response;

import cn.jiande.util.BasePojo;

/**
* 类名: Image 
* 描述: 图片 
* 开发人员：MT
* 创建时间：  2017年10月20日
* 发布版本：V1.0  
 */
public class Image extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4545654631291771894L;
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
