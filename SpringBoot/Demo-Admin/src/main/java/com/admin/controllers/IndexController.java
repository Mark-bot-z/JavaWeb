package com.admin.controllers;

import com.admin.exceptions.DataNotFindException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

//@SuppressWarnings("unchecked")
@Controller
@Slf4j
public class IndexController {

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password, Model model, HttpSession session) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "账号或者密码错误");
            return "forward:/loginPage";
        }
        session.setAttribute("status", true);
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpSession session) {
        if ((Boolean) session.getAttribute("status")) {
            return "main";
        }
        return "error/5xx";
    }

    @RequestMapping(value = "/getUploadPage", method = RequestMethod.GET)
    public String getUploadPage() {
        return "upload";
    }

    //单体文件和多文件上传
    @RequestMapping(value = "/upload")
    public void upload(@RequestPart("fileSingle") MultipartFile fileSingle,
                       @RequestPart("fileMany") MultipartFile[] fileMany) throws Exception {
        log.info("单文件：{} ，多文件：{}", fileSingle.getOriginalFilename(), fileMany.length);
        File f = new File("D:\\FileUploads\\images\\" + dotSuffix(fileSingle));
        creatFile(f);
        fileSingle.transferTo(f);
        if (fileMany.length > 0) {
            for (MultipartFile part : fileMany) {
                f = new File("D:\\FileUploads\\musics\\" + dotSuffix(part));
                creatFile(f);
                part.transferTo(f);
            }
        }
    }

    String dotSuffix(MultipartFile file) {
        String name = file.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        assert name != null;
        return s + name.substring(name.indexOf('.'));
    }

    void creatFile(File f) throws Exception {
        if (!f.exists()) {
//            if (f.mkdirs()) {//有目录才能创建文件
            log.info("文件" + f.getName() + "创建：{}", f.createNewFile());
//            }
        }
    }

    @RequestMapping(value = "/testException")
    public void testException(){
        throw new DataNotFindException("无法找到数据");
    }
}
