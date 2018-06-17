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
import cn.jiande.service.GoodService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午8:14:34 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class GoodServiceTest {
	@Autowired
	private GoodService service;

	@Test
	public void run(){
		Good good=new Good();
		good.setDescription("test");
		good.setId("dsafadsfadsfasd");
		good.setName("test");
		good.setPic("dfsadfadsfa0");
		good.setSalerId("afdssadfdsafsdaf");
		good.setNum(9);
		//test insert()
		assertTrue(service.insert(good) == 1);

		List<Good> goods = service.selectAll();
		//test selectAll() 
		assertNotNull(goods);
		Iterator<Good> iterator = goods.iterator();
		while (iterator.hasNext()) {
			Good temp = iterator.next();
			Good one = service.selectByPrimaryKey(temp.getId());
			//test selectByPrimaryKey()
			assertNotNull(one);
			one.setName("test1");
			///test updateByPrimaryKey()
			assertTrue(service.updateByPrimaryKey(one) == 1);
			one = service.selectByPrimaryKey(one.getId());
			assertNotNull(one);
			///test updateByPrimaryKey();
			assertTrue("test1".equals(one.getName()));
			///test deleteByPrimaryKey()
			assertTrue(service.deleteByPrimaryKey(one.getId()) == 1);
		}
	}

}
