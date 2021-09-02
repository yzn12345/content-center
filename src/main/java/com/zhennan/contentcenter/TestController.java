package com.zhennan.contentcenter;


import com.zhennan.contentcenter.dao.content.ShareMapper;

import com.zhennan.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ShareMapper shareMapper;
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
}
