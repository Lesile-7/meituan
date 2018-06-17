package cn.jiande.util.wechat.pojo.message.response;

import java.util.List;

/**
* 类名: NewsMessage 
* 描述: 文本消息 
* 开发人员： MT 
* 创建时间：  2017年10月27日
* 发布版本：V1.0  
 */
public class NewsResponseMessage extends BaseResponseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 811950720509164803L;
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}