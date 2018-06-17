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
import cn.jiande.pojo.User;
import cn.jiande.service.UserService;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年5月1日 上午8:59:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Service
public class UserServiceTest {
	@Autowired
	private UserService service;

	@Test
	public void test() {
		User user=new User();
		user.setId("fadsfdsafdf");
		user.setPassword("fadsfadsf");
		user.setPhone("fasdfdfcgtr");
		// test insert()
		assertTrue(service.insert(user) == 1);

		List<User> users = service.selectAll();
		// test selectAll()
		assertNotNull(users);
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User temp = iterator.next();
			User one = service.selectByPrimaryKey(temp.getId());
			// test selectByPrimaryKey()
			assertNotNull(one);
			one.setPassword("test");
			/// test updateByPrimaryKey()
			assertTrue(service.updateByPrimaryKey(one) == 1);
			one = service.selectByPrimaryKey(one.getId());
			assertNotNull(one);
			/// test updateByPrimaryKey();
			assertTrue("test".equals(one.getPassword()));
			/// test deleteByPrimaryKey()
			assertTrue(service.deleteByPrimaryKey(one.getId()) == 1);
		}
	}

}
