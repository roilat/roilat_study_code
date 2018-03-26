/*
 * SysDealRecordsServiceImplTest.java created on 2016-06-14 下午 19:55:22 by roilatD
 */
package com.p2p.invst.service.impl;

import javax.annotation.Resource;
import com.p2p.invst.entity.SysDealRecords;
import com.p2p.invst.service.SysDealRecordsService;
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
 * 系统交易记录 Service 接口测试类
 * TODO javadoc for com.p2p.invst.service.impl.SysDealRecordsServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class SysDealRecordsServiceImplTest {

	@Resource(name="sysDealRecordsService")
	private SysDealRecordsService sysDealRecordsService;
	
	@Test
	public void testCreate() {
		try {
			SysDealRecords sysDealRecords = new SysDealRecords();
			// 设置其他属性				
			BusinessMap bm = sysDealRecordsService.create(sysDealRecords);
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
			SysDealRecords sysDealRecords = new SysDealRecords();
			sysDealRecords.setTxSeqNo(IDUtils.genUUID());
			// 设置该属性是否存在				
			// sysDealRecords.setSysDealRecordsName("软件服务部");
			System.out.println(sysDealRecordsService.isExists(sysDealRecords));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			SysDealRecords sysDealRecords = new SysDealRecords();
			// 设置ID
			// sysDealRecords.setTxSeqNo("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = sysDealRecordsService.edit(sysDealRecords);
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
			// System.out.println(sysDealRecordsService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// sysDealRecordsService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			SysDealRecords sysDealRecords = new SysDealRecords();
			// 设置条件
			// sysDealRecords.setSysDealRecordsName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = sysDealRecordsService.search(p, sysDealRecords);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
