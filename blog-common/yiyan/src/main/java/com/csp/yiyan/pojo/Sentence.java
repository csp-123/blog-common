package com.csp.yiyan.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-01-10
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sentence")
public class Sentence implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("id")
    private Integer id;

    /**
     * 语句
     */
    @TableField("sentence")
    private String sentence;

    /**
     * 分类
     */
    @TableField("type")
    private String type;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否删除
     */
    @TableField("is_delete")
    private Byte isDelete;

    /**
     * 来源
     */
    @TableField("source")
    private String source;
}
