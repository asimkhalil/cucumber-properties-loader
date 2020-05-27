package com.cucumber.poc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mycontroller")
public class MyController {

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String getName() {
		return "asim";
	}
}
