/*
 * FileName: ErrorCode.java
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
package com.ums.common;

/**
 * The Enum ErrorCode.
 */
public enum ErrorCode {

    /** The internal server error. */
    INTERNAL_SERVER_ERROR,

    /** The not found. */
    NOT_FOUND,

    /** The access denied. */
    ACCESS_DENIED,

    /** The bad request. */
    BAD_REQUEST,

    /** The method not supported. */
    METHOD_NOT_SUPPORTED,

    /** The no entry. */
    NO_ENTRY,

    /** The duplication. */
    DUPLICATION,

    /** The validation failed. */
    VALIDATION_FAILED,

    /** The unable to delete. */
    UNABLE_TO_DELETE,

    /** The unable to processrequest. */
    UNABLE_TO_PROCESSREQUEST,

    /** The invalid state change request. */
    INVALID_STATE_CHANGE_REQUEST

}
