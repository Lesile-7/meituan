package cn.jiande.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiande.pojo.Good;
import cn.jiande.util.Beans.Message;

/** 
* 用于对商品的操作 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年5月1日 上午11:43:59 
*/
public interface IGoodController {
	/**
	 * 获取商品列表
	 * @return Message	处理后的结果消息
	 */
	public String browseGoods(Model model);
	
	/**
	 * 获取某一商品的明细
	 * @param good		商品信息(只须包含商品ID)
	 * @return Message	处理后的结果消息
	 */
	public String getDetailOfGood(Good good,Model model);
}
