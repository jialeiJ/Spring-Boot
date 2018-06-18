package spring.boot.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class FileUploadController {  
	 private static String UPLOADED_FOLDER = "E://temp//";
     /** 
      * 跳转到单个文件上传 
      * 
      * @return 
      */  
     @RequestMapping(value = "/upload", method = RequestMethod.GET)  
     public ModelAndView upload() {  
         return new ModelAndView("/fileUpload");  
     }  
       
     /** 
      * 跳转到多个文件上传 
      * 
      * @return 
      */  
     @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)  
     public ModelAndView batchUpload() {  
         return new ModelAndView("/multiFileUpload");  
     }  
       
     /** 
      * 文件上传具体实现方法（单文件上传） 
      * 
      * @param file 
      * @return 
      */  
     @RequestMapping(value = "/upload", method = RequestMethod.POST)  
     @ResponseBody  
     public String upload(@RequestParam("file") MultipartFile file) {  
         try {  
             if (file.isEmpty()) {  
                 return "文件为空";  
             }  
             // 获取文件名  
             String fileName = file.getOriginalFilename();  
             System.out.println("上传的文件名为：" + fileName);  
             // 获取文件的后缀名  
             String suffixName = fileName.substring(fileName.lastIndexOf("."));  
             System.out.println("文件的后缀名为：" + suffixName);  
        
             String path = UPLOADED_FOLDER + fileName + suffixName;  
       
             File dest = new File(path);  
             // 检测是否存在目录  
             if (!dest.getParentFile().exists()) {  
                 dest.getParentFile().mkdirs();// 新建文件夹  
             }  
             file.transferTo(dest);  
             return "上传成功";  
         } catch (IllegalStateException e) {  
             e.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         }  
         return "上传失败";  
     }  
       
     /** 
      * 多文件上传 
      * 
      * @param request 
      * @return 
      */  
     @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)  
     @ResponseBody  
     public String batchUpload(HttpServletRequest request) {  
         List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");  
         MultipartFile file;  
         BufferedOutputStream stream;  
         for (int i = 0; i < files.size(); ++i) {  
             file = files.get(i);  
             System.out.println(file.getOriginalFilename());
             if (!file.isEmpty()) {  
                 try {  
                      byte[] bytes = file.getBytes();  
                      stream = new BufferedOutputStream(new FileOutputStream(new File(UPLOADED_FOLDER + file.getOriginalFilename())));  
                      stream.write(bytes);  
                      stream.close();  
                  } catch (Exception e) {  
                      stream = null;  
                      return "文件上传失败 " + i + " => " + e.getMessage();  
                  }  
              } else {  
                  return "文件上传失败 " + i + "原因:上传文件为空！";  
              }  
          }  
          return "文件上传成功";  
     }  
}  
