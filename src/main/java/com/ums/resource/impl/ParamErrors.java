/*
 * FileName: ParamErrors.java
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

/**
 * The Class ParamErrors.
 */
public class ParamErrors {

    /** The param name. */
    private String paramName;

    /** The error. */
    private String error;

    /**
     * Gets the param name.
     *
     * @return the param name
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * Sets the param name.
     *
     * @param paramName the new param name
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error.
     *
     * @param error the new error
     */
    public void setError(String error) {
        this.error = error;
    }
}
