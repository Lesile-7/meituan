package cn.jiande.controller.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiande.controller.IUserController;
import cn.jiande.pojo.Order;
import cn.jiande.pojo.Shoppingcart;
import cn.jiande.pojo.User;
import cn.jiande.service.OrderService;
import cn.jiande.service.ShoppingcartService;
import cn.jiande.service.UserService;
import cn.jiande.util.Beans.CommonQo;
import cn.jiande.util.Beans.Message;

/** 
 * 用于用户的操作
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年6月16日 下午5:20:40 
*/
@RequestMapping("/user")
public class UserController implements IUserController {

	@Autowired
	private  UserService userService;
	
	@Autowired
	private ShoppingcartService shoppingcartService;
	
	@Autowired
	private OrderService orderService;
	/**
	 * 注册用户账号
	 * @param user		普通用户信息
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/register")
	public String register(User user) {
		Message msg=new Message();
		if(user==null&&user.getId()==null&&user.getPassword()==null){
			return "失败页面";
		}
		User temp=userService.selectByPrimaryKey(user.getId());
		if(temp==null){//数据库中没有该账号,则注册成功
			return "成功页面";
		}
		return "失败页面";
	}

	/**
	 * 普通用户账号登录
	 * @param saler  	用户信息(只需账号,密码两个字段即可)
	 * @return Message 	处理后的结果消息
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, User user, Model model) {
		Message msg=new Message();
		if(user==null&&user.getId()==null&&user.getPassword()==null){
			return "失败页面";
		}
		User temp=userService.selectByPrimaryKey(user.getId());
		if(temp.getPassword().equals(user.getPassword())){
			request.getSession().setAttribute("user", temp);
			return "成功页面";
		}
		return "失败页面";
	}

	
	/**
	 * 普通用户退出登录
	 * @return Message
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "成功页面";
	}

	/**
	 * 用户查看个人信息
	 * @return Message	 处理后的结果消息
	 */
	@RequestMapping("/show/myself")
	public String showMyself(HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){//当前用于未登录
			return "登录页面";
		}
		return "显示个人信息页面";
	}

	/**
	 * 普通用户修改个人信息
	 * @param param		请求修改的用户信息
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/put/user")
	public String updateUser(HttpServletRequest request,User param) {
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){//当前用于未登录
			return "登录页面";
		}
		///如果请求参数数据合法
		if(!(param==null||"".equals(param.getId())||!"".equals(param.getPassword()))){
			if(userService.updateByPrimaryKey(param)==1){
				 request.getSession().setAttribute("user", param);
				return "成功页面";
			}
		}
		return "错误页面";
	}
	
	/**
	 * 不用传参,须先登录
	 * 展示我的购物车
	 * @return Message 处理后的结果消息
	 */
	@RequestMapping("/show/cart")
	public String showMyShoppingCart(HttpServletRequest request,Model model) {
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null&&user.getId()!=null&!user.getId().equals("")){
			Shoppingcart cart=new Shoppingcart();
			cart.setUserId(user.getId());
			List<Shoppingcart> list = shoppingcartService.selectByParam(cart);
			model.addAttribute("data", list);
			return "显示购物车页面";
		}
		return "错误页面";
	}

	/**
	 * 用户下订单
	 * @param good 		订单信息(包括:用户联系手机,填写的地址,商品ID;
	 * 					商品ID:一个或多个商品的ID(一条商品的ID保存在Order类的goods(list集合)字段中的Good类中的ID字段))
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/post/order")
	public String addOrder(Order order) {
		if(order!=null&&order.getSalerId()!=null&&order.getAddress()!=null){
			Date date=new Date();
			order.setOrderTime(date);
			order.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
			order.setState(new Integer(0));
			orderService.insert(order);
			return "下单成功页面";
		}
		return "下单失败页面";
	}

	/**
	 * 传订单id
	 * 用户查看某一条订单的详细
	 * @param order 	订单信息(只须包含订单ID即可)
	 * @return Message	处理后的结果消息
	 */
	@RequestMapping("/show/order")
	public String showOneOrder(Order order,Model model) {
		if(order!=null&&order.getId()!=null&&!order.getId().equals("")){
			Order data=orderService.selectByPrimaryKey(order.getId());
			model.addAttribute("order", data);
			return "显示订单详情页面";
		}
		
		return "失败页面";
	}
	/**
	 * 用户多条件获取历史订单
	 * @param commonQo
	 * @param order
	 * @return Message
	 */
	@RequestMapping("/show/orderlist")
	public String showOrderByParam(CommonQo commonQo, Order order) {
		return "暂不实现";
	}

}
