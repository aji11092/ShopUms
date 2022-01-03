/*
 * FileName: UserResourceController.java
 * Author  : admin
 * 
 * Using JRE 1.8.0_251
 * 
 * Copyright(c) 2021 securityNcompliance Inc.
 * Duplication or distribution of this code in part or in whole by any media
 * without the express written permission of securityNcompliance Corporation or its agents is
 * strictly prohibited.
 *  
 * REVISION         DATE            NAME     DESCRIPTION
 * 511.101       Nov 15, 2021       Ajimon   Initial Code  
 */
package com.ums.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ums.model.User;
import com.ums.resource.impl.CommonException;
import com.ums.service.UserResourceService;

/**
 * The Class ControlController.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceController {

    /** The delegate. */
    @Autowired
    UserResourceService service;

    /**
     * Creates the control.
     *
     * @param activityRequest the activity request
     * @param headers the headers
     * @return the response
     * @throws ParseException the parse exception
     */
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasAuthority('COURSE_CREATE')")
    @ResponseBody
    public ResponseEntity<String>  register(@RequestBody User user)
        throws ParseException {
		ResponseEntity<String> responseObj = null;
        try {

            responseObj = service.register(user);
        } catch (CommonException e) {
           // responseObj = Util.turfException(e);
        }
        return responseObj;
    }
	@PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAuthority('COURSE_CREATE')")
	@ResponseBody
	public ResponseEntity<String>  authenticate(@RequestBody User user) {
		ResponseEntity<String> responseObj = null;
		try {
			
			responseObj = service.authenticate(user);
		} catch (CommonException e) {
			//responseObj = Util.turfException(e);
		}
		return responseObj;
	}

  

}
