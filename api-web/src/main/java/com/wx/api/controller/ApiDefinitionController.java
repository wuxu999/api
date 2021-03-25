package com.wx.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.wx.api.service.ApiDefinitionService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 接口定义表 前端控制器
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@RestController
@RequestMapping("/apiDefinition")
public class ApiDefinitionController {

    @Autowired
    private ApiDefinitionService apiDefinitionService;

}
