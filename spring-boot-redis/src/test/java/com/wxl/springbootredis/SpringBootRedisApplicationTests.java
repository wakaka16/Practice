package com.wxl.springbootredis;

import com.wxl.springbootredis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 测试储存字符串
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	/**
	 * 测试存储对象
	 * @throws Exception
	 * 被保存对象必须实现序列化
	 */
	@Test
	public void testObj() throws Exception {
		User user=new User();
		user.setName("aa");
		user.setPwd("aa123456");
		ValueOperations<String, User> operations=redisTemplate.opsForValue();
//		"[\"com.wxl.springbootredis.entity.User\",{\"email\":\"aa@126.com\",\"name\":\"aa\",\"pwd\":\"aa123456\"}]"
		operations.set("user", user);//永久保存
		operations.set("user", user,1,TimeUnit.SECONDS);//保存1ms
		Thread.sleep(1000);
		//redisTemplate.delete("com.neo.f");
		boolean exists=redisTemplate.hasKey("user");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
	}

	//@Autowired
	//private RedisTemplate<Serializable, Object> redisTemplate;

	//@Autowired
	//private RedisService redisService;



}
