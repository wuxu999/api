package com.wx.api.service.impl;

import com.wx.api.entity.ApiGroup;
import com.wx.api.service.mapper.ApiGroupMapper;
import com.wx.api.service.ApiGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 接口分组 服务实现类
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Service
public class ApiGroupServiceImpl extends ServiceImpl<ApiGroupMapper, ApiGroup> implements ApiGroupService {

    @Autowired
    private ApiGroupMapper apiGroupMapper;

}
