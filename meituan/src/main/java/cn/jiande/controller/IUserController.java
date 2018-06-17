package cn.jiande.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiande.pojo.Good;
import cn.jiande.pojo.Order;
import cn.jiande.pojo.Saler;
import cn.jiande.pojo.User;
import cn.jiande.util.Beans.CommonQo;

/** 
* 用于用户的操作
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午3:34:08 
*/

public interface IUserController {
	
	/**
	 * 注册用户账号
	 * @param user		普通用户信息
	 * @return String	处理后的结果消息
	 */
	
	public String register(User user);
	
	/**
	 * 普通用户账号登录
	 * @param saler  	用户信息(只需账号,密码两个字段即可)
	 * @return String 	处理后的结果消息
	 */
	public String login(HttpServletRequest request, User user, Model model);
	
	
	
	/**
	 * 普通用户退出登录
	 * @return String
	 */
	public String logout(HttpServletRequest request);
	
	
	
	/**
	 * 用户查看个人信息
	 * @return String	 处理后的结果消息
	 */
	public String showMyself(HttpServletRequest request);
	
	
	
	
	/**
	 * 普通用户修改个人信息
	 * @param user		用户信息
	 * @return String	处理后的结果消息
	 */
	public String updateUser(HttpServletRequest request,User param);
	
	
	
	/**
	 * 展示我的购物车
	 * @return String 处理后的结果消息
	 */
	public String showMyShoppingCart(HttpServletRequest request,Model model);
	
	
	
	/**
	 * 用户下订单
	 * @param good 		订单信息(包括:用户联系手机,填写的地址,商品ID;
	 * 					商品ID:一个或多个商品的ID(一条商品的ID保存在Order类的goods(list集合)字段中的Good类中的ID字段))
	 * @return String	处理后的结果消息
	 */
	public String addOrder(Order order);
	
	
	
	/**
	 * 用户查看某一条订单的详细
	 * @param order 	订单信息(只须包含订单ID即可)
	 * @return String	处理后的结果消息
	 */
	public String showOneOrder(Order order,Model model);
	
	
	
	/**
	 * 用户多条件获取历史订单
	 * @param commonQo
	 * @param order
	 * @return String
	 */
	public String showOrderByParam(CommonQo commonQo, Order order);
	
	
}
