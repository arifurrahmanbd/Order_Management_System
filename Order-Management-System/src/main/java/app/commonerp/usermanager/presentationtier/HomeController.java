package app.commonerp.usermanager.presentationtier;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getLoginInfo(Model model) {
		//model.addAttribute("organizationList", organizationRepository.findByIsDeletedFalse());
		return "public/home";
	}
}
