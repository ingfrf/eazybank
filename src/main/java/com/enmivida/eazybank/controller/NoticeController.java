package com.enmivida.eazybank.controller;

import com.enmivida.eazybank.model.Notice;
import com.enmivida.eazybank.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notices")
    //@CrossOrigin(origins = "http://192.168.1.111:8060")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices)
                    ;
        }
        return null;
    }
}
