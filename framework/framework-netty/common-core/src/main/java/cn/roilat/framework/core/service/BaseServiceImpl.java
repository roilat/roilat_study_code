package cn.roilat.framework.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private Mapper<T> mapper;
	@Override
	public int save(T entity) throws Exception {
		return mapper.insertSelective(entity);
	}

	@Override
	public int update(T entity) throws Exception {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	@Override
	public int insertOrUpdate(T entity) throws Exception{
		T t = mapper.selectByPrimaryKey(entity);
		if(t == null){
			return save(entity);
		}
		return update(entity);
	}
	@Override
	public int delete(T entity) throws Exception{
		return mapper.delete(entity);
	}
	
	@Override
	public int deleteByPrimaryKey(Object entity) throws Exception{
		return mapper.deleteByPrimaryKey(entity);
	}
	@Override
	public List<T> getAll() throws Exception{
		return mapper.selectAll();
	}
	@Override
	public List<T> get(T entity) throws Exception{
		return mapper.select(entity);
	}
	
	@Override
	public T getOne(T entity) throws Exception{
		 List<T> list = mapper.select(entity);
		 if(list != null && list.size() == 1){
			 return list.get(0);
		 }
		 return null;
	}
	
	@Override
	public T getByPrimaryKey(Object entity) throws Exception{
		return mapper.selectByPrimaryKey(entity);
	}
	@Override
	public int getCount(T entity) throws Exception{
		return mapper.selectCount(entity);
	}
}
