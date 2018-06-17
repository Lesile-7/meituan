package cn.jiande.util;

/** 
 * 用来封装返回给前端的Json数据
* @author : MT
* @date 创建时间：2017年11月30日 下午2:35:18 
* @version 1.0 
*/
public class CalllBackResult extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean status;// 状态
	private Object detail;// 具体数据
	private String message;// 信息（失败或者成功的详细说明）

	public CalllBackResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isSucess
	 * @param detail
	 * @param message
	 */
	public CalllBackResult(boolean status, Object detail, String message) {
		this.status = status;
		this.detail = detail;
		this.message = message;
	}

	/**
	 * @param isSucess
	 * @param message
	 */
	public CalllBackResult(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the detail
	 */
	public Object getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(Object detail) {
		this.detail = detail;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
