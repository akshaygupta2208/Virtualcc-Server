package com.ayursinfotech.vcc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayursinfotech.vcc.dao.VirtualccDAO;
import com.ayursinfotech.vcc.response.BaseResponse;
import com.ayursinfotech.vcc.service.VirtualccService;
import com.ayursinfotech.vcc.util.VirtualccConstants;

@Service
public class VirtualccServiceImpl implements VirtualccService {

	private static final Logger LOGGER = Logger
			.getLogger(VirtualccServiceImpl.class);

	@Autowired
	private VirtualccDAO virtualccDAO;

	@Override
	public BaseResponse ping() {
		LOGGER.info("start executing ping");
		BaseResponse response = new BaseResponse();
		try {
			if (virtualccDAO.ping()) {
				response.setStatus(VirtualccConstants.STATUS_SUCCESS);
			} else {
				response.setStatus(VirtualccConstants.STATUS_FAILURE);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		LOGGER.info("end executing ping");
		return response;
	}

}
