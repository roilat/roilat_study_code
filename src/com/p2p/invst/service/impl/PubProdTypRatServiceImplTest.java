/*
 * PubProdTypRatServiceImplTest.java created on 2016-06-14 下午 16:48:55 by roilatD
 */
package com.p2p.invst.service.impl;

import javax.annotation.Resource;
import com.p2p.invst.entity.PubProdTypRat;
import com.p2p.invst.service.PubProdTypRatService;
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
 * pub_prod_typ_rat Service 接口测试类
 * TODO javadoc for com.p2p.invst.service.impl.PubProdTypRatServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class PubProdTypRatServiceImplTest {

	@Resource(name="pubProdTypRatService")
	private PubProdTypRatService pubProdTypRatService;
	
	@Test
	public void testCreate() {
		try {
			PubProdTypRat pubProdTypRat = new PubProdTypRat();
			// 设置其他属性				
			BusinessMap bm = pubProdTypRatService.create(pubProdTypRat);
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
			PubProdTypRat pubProdTypRat = new PubProdTypRat();
			pubProdTypRat.setProdTyp(IDUtils.genUUID());
			// 设置该属性是否存在				
			// pubProdTypRat.setPubProdTypRatName("软件服务部");
			System.out.println(pubProdTypRatService.isExists(pubProdTypRat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			PubProdTypRat pubProdTypRat = new PubProdTypRat();
			// 设置ID
			// pubProdTypRat.setProdTyp("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = pubProdTypRatService.edit(pubProdTypRat);
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
			// System.out.println(pubProdTypRatService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// pubProdTypRatService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			PubProdTypRat pubProdTypRat = new PubProdTypRat();
			// 设置条件
			// pubProdTypRat.setPubProdTypRatName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = pubProdTypRatService.search(p, pubProdTypRat);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
