package com.office.calendaradmin.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    final private AdminService adminService;

    // 관리자 목록 : /admin.css/list
    @GetMapping("/list")
    public String list() {
        log.info("list()");

        String nextPage = "admin/list";

        return nextPage;
    }

    // 관리자 목록 조회
    @GetMapping("/admins")
    @ResponseBody
    public Object admins() {
        log.info("admins()");

        Map<String, Object> resultMap = adminService.admins();

        return resultMap;
    }

    // 관리자 권한 변경
    @PutMapping("/{adminNo}/auth")
    @ResponseBody
    public Object updateAdminAuthority(
            @PathVariable int adminNo,
            @RequestBody Map<String, Integer> request
    ) {
        log.info("updateAdminAuthority()");

        if (request.get("authorityNo") == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("result", null));
        }

        return null;
    }

}
