package com.wx.api.service.impl;

import com.wx.api.entity.ApiInstance;
import com.wx.api.service.mapper.ApiInstanceMapper;
import com.wx.api.service.ApiInstanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 接口实例 服务实现类
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Slf4j
@Service
public class ApiInstanceServiceImpl extends ServiceImpl<ApiInstanceMapper, ApiInstance> implements ApiInstanceService {

    @Autowired
    private ApiInstanceMapper apiInstanceMapper;

}
