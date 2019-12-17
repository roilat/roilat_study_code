package cn.roilat.demo.dao;

import cn.roilat.demo.model.BkAccount;
import cn.roilat.demo.model.BkAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BkAccountMapper extends Mapper<BkAccount> {
    long countByExample(BkAccountExample example);

    int deleteByExample(BkAccountExample example);

    List<BkAccount> selectByExample(BkAccountExample example);

    int updateByExampleSelective(@Param("record") BkAccount record, @Param("example") BkAccountExample example);

    int updateByExample(@Param("record") BkAccount record, @Param("example") BkAccountExample example);
}