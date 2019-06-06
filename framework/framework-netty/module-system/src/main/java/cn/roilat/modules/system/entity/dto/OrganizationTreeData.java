package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class OrganizationTreeData implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String label;
	
	private Integer status;
	
	private Integer pid;
	
	private List<OrganizationTreeData> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<OrganizationTreeData> getChildren() {
//		if (children == null) {
//			children = Lists.newArrayList();	
//		}
		return children;
	}
	
	public List<OrganizationTreeData> getChildrenBak() {
		if (children == null) {
			children = Lists.newArrayList();	
		}
		return children;
	}

	public void setChildren(List<OrganizationTreeData> children) {
		this.children = children;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
