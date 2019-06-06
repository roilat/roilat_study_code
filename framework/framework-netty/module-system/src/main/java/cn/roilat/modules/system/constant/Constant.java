package cn.roilat.modules.system.constant;

import cn.roilat.modules.system.entity.dto.UserOrganizationDto;

public class Constant {
	public static final ThreadLocal<String> userName = new ThreadLocal<String>();
	public static final ThreadLocal<String> trueName = new ThreadLocal<String>();
	public static final ThreadLocal<Integer> userId = new ThreadLocal<Integer>();
	public static final ThreadLocal<UserOrganizationDto> userInfo = new ThreadLocal<UserOrganizationDto>();
	public static final ThreadLocal<Integer> orgId = new ThreadLocal<Integer>();
	public static final ThreadLocal<String> orgName = new ThreadLocal<String>();
	public static final ThreadLocal<Integer> deptId = new ThreadLocal<Integer>();
	public static final ThreadLocal<String> deptName = new ThreadLocal<String>();
}
