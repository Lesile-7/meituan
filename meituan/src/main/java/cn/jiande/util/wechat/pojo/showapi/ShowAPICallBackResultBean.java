package cn.jiande.util.wechat.pojo.showapi;

import cn.jiande.util.BasePojo;

/**
 * 
 *  ShowAPI通用返回结果
* @author : MT
* @date 创建时间：2017年12月16日 下午3:17:46 
* @version 1.0 
*/
public class ShowAPICallBackResultBean extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回状态码
	 */
	private String showapi_res_code;
	/**
	 * 返回错误代码
	 */
	private String showapi_res_error;

	/**
	 * 返回数据主体
	 */
	private ShowAPIResultBody showapi_res_body;

	/**
	 * @return the showapi_res_code
	 */
	public String getShowapi_res_code() {
		return showapi_res_code;
	}

	/**
	 * @param showapi_res_code the showapi_res_code to set
	 */
	public void setShowapi_res_code(String showapi_res_code) {
		this.showapi_res_code = showapi_res_code;
	}

	/**
	 * @return the showapi_res_error
	 */
	public String getShowapi_res_error() {
		return showapi_res_error;
	}

	/**
	 * @param showapi_res_error the showapi_res_error to set
	 */
	public void setShowapi_res_error(String showapi_res_error) {
		this.showapi_res_error = showapi_res_error;
	}

	/**
	 * @return the showapi_res_body
	 */
	public ShowAPIResultBody getShowapi_res_body() {
		return showapi_res_body;
	}

	/**
	 * @param showapi_res_body the showapi_res_body to set
	 */
	public void setShowapi_res_body(ShowAPIResultBody showapi_res_body) {
		this.showapi_res_body = showapi_res_body;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
