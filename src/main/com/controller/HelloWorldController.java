package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import model.User;

@Controller
public class HelloWorldController{

	@RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	protected String welcomeMethod(ModelMap model) throws Exception {

		User  user1 = new User(1,"ali","lotf",12);
		User  user2 = new User(2,"reza","ravi",10);
		
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		model.addAttribute("myuser", user1);

		return "HelloWorldPage";
	}
}