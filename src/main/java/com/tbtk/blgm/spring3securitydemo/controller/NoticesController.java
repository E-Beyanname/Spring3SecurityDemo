package com.tbtk.blgm.spring3securitydemo.controller;

import com.tbtk.blgm.spring3securitydemo.model.Notice;
import com.tbtk.blgm.spring3securitydemo.repository.NoticeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null ) {
            return notices;
        }else {
            return null;
        }
    }
}
