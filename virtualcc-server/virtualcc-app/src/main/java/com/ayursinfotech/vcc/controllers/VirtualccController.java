package com.ayursinfotech.vcc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ayursinfotech.vcc.response.BaseResponse;
import com.ayursinfotech.vcc.service.VirtualccService;

@Controller
public class VirtualccController {

	private static final Logger LOGGER = Logger
			.getLogger(VirtualccController.class);

	@Autowired
	private VirtualccService virtualccService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse ping() {
		LOGGER.info("start sExecuting ping");
		return virtualccService.ping();
	}
}
