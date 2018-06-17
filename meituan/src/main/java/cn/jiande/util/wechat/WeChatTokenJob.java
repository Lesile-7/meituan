package cn.jiande.util.wechat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.jiande.util.wechat.pojo.WechatToken;

/** 
* @author mail: seewin@foxmail.com
* @date 创建时间：2018年2月28日 上午10:06:19 
* WeChatTokenJob获取微信token的作业
*/
public class WeChatTokenJob implements  Job{
	private static WechatToken weChatToken=null;
	
	/**
	 * quartz定时调度框架自动调用的作业执行方法
	 * 
	 * 该作业方法被quartz调用之后获取WeChat Token并将Token保存到静态成员中
	* @parameter  
	* @return
	*/
	public void execute(JobExecutionContext context) throws JobExecutionException {
		weChatToken = WechatUtil.getAccessToken();
		System.out.println("wechat token"+weChatToken);
	}
	
	/**
	 * 获取wechat token
 	 * @return WechatToken
	 */
	public static WechatToken getWeChatToken(){
		if(weChatToken==null){
			weChatToken = WechatUtil.getAccessToken();
		}
		return weChatToken;
	}
}
