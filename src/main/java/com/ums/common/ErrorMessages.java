/*
 * FileName: ErrorMessages.java
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
 * The Class ErrorMessages.
 */
public class ErrorMessages {

    /** The Constant NO_ENTRY_FOUND. */
    public static final String NO_ENTRY_FOUND = "No entry found";

    /** The Constant METHOD_NOT_SUPPORTED. */
    public static final String METHOD_NOT_SUPPORTED = "Method not supported for provided Ids.";

    /** The Constant ACCESS_DENIED. */
    public static final String ACCESS_DENIED = "Access Denied";

    /** The Constant INVALID_PROFILE. */
    public static final String INVALID_PROFILE = "Requested profile is Invalid or Deleted";

    /** The Constant INTERNAL_SERVER_ERROR. */
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    /** The Constant PROFILE_DUPLICATE_ERROR. */
    public static final String PROFILE_DUPLICATE_ERROR = "A profile already exist in this name";

    /** The Constant PAGE_DUPLICATE_ERROR. */
    public static final String PAGE_DUPLICATE_ERROR = "A page already exist in this name for this profile";

    /** The Constant ASSET_DUPLICATE_ERROR. */
    public static final String ASSET_DUPLICATE_ERROR = "Asset with same asset id already exists";

    /** The Constant ASSET_ID_MISSING_MESSAG. */
    public static final String ASSET_ID_MISSING_MESSAG = "Given asset id is null";

    /** The Constant INVALID_PARAMETERS. */
    public static final String INVALID_PARAMETERS = "INVALID_PARAMETERS";

    /** The Constant INVALID_REQUEST. */
    public static final String INVALID_REQUEST = "Invalid Request Parameter";

    /** The Constant CATEGORY_ALREADY_ASSIGNED. */
    public static final String CATEGORY_ALREADY_ASSIGNED = "This Category already assgined to some report";

    /** The Constant STRIPE_PARAMETERS. */
    public static final String STRIPE_PARAMETERS = "STRIPE_PARAMETERS";

    /**
     * Instantiates a new error messages.
     */
    private ErrorMessages() {

    }

}
