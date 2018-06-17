package cn.jiande.util.wechat.pojo.showapi;

import cn.jiande.util.BasePojo;

/** 
 * showAPI返回数据主体类
* @author : MT
* @date 创建时间：2017年12月18日 上午11:28:36 
* @version 1.0 
*/
public class ShowAPIResultBody extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回结果状态码
	 */
	private String ret_code;
	/**
	 * 返回数据模型
	 */
	private ShowAPIPageBean pagebean;

	/**
	 * @return the ret_code
	 */
	public String getRet_code() {
		return ret_code;
	}

	/**
	 * @param ret_code the ret_code to set
	 */
	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	/**
	 * @return the pagebean
	 */
	public ShowAPIPageBean getPagebean() {
		return pagebean;
	}

	/**
	 * @param pagebean the pagebean to set
	 */
	public void setPagebean(ShowAPIPageBean pagebean) {
		this.pagebean = pagebean;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
