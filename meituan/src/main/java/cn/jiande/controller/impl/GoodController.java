package cn.jiande.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiande.controller.IGoodController;
import cn.jiande.pojo.Good;
import cn.jiande.service.GoodService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年6月17日 上午10:25:38 
*/
@RequestMapping("good")
public class GoodController implements IGoodController{
	
	@Autowired
	private GoodService goodService;
	/**
	 * 获取商品列表
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/get/list")
	public String browseGoods(Model model){
		List<Good> list = goodService.selectAll();
		model.addAttribute("list", list);
		return "显示商品页面";
	}
	
	/**
	 * 获取某一商品的明细
	 * @param good		商品信息(只须包含商品ID)
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/get/detail")
	public String getDetailOfGood(Good good,Model model){
		if(good!=null&&good.getId()!=null&&!good.getId().equals("")){
			good=goodService.selectByPrimaryKey(good.getId());
			model.addAttribute("good", good);
			return "商品详细页面";
		}
		return "错误页面";
	}
}
