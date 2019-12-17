package cn.roilat.biz.blog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.roilat.biz.blog.dbo.BlogArticleDO;
import cn.roilat.biz.blog.model.BlogArticle;
import tk.mybatis.mapper.common.Mapper;

public interface BlogArticleMapper extends Mapper<BlogArticle>{
    /**
     * 
     */
    int delete(BlogArticle blogArticle);

    /**
     * 
     */
    int insert(BlogArticle blogArticle);

    /**
     * 
     * 也可以使用@Select("select 1 from dual")
     */
    long pageCount(BlogArticleDO blogArticleDO);

    /**
     * 
     */
    List<BlogArticle> pageList(BlogArticleDO blogArticleDO);

    /**
     * 
     */
    int update(@Param("record") BlogArticle blogArticle,@Param("param") BlogArticleDO blogArticleDO);

	boolean existsById(Integer id);

}