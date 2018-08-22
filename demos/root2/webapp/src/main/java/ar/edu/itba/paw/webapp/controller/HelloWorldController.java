package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.paw.interfaces.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class HelloWorldController {
	
	 @Autowired
	 @Qualifier("userServiceImpl")
	 private UserService us;
	
	@RequestMapping("/")
	public ModelAndView helloWorld() {
		List<User> users = us.list();
		final ModelAndView mav = new ModelAndView("index");
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		List<User> users = us.list();
		final ModelAndView mav = new ModelAndView("list");
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUp(@RequestParam String name, @RequestParam String password) {
		User user = us.findById("3");
		final ModelAndView mav = new ModelAndView("index");
		mav.addObject("selectedUser", user);
		return mav;
	}
}
