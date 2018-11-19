package com.kaige.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaige.model.User;
import com.kaige.response.ResponseDto;
import com.kaige.service.UserService;
import com.kaige.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;


@Controller
public class HrmController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String loginname,String password){

        ModelAndView mv = new ModelAndView();

        if(loginname == null || password == null){

            mv.addObject("mes","用户名或密码不能为空");
            mv.setViewName("../../login");
            return mv;
        }

        User user= userService.selectUserByLoginNameAndPassWord(loginname, password);

        if(user != null){
            mv.addObject("mes","OK");
            mv.setViewName("index");
            return mv;
        }else{

            mv.addObject("mes","用户名或密码错误");
            mv.setViewName("../../login");
            return mv;

        }

    }





    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello，world");

        return "hello,world";
    }



    @RequestMapping("/showusers")
    @ResponseBody
    public Map<String,Object> showUsers(Integer pagenum,Integer pagesize){

        PageHelper.startPage(pagenum,pagesize);

       List<User>  users = userService.getUsers();

       PageInfo<User> p = new PageInfo<User>(users);


       Map<String,Object> map = new HashMap<>();

       map.put("users",users);

       map.put("page",p);

       return map;
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public ResponseDto addUser(@RequestParam(required = true) String username,
                               @RequestParam Integer state,
                               @RequestParam String loginname,
                               @RequestParam String password){

                User user = new User();
                user.setLoginname(loginname);
                user.setCreatedate(new Date());
                user.setStatus(state);
                user.setPassword(password);
                user.setUsername(username);

                int issuccess =userService.addUser(user);

                ResponseDto responseDto = new ResponseDto();

                if(issuccess >0){

                    responseDto.setSuccess(true);

                }else {

                    responseDto.setSuccess(false);
                }

                return responseDto;

    }

    @RequestMapping("/savedocument")
    @ResponseBody
    public String saveDocument(@RequestParam("file") CommonsMultipartFile file,
                               @RequestParam("documenttitle") String documenttitle,
                               @RequestParam("documentdes") String documentdes,
                               HttpServletRequest request){

        System.out.println(documentdes);

        System.out.println(documenttitle);

        System.out.println(file.getOriginalFilename());

        System.out.println(file.getSize());

        String path1 = request.getServletPath();

        String path2 = request.getSession().getServletContext().getContextPath();

        String path3 = request.getSession().getServletContext().getRealPath("/upload/");

        File file1 = new File(path3);

        if(!file1.exists()){

            file1.mkdirs();
        }

        String filename = file.getOriginalFilename();


        FileUtil.saveFileByByte(file.getBytes(),path3,filename);


        return "hello";
    }



}
