package vn.t3h.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import vn.t3h.components.SingletonData;
import vn.t3h.services.HomeService;

@Controller
public class HomeController extends BaseController {
	private Logger logger = (Logger) LoggerFactory.getLogger(HomeController.class);
	static final String VIEW_INDEX = "pages/index";
	
	@Autowired private HomeService homeService;

	@GetMapping(value = {"","/"})
	public String getHome(Model model) {
		model.addAttribute("str", homeService.hello());
		SingletonData.getIntance().addData("Home Request" + System.nanoTime());
		return VIEW_INDEX;
	}
	
	@GetMapping(value = "/about")
	public String getAbout(Model model) {
		
		var sizeOfData = SingletonData.getIntance().checkSize();
		logger.info("sizeOfData : {}",sizeOfData);
		var datas = SingletonData.getIntance().getDatas();
		datas.forEach(item -> {
			logger.info("data: {}", item);
		});
		model.addAttribute("str", "Data About");
		return "pages/about";
	}
}