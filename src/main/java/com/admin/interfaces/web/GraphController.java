package com.admin.interfaces.web;

import com.admin.application.DataService;
import com.admin.application.UserService;
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
@RequestMapping("/graph")
public class GraphController {

//    @Autowired
//    protected UserService userService;
//    @Autowired
//    protected DataService dataService;

    public static final Logger logger = LoggerFactory.getLogger(GraphController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
//        model.addAttribute("list",dataService.showScript());
        return "graph/list";
    }

//    @RequestMapping(value = "/success",method = RequestMethod.GET)
//    public String success( String introduce,Model model){
//        String contents=dataService.start(introduce);
//        System.out.println("contents :"+contents);
//        model.addAttribute("list",dataService.showScript());
//        return "show/list";
//    }


}
