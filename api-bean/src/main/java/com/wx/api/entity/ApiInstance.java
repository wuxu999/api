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
 * 接口实例
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String code;

    /**
     * 接口定义id
     */
    private Integer defId;

    /**
     * 是否启用mock：0-否 1-是
     */
    private Integer isMocked;

    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String DEF_ID = "def_id";

    public static final String IS_MOCKED = "is_mocked";

}
