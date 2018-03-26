/*
 * MarBlackListServiceImplTest.java created on 2016-08-18 下午 14:03:53 by roilatD
 */
package com.hansy.dataservice.busi1.service.impl;

import javax.annotation.Resource;
import com.hansy.dataservice.busi1.entity.MarBlackList;
import com.hansy.dataservice.busi1.service.MarBlackListService;
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
 * 商户黑名单 Service 接口测试类
 * TODO javadoc for com.hansy.dataservice.busi1.service.impl.MarBlackListServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-18
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class MarBlackListServiceImplTest {

	@Resource(name="marBlackListService")
	private MarBlackListService marBlackListService;
	
	@Test
	public void testCreate() {
		try {
			MarBlackList marBlackList = new MarBlackList();
			// 设置其他属性				
			BusinessMap bm = marBlackListService.create(marBlackList);
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
			MarBlackList marBlackList = new MarBlackList();
			marBlackList.setMarName(IDUtils.genUUID());
			// 设置该属性是否存在				
			// marBlackList.setMarBlackListName("软件服务部");
			System.out.println(marBlackListService.isExists(marBlackList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			MarBlackList marBlackList = new MarBlackList();
			// 设置ID
			// marBlackList.setMarName("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = marBlackListService.edit(marBlackList);
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
			// System.out.println(marBlackListService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// marBlackListService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			MarBlackList marBlackList = new MarBlackList();
			// 设置条件
			// marBlackList.setMarBlackListName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = marBlackListService.search(p, marBlackList);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
