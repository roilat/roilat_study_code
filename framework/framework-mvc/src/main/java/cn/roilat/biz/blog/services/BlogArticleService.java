package cn.roilat.biz.blog.services;

import cn.roilat.biz.blog.model.BlogArticle;
import cn.roilat.biz.blog.po.BlogArticlePO;
import cn.roilat.framework.common.result.CommonPageResult;
import cn.roilat.framework.common.result.CommonResult;

public interface BlogArticleService{
    public CommonResult<BlogArticle> save(BlogArticle blogArticle) ;

    public CommonPageResult<BlogArticle> pageList(BlogArticlePO blogArticlePO);

    public CommonResult<BlogArticle> update(BlogArticle blogArticle);
    
    public CommonResult<BlogArticle> delete(BlogArticle blogArticle);

    public CommonResult<BlogArticle> getById(Integer id);

}
