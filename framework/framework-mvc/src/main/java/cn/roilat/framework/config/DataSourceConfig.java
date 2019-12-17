package cn.roilat.framework.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据源及mybatis配置
 * 
 * @author roilat-J
 * @version $Id: DataSourceConfig.java, v 0.1 2019年2月28日 下午5:05:13 roilat-J Exp
 *          $
 */
@Configuration
@MapperScan(basePackages = "cn.roilat.biz.*.mappers", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

	/**
	 * 适用的场景是“mybatis”
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "transactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}


	/**
	 * 这是mybatis的sqlSessionTemplate
	 * @param sqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
