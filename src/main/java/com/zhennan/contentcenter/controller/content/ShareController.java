package com.zhennan.contentcenter.controller.content;

import com.zhennan.contentcenter.domain.dto.content.ShareDTO;
import com.zhennan.contentcenter.service.content.ShareService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
@Data
public class ShareController {
    private final ShareService shareService;
    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id) {
        System.out.println(id);
        return this.shareService.findById(id);
    }

}
