package cn.jiande.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.jiande.pojo.Good;
import cn.jiande.pojo.Order;
import cn.jiande.pojo.Saler;
import cn.jiande.util.Beans.CommonQo;

/** 
* 用于商家的操作
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:34:25 
*/
@RequestMapping("/saler")
@Controller
public interface ISalerController {
	
	/**
	 * 注册商家账号
	 * @param saler		商家信息
	 * @return String	处理后的结果消息
	 */
	public String register(Saler saler);
	
	/**
	 * 商家账号登录
	 * @param saler  	商家信息(只需账号,密码两个字段即可)
	 * @return String 	处理后的结果消息
	 */
	public String login(HttpServletRequest request,Saler saler);
	
	
	/**
	 * 商家退出登录
	 * @return String
	 */
	public String logout();
	
	
	/**
	 * 商家查看个人信息
	 * @return String	 处理后的结果消息
	 */
	public String showMyself();
	
	/**
	 * 商家修改个人信息
	 * @param saler 	 商家信息
	 * @return String	 处理后的结果消息
	 */
	public String updateSaler(Saler saler);
	
	/**
	 * 添加商品
	 * @param good  	要添加的商品的相关信息
	 * @return String	处理后的结果消息
	 */
	public String insertGood(HttpServletRequest request,Good good,MultipartFile Pic) ;
	
	
	/**
	 * 修改商品信息
	 * @param good  	商品信息
	 * @return String 	处理后的结果消息
	 */
	public String updateGood(Good good);
	
	/**
	 * 删除商品
	 * @param good  	商品信息(字段必须包含商品ID)
	 * @return String 	处理后的结果消息
	 */
	public String deleteGood(Good good);
	
	/**
	 * 商家接单
	 * @param order		订单信息(必须包含订单ID)
	 * @return String  处理后的结果消息
	 */
	public String receiptOrder(HttpServletRequest request,Order order) ;
	
	/**
	 * 商家多条件组合查询订单
	 * @param commonQo  页数,页码,查询的订单所在的时间区间
	 * @param order		订单信息
	 * @return String	处理后的结果消息
	 */
	public String showOrder(CommonQo commonQo, Order order);
	
}
