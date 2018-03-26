/*
 * ProdLoanRelServiceImplTest.java created on 2016-06-12 上午 09:35:35 by roilatD
 */
package com.p2p.invst.service.impl;

import javax.annotation.Resource;
import com.p2p.invst.entity.ProdLoanRel;
import com.p2p.invst.service.ProdLoanRelService;
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
 * 产品与借款人关系表 Service 接口测试类
 * TODO javadoc for com.p2p.invst.service.impl.ProdLoanRelServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class ProdLoanRelServiceImplTest {

	@Resource(name="prodLoanRelService")
	private ProdLoanRelService prodLoanRelService;
	
	@Test
	public void testCreate() {
		try {
			ProdLoanRel prodLoanRel = new ProdLoanRel();
			// 设置其他属性				
			BusinessMap bm = prodLoanRelService.create(prodLoanRel);
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
			ProdLoanRel prodLoanRel = new ProdLoanRel();
			prodLoanRel.setProdTyp(IDUtils.genUUID());
			// 设置该属性是否存在				
			// prodLoanRel.setProdLoanRelName("软件服务部");
			System.out.println(prodLoanRelService.isExists(prodLoanRel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			ProdLoanRel prodLoanRel = new ProdLoanRel();
			// 设置ID
			// prodLoanRel.setProdTyp("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = prodLoanRelService.edit(prodLoanRel);
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
			// System.out.println(prodLoanRelService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// prodLoanRelService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			ProdLoanRel prodLoanRel = new ProdLoanRel();
			// 设置条件
			// prodLoanRel.setProdLoanRelName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = prodLoanRelService.search(p, prodLoanRel);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
