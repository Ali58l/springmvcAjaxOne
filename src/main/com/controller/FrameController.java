package controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.FrameService;

@Controller
public class FrameController{

	FrameService frameService;	
	List<String> pages;

	@Autowired
	public void setPages(List<String> pages) {
		this.pages = pages;
	}

	@Autowired
	public void setFrameService(FrameService frameService) {
		this.frameService = frameService;
	}


	@RequestMapping(value = "/mypage.htm", method = RequestMethod.GET)
	protected String showPage(ModelMap model,@RequestParam("id") String id) throws Exception {

		boolean result = pages.stream().anyMatch(id::equals);	
		List<Integer> userIds = frameService.returnCustomerIds();
		System.out.println(userIds.get(0));
		
		return "Page"+ ((result) ? id : "NotFound");
	}


	@RequestMapping(value = "/userId.htm",headers="Accept=*/*", produces = "application/json",
					method = RequestMethod.GET)
	@ResponseBody
	protected String returnUserId() throws Exception {

		List<Integer> userIds = frameService.returnCustomerIds();
		
		return new Gson().toJson(userIds);
//		JSONArray list = new JSONArray();
//		userIds.stream().forEach( u -> {
//			JSONObject obj = new JSONObject();
//			obj.put(u,u);
//			list.add(obj);
//		});
//		
		//return list;
	}
}