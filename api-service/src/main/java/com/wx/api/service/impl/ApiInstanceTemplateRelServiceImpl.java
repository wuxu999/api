package com.wx.api.service.impl;

import com.wx.api.entity.ApiInstanceTemplateRel;
import com.wx.api.service.mapper.ApiInstanceTemplateRelMapper;
import com.wx.api.service.ApiInstanceTemplateRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@Service
public class ApiInstanceTemplateRelServiceImpl extends ServiceImpl<ApiInstanceTemplateRelMapper, ApiInstanceTemplateRel> implements ApiInstanceTemplateRelService {

    @Autowired
    private ApiInstanceTemplateRelMapper apiInstanceTemplateRelMapper;

}
