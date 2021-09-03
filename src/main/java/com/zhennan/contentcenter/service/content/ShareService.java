package com.zhennan.contentcenter.service.content;


import com.zhennan.contentcenter.dao.content.ShareMapper;
import com.zhennan.contentcenter.domain.dto.content.ShareDTO;
import com.zhennan.contentcenter.domain.dto.user.UserDTO;
import com.zhennan.contentcenter.domain.entity.content.Share;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    public ShareDTO findById(Integer id) {
        Share share = this.shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();



        //restTemptlate已经启用Ribbon，所以"user-center"这部分自动用来查找负载服务器
        UserDTO userDTO = this.restTemplate.getForObject("http://user-center/users/{userId}", UserDTO.class,userId);
        ShareDTO shareDTO = new ShareDTO();

        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());

        return shareDTO;
    }
//测试用
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //用http的get方法请求，并返回一个对象
        Object str = restTemplate.getForObject("http://localhost:8080/users/1", Object.class);
        System.out.println(str);



    }
}
