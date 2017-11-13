package com.admin.interfaces.web;

import com.admin.application.DataService;
import com.admin.application.MenuService;
import com.admin.application.UserService;
import com.admin.domain.modle.User;
import com.admin.interfaces.facade.assembler.UserAssembler;
import com.admin.interfaces.facade.commondobject.ProfileCommand;
import com.admin.interfaces.facade.commondobject.UserCommond;
import com.admin.security.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public String success(Model model){
//        model.addAttribute("messages",UserAssembler.domainToDto(dataService.list()));
        return "data/success";
    }
}
