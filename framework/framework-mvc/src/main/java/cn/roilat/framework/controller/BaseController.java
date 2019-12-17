package cn.roilat.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController<T> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * protected void initPageHelper(PageHelper<T> pageHelper, T entity) { if
	 * (pageHelper.getPageSize() == null) { pageHelper.setPageSize(10); } if
	 * (pageHelper.getCurrentPage() == null) { pageHelper.setCurrentPage(1); } int
	 * startIndex = (pageHelper.getCurrentPage() - 1) * pageHelper.getPageSize();
	 * pageHelper.setStartIndex(startIndex); pageHelper.setQueryObj(entity); }
	 */
}
