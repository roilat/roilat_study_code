/*
 * PubProdSellVoServiceImplTest.java created on 2016-06-04 下午 15:00:23 by roilatD
 */
package com.p2p.invst.service.impl;

import javax.annotation.Resource;
import com.p2p.invst.entity.PubProdSellVo;
import com.p2p.invst.service.PubProdSellVoService;
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
 * 产品销售表 Service 接口测试类
 * TODO javadoc for com.p2p.invst.service.impl.PubProdSellVoServiceImplTest
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-04
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })  
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})  
public class PubProdSellVoServiceImplTest {

	@Resource(name="pubProdSellVoService")
	private PubProdSellVoService pubProdSellVoService;
	
	@Test
	public void testCreate() {
		try {
			PubProdSellVo pubProdSellVo = new PubProdSellVo();
			// 设置其他属性				
			BusinessMap bm = pubProdSellVoService.create(pubProdSellVo);
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
			PubProdSellVo pubProdSellVo = new PubProdSellVo();
			pubProdSellVo.setProdNo(IDUtils.genUUID());
			// 设置该属性是否存在				
			// pubProdSellVo.setPubProdSellVoName("软件服务部");
			System.out.println(pubProdSellVoService.isExists(pubProdSellVo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEdit() {
		try {
			PubProdSellVo pubProdSellVo = new PubProdSellVo();
			// 设置ID
			// pubProdSellVo.setProdNo("B0AA8CDED0814A47869CAE89CA87670B");
			// 设置其他属性	
			BusinessMap bm = pubProdSellVoService.edit(pubProdSellVo);
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
			// System.out.println(pubProdSellVoService.getById("20D0DCEBB57149D59684ABBDCA54102F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			// 设置ID
			// pubProdSellVoService.delete("9E61BD4591074164A201C9E6D493E796");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			PubProdSellVo pubProdSellVo = new PubProdSellVo();
			// 设置条件
			// pubProdSellVo.setPubProdSellVoName("软件服务部");
			Pager p = new Pager();
			p.setCurrentPage(1);
			Pager pager = pubProdSellVoService.search(p, pubProdSellVo);
			System.out.println(pager.getDataList());
			System.out.println(pager.getTotal());
			System.out.println(pager.getTotalPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
