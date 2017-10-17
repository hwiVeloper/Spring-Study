package com.hwi.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyBatisTest {
	@Inject
	private SqlSessionFactory sqlFactory;
	
	// pom.xml 라이브러리만 가지고오고
	// root-context.xml 가지고 온 라이브러리를 설정
	// 해당 소스 : 실제로 라이브러리를 사용 (Inject Annotation 사용)
	
	@Test
	public void testFactory() {
		// SQL Factory Test
		System.out.println(sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception {
		// SQL Factory - Session Test
		try {
			SqlSession session = sqlFactory.openSession();
			
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
