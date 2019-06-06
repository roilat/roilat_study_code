package cn.roilat.biz.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.roilat.biz.blog.dbo.BlogArticleDO;
import cn.roilat.biz.blog.mappers.BlogArticleMapper;
import cn.roilat.biz.blog.model.BlogArticle;
import cn.roilat.biz.blog.po.BlogArticlePO;
import cn.roilat.biz.blog.services.BlogArticleService;
import cn.roilat.framework.common.enums.CommonRecordStateEnum;
import cn.roilat.framework.common.result.CommonPageResult;
import cn.roilat.framework.common.result.CommonResult;
import cn.roilat.framework.service.BaseService;


@Service
public class BlogArticleServiceImpl extends BaseService<BlogArticle> implements BlogArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    public CommonResult<BlogArticle> save(BlogArticle blogArticle) {
        CommonResult<BlogArticle> result = new CommonResult<BlogArticle>();
        blogArticle.setState(CommonRecordStateEnum.NORMAL.getCode());
        doSave(blogArticle);
        result.setData(blogArticle);
        return result;

    }

    @Override
    public CommonPageResult<BlogArticle> pageList(BlogArticlePO blogArticlePO) {
        CommonPageResult<BlogArticle> result = new CommonPageResult<BlogArticle>();
        BlogArticleDO blogArticleDO = new BlogArticleDO();
        blogArticleDO.buildCriteria(blogArticlePO);
        long total = blogArticleMapper.pageCount(blogArticleDO);
        if (total > 0) {
            List<BlogArticle> list = blogArticleMapper.pageList(blogArticleDO);
            result.setData(list);
            result.fillPageInfo(total, blogArticlePO.getCurrentPage(), blogArticlePO.getPageSize());
        }
        return result;
    }

    @Override
    public CommonResult<BlogArticle> update(BlogArticle blogArticle) {
        CommonResult<BlogArticle> result = new CommonResult<BlogArticle>();
        if(blogArticleMapper.existsById(blogArticle.getId())) {
            result.setSuccess(false);
            result.setMsg("数据不存在！");
            return result;
        }
        blogArticle.setUpdateDt(new Date());
        blogArticleMapper.insert(blogArticle);
        result.setData(blogArticle);
        return result;
    }

    @Override
    public CommonResult<BlogArticle> delete(BlogArticle blogArticle) {
        CommonResult<BlogArticle> result = new CommonResult<BlogArticle>();
        if(blogArticleMapper.existsById(blogArticle.getId())) {
            result.setSuccess(false);
            result.setMsg("数据不存在！");
            return result;
        }
        blogArticle.setState(CommonRecordStateEnum.DELETE.getCode());
        
        blogArticleMapper.delete(blogArticle);
        result.setData(blogArticle);
        return result;
    }

    @Override
    public CommonResult<BlogArticle> getById(Integer id) {
        CommonResult<BlogArticle> result = new CommonResult<>();
        BlogArticle blogArticle = blogArticleMapper.selectById(id);
        result.setData(blogArticle);
        result.buildResult(blogArticle != null);
        return result;
    }
}
