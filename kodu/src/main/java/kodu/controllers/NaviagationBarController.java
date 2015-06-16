package kodu.controllers;

import kodu.services.VisualizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value={"/home","/profile/{username}","/profileConfiguration"})
public class NaviagationBarController {
		@Autowired
		VisualizationService visualizationService;
		


	
}
