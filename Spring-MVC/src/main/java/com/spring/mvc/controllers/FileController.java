package com.spring.mvc.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mark-Z
 * @version 0.0.1
 */
@Controller
@RequestMapping(value = "/File")
public class FileController {

    @RequestMapping(value = "/index")
    public String index(){
        return "file/do";
    }

    //  文件下载 1
    //  使用ResponseEntity实现下载文件的功能
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> downloadFile(HttpSession session, String type, String fileName) {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/music/" + fileName.concat(".") + type);
        //创建输入流
        ResponseEntity<byte[]> responseEntity = null;
        try (InputStream is = new FileInputStream(realPath)) {
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=" + fileName.concat(".") + type);
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
            //关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    /*
    * 文件上传要求form表单的请求方式必须为post，并且添加属性enctype="multipart/form-data"
    * SpringMVC中将上传的文件封装到MultipartFile对象中，通过此对象可以获取文件相关信息
    * */
    //文件上传 2
    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public String up(HttpSession session , MultipartFile music) throws Exception{
        String filename = music.getOriginalFilename();
//        可以加入uuid重命名
        File file = new File(session.getServletContext().getRealPath("/static/music/" + filename));
        if (!file.exists()){
            if (!file.createNewFile()) {
                throw new Exception();
            }
        }
        music.transferTo(file);
        return "redirect:/File/say";
    }

    @RequestMapping(value = "/say" , produces = "text/html; charset=utf-8")
    @ResponseBody
    public String say(){
        return "文件上传成功";
    }

//    enum FileType{
//        MP3(".mp3"),
//        jpg(".jpg"),
//        png(".png");
//
//        String typeName;
//
//        FileType(String typeName){
//            this.typeName = typeName;
//        }
//
//        public String getTypeName() {
//            return typeName;
//        }
//    }

}
