package com.wx.api.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 接口模板定义
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiTemplateDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    /**
     * 模板类型：1-param 2-interceptor 3-sql 4-header 5-body 6-mock
     */
    private Integer type;

    private String content;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String CONTENT = "content";

}
