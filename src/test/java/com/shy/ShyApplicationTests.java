package com.shy;

import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shy.util.HttpUtil;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ShyApplication.class)
public class ShyApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		InputStream in =  HttpUtil.getInputStream("http://localhost/shutdown", "{\"name\":\"shy\",\"password\":\"wzy\"}", "POST");
		String x = HttpUtil.getResponseStream(in);
		System.out.println(x);
	}

}
