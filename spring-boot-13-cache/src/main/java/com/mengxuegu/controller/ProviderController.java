package com.mengxuegu.controller;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/31 13:56
 *
 */

import com.mengxuegu.entities.Provider;
import com.mengxuegu.service.ProviderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.jnlp.PrintService;

@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @ApiOperation(value = "查询提供商信息",notes = "注意事项",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "pid",value = "提供商id",dataType = "int",paramType = "path")})
    @GetMapping("provider/getProvider/{pid}")
    public Provider getProvider(@PathVariable("pid") Integer pid){
        Provider provider = providerService.getProviderByPid(pid);
        return provider;
    }


    @PostMapping("/addProvider")
    public Integer addProvider(Provider provider){
        Integer integer = providerService.addProvider(provider);
        return integer;
    }


    @PutMapping("/updateProvider")
    public Integer updateProvider(Provider provider){
        Integer integer = providerService.updateProvider(provider);
        return integer;
    }


    @DeleteMapping("/deleteProvider/{pid}")
    public Integer deleteProvider(@PathVariable("pid") Integer pid){
        Integer size = providerService.deleteProvider(pid);
        return size;
    }
}
