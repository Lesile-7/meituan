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

import cn.jiande.pojo.Good;
import cn.jiande.pojo.Ordergood;
import cn.jiande.service.OrdergoodService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午10:16:49 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class OrdergoodServiceTest {
	@Autowired
	private OrdergoodService service;
	@Test
	public void run() {
		Ordergood good=new Ordergood();
		good.setGoodId("dfadfadsfsad");
		good.setId("fdasfadsfadsf");
		good.setOrderId("fadgfgvdfsa");
		//test insert()
		assertTrue(service.insert(good) == 1);

		List<Ordergood> goods = service.selectAll();
		//test selectAll() 
		assertNotNull(goods);
		Iterator<Ordergood> iterator = goods.iterator();
		while (iterator.hasNext()) {
			Ordergood temp = iterator.next();
			Ordergood one = service.selectByPrimaryKey(temp.getId());
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
