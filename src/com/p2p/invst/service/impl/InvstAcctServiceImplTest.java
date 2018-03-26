/*
 * InvstAcctServiceImplTest.java created on 2016-06-06 下午 16:57:34 by roilatD
 */
package com.p2p.invst.service.impl;

import javax.annotation.Resource;
import com.p2p.invst.entity.InvstAcct;
import com.p2p.invst.service.InvstAcctService;
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
 * 投资人信息表 Service 接口测试类
 * TODO javadoc for com.p2p.invst.service.impl.InvstAcctServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-06
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class InvstAcctServiceImplTest {

	@Resource(name="invstAcctService")
	private InvstAcctService invstAcctService;
	
	@Test
	public void testCreate() {
		try {
			InvstAcct invstAcct = new InvstAcct();
			// 设置其他属性				
			BusinessMap bm = invstAcctService.create(invstAcct);
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
			InvstAcct invstAcct = new InvstAcct();
			invstAcct.setAcctNo(IDUtils.genUUID());
			// 设置该属性是否存在				
			// invstAcct.setInvstAcctName("软件服务部");
			System.out.println(invstAcctService.isExists(invstAcct));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			InvstAcct invstAcct = new InvstAcct();
			// 设置ID
			// invstAcct.setAcctNo("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = invstAcctService.edit(invstAcct);
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
			// System.out.println(invstAcctService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// invstAcctService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			InvstAcct invstAcct = new InvstAcct();
			// 设置条件
			// invstAcct.setInvstAcctName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = invstAcctService.search(p, invstAcct);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
