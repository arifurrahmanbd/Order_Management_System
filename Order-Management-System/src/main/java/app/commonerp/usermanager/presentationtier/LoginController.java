package app.commonerp.usermanager.presentationtier;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.commonerp.usermanager.persistencetier.User;
import app.commonerp.usermanager.persistencetier.UserRepository;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getLoginInfo(Model model) {
		return "admin/login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateLoginInfo(Model model, HttpServletRequest request,
			@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword) {

		User user = userRepository.findByUserEmailAndUserPassword(userEmail,
				userPassword);
		User userInfo = userRepository.findByUserEmail(userEmail);
		
		if (user == null) {
			model.addAttribute("message",
					"The email and password you entered don't match");
			return "admin/login";
		} else {
			
			System.out.println("Logged in username:" + userInfo.getUserEmail());			
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(0);

			model.addAttribute("user", user);
			return "admin/home";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogoutInfo(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("user");

		return "admin/login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePageInfo(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user", user);
		return "admin/home";
	}
}
