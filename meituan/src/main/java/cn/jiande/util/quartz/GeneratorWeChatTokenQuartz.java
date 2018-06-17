package cn.jiande.util.quartz;

import org.quartz.Job;

/** 
* @author mail: seewin@foxmail.com
* @date 创建时间：2018年2月28日 上午10:18:57 
* 创建获取微信token的作业调度
*/
public class GeneratorWeChatTokenQuartz {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Class<Job> jobClass=null;
		try {
			jobClass=(Class<Job>) Class.forName("cn.jiande.util.wechat.WeChatTokenJob");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QuartzManagerUtil.addJob("getWeChatToken", "WeChatJob", "WeChatTrigger", "WeChatTrigerGroup", jobClass, "0/3 * * * * ?");
	}
}
