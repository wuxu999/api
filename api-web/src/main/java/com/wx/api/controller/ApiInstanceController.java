package com.wx.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.wx.api.service.ApiInstanceService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 接口实例 前端控制器
 * </p>
 *
 * @author wuxu
 * @date 2021-03-25
 */
@RestController
@RequestMapping("/apiInstance")
public class ApiInstanceController {

    @Autowired
    private ApiInstanceService apiInstanceService;

}
