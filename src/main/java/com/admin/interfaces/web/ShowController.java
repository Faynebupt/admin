package com.admin.interfaces.web;

import com.admin.application.DataService;
import com.admin.application.UserService;
import com.admin.interfaces.facade.assembler.UserAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Jonsy
 *
 */
@Controller
@RequestMapping("/show")
public class ShowController {

    @Autowired
    protected UserService userService;
    @Autowired
    protected DataService dataService;

    public static final Logger logger = LoggerFactory.getLogger(ShowController.class);
    @RequestMapping
    public String list(Model model){
        return "show/show";
    }
    @RequestMapping(value = "/list2" )
    public String list2(Model model){
        model.addAttribute("list",UserAssembler.domainToDto(dataService.list()));
        return "show/list2";
    }
}
