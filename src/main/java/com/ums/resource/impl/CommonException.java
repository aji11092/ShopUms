/*
 * FileName: CommonException.java
 * Author  : Ajimon
 * 
 * Using JRE 1.8.0_251
 * 
 * Copyright(c) 2021 securityNcompliance Inc.
 * Duplication or distribution of this code in part or in whole by any media
 * without the express written permission of securityNcompliance Corporation or its agents is
 * strictly prohibited.
 *  
 * REVISION         DATE            NAME     DESCRIPTION
 * 511.101       Jun 7, 2021       Ajimon   Initial Code  
 */
package com.ums.resource.impl;

import java.util.List;

import com.ums.common.ErrorCode;

/**
 * This class is used to throw custom exceptions.
 */
public class CommonException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The error code. */
    private final String errorCode;

    /** The message. */
    private final String message;

    /** The param errors. */
    private final List<ParamErrors> paramErrors;

    /**
     * Instantiates a new common exception.
     *
     * @param errorCode the error code
     * @param message the message
     * @param paramErrors the param errors
     */
    public CommonException(String errorCode, String message, List<ParamErrors> paramErrors) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
        this.paramErrors = paramErrors;
    }

    /**
     * Instantiates a new common exception.
     *
     * @param code the code
     * @param ex the ex
     * @param paramErrors the param errors
     */
    public CommonException(ErrorCode code, Exception ex, List<ParamErrors> paramErrors) {
        super(ex);
        this.errorCode = code.toString();
        this.message = ex.getMessage();
        this.paramErrors = paramErrors;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Gets the param errors.
     *
     * @return the param errors
     */
    public List<ParamErrors> getParamErrors() {
        return paramErrors;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */

    @Override
    public String getMessage() {
        return message;
    }

}
