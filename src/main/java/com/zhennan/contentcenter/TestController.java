package com.zhennan.contentcenter;


import com.zhennan.contentcenter.dao.content.ShareMapper;

import com.zhennan.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public List<Share> testInsert(){
//        1.插入
            Share share = new Share();
            share.setCreateTime(new Date());
            share.setUpdateTime(new Date());
            share.setTitle("xxx");
            share.setCover("xxx");
            share.setAuthor("Zhennan");
            share.setBuyCount(1);
            this.shareMapper.insertSelective(share);

//        2。查询
            List<Share> shares = this.shareMapper.selectAll();
        return shares;

    }

//    测试服务发现：微服务A总能找到注册了的微服务B
    @GetMapping("test2")
    public List<String> test2(){
//        service id == nacos client name
        return this.discoveryClient.getServices();


    }
}
