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
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("list",dataService.showScript());
        return "show/list";
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success( String introduce,Model model){
        String contents=dataService.start(introduce);
        System.out.println("contents :"+contents);
        model.addAttribute("list",dataService.showScript());
        return "show/list";
    }


}
