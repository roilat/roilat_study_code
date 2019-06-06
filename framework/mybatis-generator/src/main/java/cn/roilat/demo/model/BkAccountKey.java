package cn.roilat.demo.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`bk_account`")
public class BkAccountKey implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }
}