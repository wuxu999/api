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
 * 接口分组
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级id，默认为0是顶级
     */
    private Integer parentId;

    private String name;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 是否被删除：0-否 1-是
     */
    @TableLogic
    private Integer isDeleted;

    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String REMARK = "remark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETED = "is_deleted";

}
