/*
 * CustInfoServiceImplTest.java created on 2016-06-17 上午 10:49:09 by roilatD
 */
package com.p2p.user.service.impl;

import javax.annotation.Resource;
import com.p2p.user.entity.CustInfo;
import com.p2p.user.service.CustInfoService;
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
 * 用户信息 Service 接口测试类
 * TODO javadoc for com.p2p.user.service.impl.CustInfoServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-17
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class CustInfoServiceImplTest {

	@Resource(name="custInfoService")
	private CustInfoService custInfoService;
	
	@Test
	public void testCreate() {
		try {
			CustInfo custInfo = new CustInfo();
			// 设置其他属性				
			BusinessMap bm = custInfoService.create(custInfo);
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
			CustInfo custInfo = new CustInfo();
			custInfo.setCustNo(IDUtils.genUUID());
			// 设置该属性是否存在				
			// custInfo.setCustInfoName("软件服务部");
			System.out.println(custInfoService.isExists(custInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			CustInfo custInfo = new CustInfo();
			// 设置ID
			// custInfo.setCustNo("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = custInfoService.edit(custInfo);
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
			// System.out.println(custInfoService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// custInfoService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			CustInfo custInfo = new CustInfo();
			// 设置条件
			// custInfo.setCustInfoName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = custInfoService.search(p, custInfo);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
