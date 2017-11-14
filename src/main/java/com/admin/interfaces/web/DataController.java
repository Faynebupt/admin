package com.admin.interfaces.web;

import com.admin.application.DataService;
import com.admin.application.UserService;
import com.admin.domain.modle.Data;
import com.admin.interfaces.facade.assembler.UserAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author Jonsy
 *
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    protected UserService userService;
    @Autowired
    protected DataService dataService;

    public static final Logger logger = LoggerFactory.getLogger(DataController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("list",UserAssembler.domainToDto(dataService.list()));
        return "data/list";
    }
    @RequestMapping(value = "/list2" )
    public String list2(Model model){
        model.addAttribute("list",UserAssembler.domainToDto(dataService.list()));
        return "data/list2";
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success(@RequestParam Data data){
//        这是一个测试data变量
        Data data1=new Data();
        data1.setContent("test");
        dataService.save(data);
        return "data/success";
    }
}
