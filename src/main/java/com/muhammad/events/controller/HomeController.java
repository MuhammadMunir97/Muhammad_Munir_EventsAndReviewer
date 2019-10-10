package com.muhammad.events.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.muhammad.events.modells.User;
import com.muhammad.events.service.CommentService;
import com.muhammad.events.service.EventService;
import com.muhammad.events.service.UserService;

@Controller
public class HomeController {
	
	private final EventService eventService;
	private final CommentService commentService;
	private final UserService userService;
	
	public HomeController(EventService eventService, CommentService commentService, UserService userService) {
		this.eventService = eventService;
		this.commentService = commentService;
		this.userService = userService;
	}
	@RequestMapping("/create_account")
	public String createAccount(@ModelAttribute("user") User user) {
		return "/view/CreateAccount.jsp";
	}
	
	@PostMapping("/create_account")
	public String addAccount(@Valid @ModelAttribute("user") User user , BindingResult bindingResult, RedirectAttributes errorRedirect) {
		if(bindingResult.hasErrors()) {
			errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "/view/CreateAccount.jsp";
		}else {
			userService.registerUser(user);
			return "redirect:/login";
		}
	}
}
