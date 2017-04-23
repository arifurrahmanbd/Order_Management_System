package app.commonerp.usermanager.presentationtier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard/dashboard";
	}

	@RequestMapping("/usermanager")
	public String welcome_view() {
		return "usermanager/createuser";
	}

	@RequestMapping("/login")
	public String login() {
		return "usermanager/login";
	}

	@Controller
	public class HelloController {
		@RequestMapping("/hello")
		public String hello(
				Model model,
				@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
			List<String> names = new ArrayList();
			names.add("Arif");
			names.add("Jobair");
			names.add("Ehasun Khan");
			names.add("Amit");
			model.addAttribute("names", names);
			model.addAttribute("name", name);
			return "hello";
		}
	}
}
