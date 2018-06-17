package cn.jiande.util.wechat.pojo.showapi;

import java.util.List;

import cn.jiande.util.BasePojo;

/** 
 * 具体返回数据实体模型
* @author : MT
* @date 创建时间：2017年12月18日 上午11:29:25 
* @version 1.0 
*/
public class ShowAPIPageBean extends BasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 搜索关键词
	 */
	private String w;

	/**
	 * 搜索结果的页数
	 */
	private String allPages;

	/**
	 * 结果状态码
	 */
	private String ret_code;

	/**
	 * 数据集合，根据不同的接口封装不同的数据模型
	 */
	private List<ShowAPIMusicBean> contentlist;

	/**
	 * 当前页
	 */
	private String currentPage;

	/**
	 * 备注
	 */
	private String notice;

	/**
	 * 一共有多少条搜索结果
	 */
	private String allNum;

	/**
	 * 每页最大结果数
	 */
	private String maxResult;

	/**
	 * @return the w
	 */
	public String getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(String w) {
		this.w = w;
	}

	/**
	 * @return the allPages
	 */
	public String getAllPages() {
		return allPages;
	}

	/**
	 * @param allPages the allPages to set
	 */
	public void setAllPages(String allPages) {
		this.allPages = allPages;
	}

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
	 * @return the contentlist
	 */
	public List<ShowAPIMusicBean> getContentlist() {
		return contentlist;
	}

	/**
	 * @param contentlist the contentlist to set
	 */
	public void setContentlist(List<ShowAPIMusicBean> contentlist) {
		this.contentlist = contentlist;
	}

	/**
	 * @return the currentPage
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * @return the allNum
	 */
	public String getAllNum() {
		return allNum;
	}

	/**
	 * @param allNum the allNum to set
	 */
	public void setAllNum(String allNum) {
		this.allNum = allNum;
	}

	/**
	 * @return the maxResult
	 */
	public String getMaxResult() {
		return maxResult;
	}

	/**
	 * @param maxResult the maxResult to set
	 */
	public void setMaxResult(String maxResult) {
		this.maxResult = maxResult;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
