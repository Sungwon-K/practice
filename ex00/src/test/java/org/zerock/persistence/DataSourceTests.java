package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	/*
	 * @Setter(onMethod_= {@Autowired}) private Restaurant restuarant;//주입
	 * 
	 * @Test public void testExist() { assertNotNull(restuarant);
	 * 
	 * log.info(restuarant); log.info("------------------");
	 * log.info(restuarant.getChef()); }
	 */
	
	
	/*오라클 연결테스트. dbcp 사용안함.
	 * static { try { Class.forName("oracle.jdbc.driver.OracleDriver");
	 * }catch(Exception e) { e.printStackTrace(); } }
	 * 
	 * @Test public void testConnection() { //close()를 자동 수행 //finally에서 close()작성
	 * 필요없음. try(Connection con = DriverManager.getConnection(
	 * "jdbc:orcle:thin:@localhost:1521:myoracle", "ora_user", "hong")){
	 * log.info(con); log.info("DB연결됨"); }catch(Exception e) { fail(e.getMessage());
	 * } }
	 */
	
	/*
	 * @Setter(onMethod_= { @Autowired} ) private DataSource dataSource;
	 * 
	 * @Test public void testConnection() { try(Connection con =
	 * dataSource.getConnection()){
	 * 
	 * log.info(con); log.info("db연결됨(hikari dbcp)");
	 * 
	 * }catch(Exception e) { fail(e.getMessage()); } }
	 */
	@Setter(onMethod_= @Autowired)
	private TimeMapper timeMapper;
	@Test
	public void testGetTime2() {
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}
}
