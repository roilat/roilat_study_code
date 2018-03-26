/*
 * SysAcctJnlServiceImplTest.java created on 2016-07-02 下午 15:44:48 by roilatD
 */
package com.p2p.sys.service.impl;

import javax.annotation.Resource;
import com.p2p.sys.entity.SysAcctJnl;
import com.p2p.sys.service.SysAcctJnlService;
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
 * 会计分录流水 Service 接口测试类
 * TODO javadoc for com.p2p.sys.service.impl.SysAcctJnlServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class SysAcctJnlServiceImplTest {

	@Resource(name="sysAcctJnlService")
	private SysAcctJnlService sysAcctJnlService;
	
	@Test
	public void testCreate() {
		try {
			SysAcctJnl sysAcctJnl = new SysAcctJnl();
			// 设置其他属性				
			BusinessMap bm = sysAcctJnlService.create(sysAcctJnl);
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
			SysAcctJnl sysAcctJnl = new SysAcctJnl();
			sysAcctJnl.setTxSeqNo(IDUtils.genUUID());
			// 设置该属性是否存在				
			// sysAcctJnl.setSysAcctJnlName("软件服务部");
			System.out.println(sysAcctJnlService.isExists(sysAcctJnl));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			SysAcctJnl sysAcctJnl = new SysAcctJnl();
			// 设置ID
			// sysAcctJnl.setTxSeqNo("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = sysAcctJnlService.edit(sysAcctJnl);
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
			// System.out.println(sysAcctJnlService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// sysAcctJnlService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			SysAcctJnl sysAcctJnl = new SysAcctJnl();
			// 设置条件
			// sysAcctJnl.setSysAcctJnlName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = sysAcctJnlService.search(p, sysAcctJnl);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
