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

import cn.jiande.pojo.Ordergood;
import cn.jiande.pojo.Saler;
import cn.jiande.service.SalerService;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年4月30日 下午10:22:01 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class SalerServiceTest {
	@Autowired
	private SalerService service;
	@Test
	public void test() {
		Saler saler=new Saler();
		saler.setAddress("afdsadsf");
		saler.setId("dfadfdsafasd");
		saler.setName("fdsfsadf");
		saler.setPassword("fdafasdfsdaf");
		saler.setPhone("dsafdsafdsaf");
		//test insert()
		assertTrue(service.insert(saler) == 1);

		List<Saler> salers = service.selectAll();
		//test selectAll() 
		assertNotNull(salers);
		Iterator<Saler> iterator = salers.iterator();
		while (iterator.hasNext()) {
			Saler temp = iterator.next();
			Saler one = service.selectByPrimaryKey(temp.getId());
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
