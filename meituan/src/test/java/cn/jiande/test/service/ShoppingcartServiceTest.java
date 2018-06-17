package cn.jiande.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jiande.pojo.Shoppingcart;
import cn.jiande.service.ShoppingcartService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午10:27:42 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class ShoppingcartServiceTest {
	@Autowired
	private ShoppingcartService service;
	@Test
	public void test() {
		Shoppingcart cart=new Shoppingcart();
		cart.setGoodId("ffadfasdfsadfsdaf");
		cart.setId("fadsfdsf");
		cart.setSalerId("fafdfsdfdsf");
		cart.setUserId("sdfsadfdsf");
		//test insert()
		assertTrue(service.insert(cart) == 1);

		List<Shoppingcart> carts = service.selectAll();
		//test selectAll() 
		assertNotNull(carts);
		Iterator<Shoppingcart> iterator = carts.iterator();
		while (iterator.hasNext()) {
			Shoppingcart temp = iterator.next();
			Shoppingcart one = service.selectByPrimaryKey(temp.getId());
			//test selectByPrimaryKey()
			assertNotNull(one);
			one.setGoodId("test1");
			///test updateByPrimaryKey()
			assertTrue(service.updateByPrimaryKey(one) == 1);
			one = service.selectByPrimaryKey(one.getId());
			assertNotNull(one);
			///test updateByPrimaryKey();
			assertTrue("test1".equals(one.getGoodId()));
			///test deleteByPrimaryKey()
			assertTrue(service.deleteByPrimaryKey(one.getId()) == 1);
		}
	}
	

}
