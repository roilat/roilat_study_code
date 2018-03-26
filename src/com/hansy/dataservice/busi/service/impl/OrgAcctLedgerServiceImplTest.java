/*
 * OrgAcctLedgerServiceImplTest.java created on 2016-08-17 下午 16:17:44 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import javax.annotation.Resource;
import com.hansy.dataservice.busi.entity.OrgAcctLedger;
import com.hansy.dataservice.busi.service.OrgAcctLedgerService;
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
 * 查询机构充值台账 Service 接口测试类
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.OrgAcctLedgerServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class OrgAcctLedgerServiceImplTest {

	@Resource(name="orgAcctLedgerService")
	private OrgAcctLedgerService orgAcctLedgerService;
	
	@Test
	public void testCreate() {
		try {
			OrgAcctLedger orgAcctLedger = new OrgAcctLedger();
			// 设置其他属性				
			BusinessMap bm = orgAcctLedgerService.create(orgAcctLedger);
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
			OrgAcctLedger orgAcctLedger = new OrgAcctLedger();
			orgAcctLedger.setFlowId(IDUtils.genUUID());
			// 设置该属性是否存在				
			// orgAcctLedger.setOrgAcctLedgerName("软件服务部");
			System.out.println(orgAcctLedgerService.isExists(orgAcctLedger));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			OrgAcctLedger orgAcctLedger = new OrgAcctLedger();
			// 设置ID
			// orgAcctLedger.setFlowId("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = orgAcctLedgerService.edit(orgAcctLedger);
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
			// System.out.println(orgAcctLedgerService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// orgAcctLedgerService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			OrgAcctLedger orgAcctLedger = new OrgAcctLedger();
			// 设置条件
			// orgAcctLedger.setOrgAcctLedgerName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = orgAcctLedgerService.search(p, orgAcctLedger);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
