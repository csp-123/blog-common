package com.csp.onepic.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.csp.onepic.enums.TypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-01-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("picture")
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 图片名称
     */
    @TableField("pic_source_name")
    private String picSourceName;

    /**
     * 图片后缀
     */
    @TableField("pic_ext")
    private String picExt;

    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 图片类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 扫描入库时间
     */
    @TableField("scan_time")
    private Date scanTime;

    public static Picture convert(File file) {
        if (file.exists() && file.isFile()) {
            //aab.jpg;
            String fileName = file.getName();
            int index = fileName.indexOf(".");
            String ext = fileName.substring(index + 1);
            String type = fileName.substring(fileName.indexOf("_") + 1, fileName.indexOf("."));
            TypeEnum typeEnum = TypeEnum.find(Integer.valueOf(type));
            Picture picture = new Picture();
            picture.setPicExt(ext)
                    .setScanTime(new Date())
                    .setIsDelete(0)
                    .setPicSourceName(fileName)
                    .setType(Objects.nonNull(typeEnum) ? typeEnum.getType() : TypeEnum.ALL.getType());
            return picture;
        } else {
            return null;
        }
    }
}
