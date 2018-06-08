import java.io.File;

import org.apache.commons.io.FileUtils;

import com.bpnet.framework.genCode.ConfigManager;
import com.bpnet.framework.genCode.ConfigModel;
import com.bpnet.framework.genCode.GenFacade;


/*
 * Gen.java created on 2014年5月16日 下午3:11:30 by Administrator
 */

/**
 * TODO javadoc for .Gen
 * @Copyright: 2017成都环赛信息技术有限公司
 * @author: Administrator
 * @since: 2014年5月16日
 */
public class Gen {

	/**
	 * @description: TODO
	 * @creator: roilat-D
	 * @createDate: 2016年6月14日 
	 * @modifier:
	 * @modifiedDate:
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigModel cm = ConfigManager.getInstance().getConfigModel();
		cm.setDbType("oracle");
		// 设置jdbc
		cm.setDriverName("oracle.jdbc.driver.OracleDriver");
		cm.setUrl("jdbc:oracle:thin:@192.168.7.202:1521:xddev");
		cm.setUsername("newSalaryuser");
		cm.setPassword("123456");
/*		cm.setDbType("mysql");
		// 设置jdbc
		cm.setDriverName("com.mysql.jdbc.Driver");
		cm.setUrl("jdbc:mysql://rds7349m0p48u5q9182j.mysql.rds.aliyuncs.com:3306/cdfsoa?characterEncoding=UTF-8");
		cm.setUsername("cdfsoa");
		cm.setPassword("Cdfsoa++");*/
		
		// 设置数据库表名
		cm.setTblName("CL_ACHIEVE_DETAIL");
		// 设置数据库表名
		cm.setBeanName("ClAchieveDetail");
		// 数据库表的中文名称
		cm.setBeanCnName("业绩明细表");
		// 所放的包路径
		cm.setModulePack("com.zhph.sys");
		
		// 代码生成的位置
		//cm.setGenPath("D:\\genCode");
		//cm.setGenPath("D:/eking_project/maven/genMyBatis/genCode");
		cm.setGenPath("./src/main/java");
		// 创建用户
		cm.setCreateUser("roilatD");
		GenFacade.generate();
	}
}

