package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.webapp.horoscope.FileHoroscopeManager;
import ar.edu.itba.paw.webapp.horoscope.Horoscope;
import ar.edu.itba.paw.webapp.user.User;
import ar.edu.itba.paw.webapp.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
public class HelloWorldController {

    @Autowired
    UserManager userManager;

    @Autowired
    ServletContext context;

    @RequestMapping("/welcome")
    public ModelAndView welcome() {

        if (userManager.existsUser()) {
            return new ModelAndView("forward:/horoscope");

        } else {
            final ModelAndView mav = new ModelAndView("index");
            mav.addObject("greeting", "PAW");
            return mav;
        }
    }

    @RequestMapping(value = "/horoscope", method = RequestMethod.GET)
    public ModelAndView horoscope() {

        User user = userManager.getUser();

        String filename = context.getRealPath("data/data.xml");
        FileHoroscopeManager horoscopeManager = new FileHoroscopeManager(filename);

        Horoscope horoscope = horoscopeManager.getHoroscope(user.getSign());

        if (horoscope == null) {
           // TODO handle ERROR
        }

        userManager.setUser(user.getName(), user.getSign());

        final ModelAndView mav = new ModelAndView("horoscope");

        mav.addObject("horoscope", horoscope);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/horoscope", method = RequestMethod.POST)
    public ModelAndView horoscopePost() {
        return horoscope();
    }
}