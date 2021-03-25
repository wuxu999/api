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
 * 接口定义表
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer groupId;

    private String name;

    /**
     * 接口请求方式：1-post 2-get 3-put 4-delete
     */
    private Integer requestType;

    /**
     * 报文格式：1-JSON 2-XML
     */
    private Integer messageType;

    private String requestUrl;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 是否被删除：0-否 1-是
     */
    @TableLogic
    private String isDeleted;

    public static final String ID = "id";

    public static final String GROUP_ID = "group_id";

    public static final String NAME = "name";

    public static final String REQUEST_TYPE = "request_type";

    public static final String MESSAGE_TYPE = "message_type";

    public static final String REQUEST_URL = "request_url";

    public static final String REMARK = "remark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETED = "is_deleted";

}
