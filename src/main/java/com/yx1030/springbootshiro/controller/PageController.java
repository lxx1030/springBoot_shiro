package com.yx1030.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    /**
     * @Description: 跳转到index.html页面
     * @Param: [mav]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    /**
     * @Description: 跳转到student.html页面
     * @Param: [mav]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    @RequestMapping("/student")
    public ModelAndView student(ModelAndView mav) {
        mav.setViewName("student");
        return mav;
    }


}
