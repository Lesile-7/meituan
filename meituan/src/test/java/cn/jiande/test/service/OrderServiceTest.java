package cn.jiande.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jiande.pojo.Order;
import cn.jiande.service.OrderService;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年4月30日 下午6:21:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class OrderServiceTest {
	@Autowired
	private OrderService service;

	/**
	 * Test method for
	 * {@link cn.jiande.service.impl.OrderServiceImpl#deleteByPrimaryKey(java.lang.String)}
	 * .
	 */
	@Test
	public void run() {
		Order order = new Order();
		order.setId("daksfasdfnvdsfasdgfjkdfld");
		order.setAddress("广州");
		order.setNotes("fdafasdf");
		order.setOrderTime(new Date());
		order.setSalerId("ddasdasd");
		order.setSalerPhone("11111111");
		order.setState(1);
		order.setUserId("sdfsdfdsafad");
		order.setUserPhone("22222222222");
		//test insert()
		assertTrue(service.insert(order) == 1);

		List<Order> orders = service.selectAll();
		//test selectAll() 
		assertNotNull(orders);
		Iterator<Order> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Order temp = iterator.next();
			Order one = service.selectByPrimaryKey(temp.getId());
			//test selectByPrimaryKey()
			assertNotNull(one);
			one.setNotes("test");
			///test updateByPrimaryKey()
			assertTrue(service.updateByPrimaryKey(one) == 1);
			one = service.selectByPrimaryKey(one.getId());
			assertNotNull(one);
			///test updateByPrimaryKey();
			assertTrue("test".equals(one.getNotes()));
			///test deleteByPrimaryKey()
			assertTrue(service.deleteByPrimaryKey(one.getId()) == 1);
		}
	}
	
}
