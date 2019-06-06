package cn.roilat.framework.core.controller;

import org.springframework.beans.factory.annotation.Autowired;

import cn.roilat.framework.core.mvc.UrlMapping;
import cn.roilat.framework.core.page.PageHelper;
import cn.roilat.framework.core.service.BaseService;
import cn.roilat.framework.result.ResponseResult;

public abstract class BaseController<T> {
	@Autowired
	private BaseService<T> baseService;
	
	@UrlMapping("/save")
	public ResponseResult save(T entity){
		int i = 0;
		try {
			i = baseService.save(entity);
			if(i == 0){
				return ResponseResult.fail();
			}else{
				return ResponseResult.succ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	
	@UrlMapping("/update")
	public ResponseResult update(T entity){
		int i = 0;
		try {
			i = baseService.update(entity);
			if(i == 0){
				return ResponseResult.fail();
			}else{
				return ResponseResult.succ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	@UrlMapping("/insertOrUpdate")
	public ResponseResult insertOrUpdate(T entity){
		try {
			int i = baseService.insertOrUpdate(entity);
			if(i == 0){
				return ResponseResult.fail("操作失败");
			}else{
				return ResponseResult.succ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	
	@UrlMapping("/delete")
	public ResponseResult delete(T entity){
		try {
			baseService.get(entity);
			int i = baseService.delete(entity);
			if(i == 0){
				return ResponseResult.fail("删除失败");
			}else{
				return ResponseResult.succ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	@UrlMapping("/deleteByPrimaryKey")
	public ResponseResult deleteByPrimaryKey(T entity){
		try {
			baseService.get(entity);
			int i = baseService.deleteByPrimaryKey(entity);
			if(i == 0){
				return ResponseResult.fail("删除失败");
			}else{
				return ResponseResult.succ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	

	@UrlMapping("/getAll")
	public ResponseResult getAll(){
		try {
			return ResponseResult.succ(baseService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	
	@UrlMapping("/getDataByPrimaryKey")
	public ResponseResult getDataByPrimaryKey(T entity){
		try {
			return ResponseResult.succ(baseService.getByPrimaryKey(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}
	
	@UrlMapping("/get")
	public ResponseResult get(T entity){
		try {
			return ResponseResult.succ(baseService.get(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseResult.fail();
	}

	protected void initPageHelper(PageHelper<T> pageHelper, T entity){
		if (pageHelper.getPageSize() == null) {
			pageHelper.setPageSize(10);
		}
		if (pageHelper.getCurrentPage() == null) {
			pageHelper.setCurrentPage(1);
		}
		int startIndex = (pageHelper.getCurrentPage() - 1) * pageHelper.getPageSize();
		pageHelper.setStartIndex(startIndex);
		pageHelper.setQueryObj(entity);
	}
}
