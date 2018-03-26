/*
 * LoanCustBaseInfoServiceImplTest.java created on 2016-08-17 下午 16:20:39 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import javax.annotation.Resource;
import com.hansy.dataservice.busi1.entity.LoanCustBaseInfo;
import com.hansy.dataservice.busi1.service.LoanCustBaseInfoService;
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
 * 贷款客户基本信息 Service 接口测试类
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.LoanCustBaseInfoServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class LoanCustBaseInfoServiceImplTest {

	@Resource(name="loanCustBaseInfoService")
	private LoanCustBaseInfoService loanCustBaseInfoService;
	
	@Test
	public void testCreate() {
		try {
			LoanCustBaseInfo loanCustBaseInfo = new LoanCustBaseInfo();
			// 设置其他属性				
			BusinessMap bm = loanCustBaseInfoService.create(loanCustBaseInfo);
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
			LoanCustBaseInfo loanCustBaseInfo = new LoanCustBaseInfo();
			loanCustBaseInfo.setCustName(IDUtils.genUUID());
			// 设置该属性是否存在				
			// loanCustBaseInfo.setLoanCustBaseInfoName("软件服务部");
			System.out.println(loanCustBaseInfoService.isExists(loanCustBaseInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			LoanCustBaseInfo loanCustBaseInfo = new LoanCustBaseInfo();
			// 设置ID
			// loanCustBaseInfo.setCustName("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = loanCustBaseInfoService.edit(loanCustBaseInfo);
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
			// System.out.println(loanCustBaseInfoService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// loanCustBaseInfoService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			LoanCustBaseInfo loanCustBaseInfo = new LoanCustBaseInfo();
			// 设置条件
			// loanCustBaseInfo.setLoanCustBaseInfoName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = loanCustBaseInfoService.search(p, loanCustBaseInfo);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
