package com.wx.api.service.impl;

import com.wx.api.entity.ApiTemplateDefinition;
import com.wx.api.service.mapper.ApiTemplateDefinitionMapper;
import com.wx.api.service.ApiTemplateDefinitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 接口模板定义 服务实现类
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Slf4j
@Service
public class ApiTemplateDefinitionServiceImpl extends ServiceImpl<ApiTemplateDefinitionMapper, ApiTemplateDefinition> implements ApiTemplateDefinitionService {

    @Autowired
    private ApiTemplateDefinitionMapper apiTemplateDefinitionMapper;

}
