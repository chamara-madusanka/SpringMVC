package main.java.com.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MainController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView("HelloPage");
        modelAndView.addObject("welcomeMessage", "Welcome SpringMVC.");

        return modelAndView;
    }
}
