/*
 * BusiCodeServiceImplTest.java created on 2016-08-17 下午 16:19:15 by roilatD
 */
package com.hansy.dataservice.busi.service.impl;

import javax.annotation.Resource;
import com.hansy.dataservice.busi.entity.BusiCode;
import com.hansy.dataservice.busi.service.BusiCodeService;
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
 * 业务参数设置 Service 接口测试类
 * TODO javadoc for com.hansy.dataservice.busi.service.impl.BusiCodeServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class BusiCodeServiceImplTest {

	@Resource(name="busiCodeService")
	private BusiCodeService busiCodeService;
	
	@Test
	public void testCreate() {
		try {
			BusiCode busiCode = new BusiCode();
			// 设置其他属性				
			BusinessMap bm = busiCodeService.create(busiCode);
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
			BusiCode busiCode = new BusiCode();
			busiCode.setBizTypeCode(IDUtils.genUUID());
			// 设置该属性是否存在				
			// busiCode.setBusiCodeName("软件服务部");
			System.out.println(busiCodeService.isExists(busiCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			BusiCode busiCode = new BusiCode();
			// 设置ID
			// busiCode.setBizTypeCode("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = busiCodeService.edit(busiCode);
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
			// System.out.println(busiCodeService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// busiCodeService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			BusiCode busiCode = new BusiCode();
			// 设置条件
			// busiCode.setBusiCodeName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = busiCodeService.search(p, busiCode);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
