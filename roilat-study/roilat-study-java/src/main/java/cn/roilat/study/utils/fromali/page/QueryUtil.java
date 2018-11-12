/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.page;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ѯ����
 * 
 * @author xuhua.liu
 * @version $Id: QueryUtil.java, v 0.1 2014-4-21 ����05:08:19 xuhua.liu Exp $
 */
public class QueryUtil {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryUtil.class);

    /**
     * ������ϸ������ҳ��С����ҳ��
     * ����ϸ��������ҳ��СС�ڵ���0ʱ���÷�������0
     *
     * @param totalCount    ��ϸ����
     * @param pageSize      ҳ��С
     * @return              ������ҳ��
     */
    public static int getTotalPages(long totalCount, int pageSize) {

        if (totalCount <= 0 || pageSize <= 0) {
            throw new IllegalArgumentException("��¼������ҳ��С����Ϊ����");
        }

        return (int) (totalCount + pageSize - 1) / pageSize;
    }

    /**
     * ����ҳ�ż�ҳ��С��ÿ�ʼ�к��Թ���ҳ��ѯʹ��
     * 
     * @param pageNum   ҳ��
     * @param pageSize  ҳ��С
     * @return          ��ʼ�к�
     */
    public static int getStartRow(int pageNum, int pageSize) {

        if (pageNum <= 0) {
            return 0;
        }

        return (pageNum - 1) * pageSize;
    }

    /**
     * ���б���з���,�Ա��ڲ�ѯʱ������ã���˵���ʵ��500��
     * 
     * @param <T>              ����
     * @param dataList         ��Ҫ����ļ����б�
     * @return List<List<T>>   �����Ľ��    
     */
    public static <T> List<List<T>> splitList(List<T> dataList) {

        List<List<T>> result = new ArrayList<List<T>>();
        int index = 1;
        for (T basicCode : dataList) {
            if (index == 1) {
                result.add(new ArrayList<T>());
            }
            result.get(result.size() - 1).add(basicCode);
            index++;
            if (index > 500) {
                index = 1;
            }
        }

        return result;
    }
}
