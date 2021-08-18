package com.wx.api.service.impl;

import com.wx.api.entity.ApiDefinition;
import com.wx.api.service.mapper.ApiDefinitionMapper;
import com.wx.api.service.ApiDefinitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 接口定义表 服务实现类
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Slf4j
@Service
public class ApiDefinitionServiceImpl extends ServiceImpl<ApiDefinitionMapper, ApiDefinition> implements ApiDefinitionService {

    @Autowired
    private ApiDefinitionMapper apiDefinitionMapper;

}
