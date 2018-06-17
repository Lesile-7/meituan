package cn.jiande.controller.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.jiande.controller.ISalerController;
import cn.jiande.pojo.Good;
import cn.jiande.pojo.Order;
import cn.jiande.pojo.Saler;
import cn.jiande.service.GoodService;
import cn.jiande.service.OrderService;
import cn.jiande.service.SalerService;
import cn.jiande.util.Beans.CommonQo;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年6月17日 上午10:37:38 
*/
public class SalerController implements ISalerController {

	@Autowired
	private SalerService salerService;
	
	@Autowired
	private GoodService goodService;
	
	@Autowired
	private OrderService orderService;
	/**
	 * 注册商家账号
	 * @param saler		商家信息
	 * @return String	处理后的结果消息
	 */
	@RequestMapping("/register")
	public String register(Saler saler) {
		if(saler!=null&&saler.getId()!=null&&!saler.getId().equals("")&&saler.getPassword()!=null&&!saler.getPassword().equals("")){
			salerService.insert(saler);
			return "成功页面";
		}
		return "失败页面";
	}

	/**
	 * 商家账号登录
	 * @param saler  	商家信息(只需账号,密码两个字段即可)
	 * @return String 	处理后的结果消息
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Saler saler) {
		if(saler!=null&&saler.getId()!=null&&!saler.getId().equals("")&&saler.getPassword()!=null&&!saler.getPassword().equals("")){
			Saler temp = salerService.selectByPrimaryKey(saler.getId());
			if(temp.getPassword()!=null&&temp.getPassword().equals(saler.getPassword())){
				request.getSession().setAttribute("user", temp);
				return "登录成功页面";
			}
		}
		return "失败页面";
	}

	/**
	 * 商家退出登录
	 * @return String
	 */
	@RequestMapping("/logout")
	public String logout() {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

	
	/**
	 * 商家查看个人信息
	 * @return String	 处理后的结果消息
	 */
	@RequestMapping("/show/myself")
	public String showMyself() {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

	/**
	 * 商家修改个人信息
	 * @param saler 	 商家信息
	 * @return String	 处理后的结果消息
	 */
	@RequestMapping("/put/saler")
	public String updateSaler(Saler saler) {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

	/**
	 * 传商品名,商品数量,商品描述,商品图片
	 * 添加商品
	 * @param good  	要添加的商品的相关信息
	 * @return String	处理后的结果消息
	 */
	@RequestMapping("/post/good")
	public String insertGood(HttpServletRequest request,Good good,MultipartFile Pic) {
		if(good!=null&&good.getId()!=null){
			Saler saler=(Saler) request.getSession().getAttribute("user");
			if(saler!=null&saler.getId()!=null){
				///设置商品id
				good.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
				//设置商品卖家id
				good.setSalerId(saler.getId());
				//设置商品数量
				//保存图片
				if(Pic !=null) {
		            //储存图片的物理路径
		            String realPath = request.getServletContext().getRealPath("/WEB-INF/view/img/repair/");
		            String originalFileName = Pic.getOriginalFilename();
		            //新的的图片名称
		            String newFileName = UUID.randomUUID().toString().replace("-","").toUpperCase()+originalFileName.substring(originalFileName.lastIndexOf("."));
		            //新图片文件
		            File newFile = new File(realPath+newFileName);
		            //将内存中的数据写入磁盘
		            try {
						Pic.transferTo(newFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		            //将新图片名称写到good中
		            good.setPic(newFileName);
		            goodService.insert(good);
		            return "添加成功页面";
		        } 
			}
		}
		return "失败页面";
	}

	/**
	 * 修改商品信息
	 * @param good  	商品信息
	 * @return String 	处理后的结果消息
	 */
	@RequestMapping("/put/good")
	public String updateGood(Good good) {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

	/**
	 * 删除商品
	 * @param good  	商品信息(字段必须包含商品ID)
	 * @return String 	处理后的结果消息
	 */
	@RequestMapping("/delete/good")
	public String deleteGood(Good good) {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

	/**
	 * 传商品id
	 * 商家接单
	 * @param order		订单信息(必须包含订单ID)
	 * @return String  处理后的结果消息
	 */
	@RequestMapping("/receipt/order")
	public String receiptOrder(HttpServletRequest request,Order order) {
		Saler saler=(Saler) request.getSession().getAttribute("user");
		if(saler!=null&&saler.getId()!=null&&order!=null&&order.getId()!=null){
			order=orderService.selectByPrimaryKey(order.getId());
			order.setState(new Integer(1));//修改订单状态
			orderService.updateByPrimaryKey(order);
			return "成功页面";
		}
		return "失败页面";
	}

	/**
	 * 商家多条件组合查询订单
	 * @param commonQo  页数,页码,查询的订单所在的时间区间
	 * @param order		订单信息
	 * @return String	处理后的结果消息
	 */
	@RequestMapping("/get/order")
	public String showOrder(CommonQo commonQo, Order order) {
		/**
		 * @parameter  
		 * @return
		*/
		return null;
	}

}
