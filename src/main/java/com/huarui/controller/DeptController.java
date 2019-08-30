package com.huarui.controller;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huarui.config.DataDTO;
import com.huarui.es.MenuService;
import com.huarui.es.type.Menu;
import com.huarui.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController
{

	@Autowired
	private DishService dishService;


	@Autowired
	MenuService menuService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Long id)
	{


		return dishService.findById(id).getTitle();

	}

	@RequestMapping(value = "/testUpdate", method = RequestMethod.GET)
	public String testUpdate()
	{


		return "更新接口...";

	}


	@RequestMapping(value = "testEs",method = RequestMethod.GET)
	public List<Menu> testEs(){

		List<Menu> li = menuService.selectByName("羊肉");
		return li;
	}


}
