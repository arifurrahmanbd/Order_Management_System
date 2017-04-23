package app.commonerp.usermanager.presentationtier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.commonerp.usermanager.businesstier.UserManager;

@Controller
@RequestMapping(value = "/UserManager")
public class UserManagerController {
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		model.addAttribute("appTitle", "User Manager");
		return "usermanager/dashboard";
	}
	@ModelAttribute 
	public void addingCommonObjects(Model model){
		model.addAttribute("appTitle", "User Manager");
	}
	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser() {
		ModelAndView modelAndView = new ModelAndView("usermanager/createNewUser");
		modelAndView.addObject("securityGroupList",userManager.getSecurityGroupList());
		modelAndView.addObject("userLoginList",userManager.getUserList());
		return modelAndView;
	}
	@RequestMapping(value = "createUserAction", method = RequestMethod.POST)
	public ModelAndView createUserAction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("redirect:/UserManager/createNewUser");
		userManager.saveUserLogin(request, response);
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
	@RequestMapping(value = "deleteUserAction", method = RequestMethod.GET)
	public ModelAndView deleteUserAction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("usermanager/findUser");
		Long groupId = Long.valueOf(request.getParameter("groupId"));
		
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
	@RequestMapping(value = "findUser", method = RequestMethod.GET)
	public ModelAndView findUser() {
		ModelAndView modelAndView = new ModelAndView("usermanager/findUser");
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "createNewGroup", method = RequestMethod.GET)
	public ModelAndView createNewGroup() {
		ModelAndView modelAndView = new ModelAndView("usermanager/createNewGroup");
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
	@RequestMapping(value = "createGroupAction", method = RequestMethod.GET)
	public ModelAndView createGroupAction() {
		ModelAndView modelAndView = new ModelAndView("usermanager/createGroupAction");
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
	@RequestMapping(value = "deleteGroupAction", method = RequestMethod.GET)
	public ModelAndView deleteGroupAction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("usermanager/findUserGroup");
		modelAndView.addObject("appTitle","User Manager ");
		userManager.deleteSecurityGroup(Long.parseLong(request.getParameter("id")));
		return modelAndView;
	}
	@RequestMapping(value = "findUserGroup", method = RequestMethod.GET)
	public ModelAndView findUserGroup() {
		ModelAndView modelAndView = new ModelAndView("usermanager/findUserGroup");
		modelAndView.addObject("appTitle","User Manager ");
		return modelAndView;
	}
}
