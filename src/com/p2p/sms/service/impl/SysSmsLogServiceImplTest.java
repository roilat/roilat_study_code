/*
 * SysSmsLogServiceImplTest.java created on 2016-05-23 下午 18:14:59 by roilatD
 */
package com.p2p.sms.service.impl;

import javax.annotation.Resource;
import com.p2p.sms.entity.SysSmsLog;
import com.p2p.sms.service.SysSmsLogService;
import org.eking.framework.common.BusinessMap;
import org.eking.framework.common.Constants;
import org.eking.framework.common.Pager;
import org.eking.framework.utils.IDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * 短信日志表 Service 接口测试类
 * TODO javadoc for com.p2p.sms.service.impl.SysSmsLogServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-23
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class SysSmsLogServiceImplTest {

	@Resource(name="sysSmsLogService")
	private SysSmsLogService sysSmsLogService;
	
	@Test
	public void testCreate() {
		try {
			SysSmsLog sysSmsLog = new SysSmsLog();
			// 设置其他属性				
			BusinessMap bm = sysSmsLogService.create(sysSmsLog);
			if (!bm.getIsSucc()) {
				System.out.println(bm.getMess(Constants.WARNING_MSG));
			} else {
				System.out.println("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsExists() {
		try {
			SysSmsLog sysSmsLog = new SysSmsLog();
			sysSmsLog.setId(IDUtils.genUUID());
			// 设置该属性是否存在				
			// sysSmsLog.setSysSmsLogName("软件服务部");
			System.out.println(sysSmsLogService.isExists(sysSmsLog));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			SysSmsLog sysSmsLog = new SysSmsLog();
			// 设置ID
			// sysSmsLog.setId("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = sysSmsLogService.edit(sysSmsLog);
			if (!bm.getIsSucc()) {
				System.out.println(bm.getMess(Constants.WARNING_MSG));
			} else {
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetById() {
		try {
			// 设置ID
			// System.out.println(sysSmsLogService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// sysSmsLogService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			SysSmsLog sysSmsLog = new SysSmsLog();
			// 设置条件
			// sysSmsLog.setSysSmsLogName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = sysSmsLogService.search(p, sysSmsLog);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
