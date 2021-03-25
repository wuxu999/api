package com.wx.api.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiInstanceTemplateRel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer instanceId;

    /**
     * 模板定义id
     */
    private Integer tplDefId;

    /**
     * 同类型，数字越大优先级越低
     */
    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 是否删除：0-否 1-是
     */
    @TableLogic
    private Integer isDeleted;

    public static final String ID = "id";

    public static final String INSTANCE_ID = "instance_id";

    public static final String TPL_DEF_ID = "tpl_def_id";

    public static final String SORT = "sort";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETED = "is_deleted";

}
