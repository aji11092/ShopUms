/*
 * FileName: Response.java
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.ums.resource.impl.ParamErrors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The Class Response.
 */
@ApiModel(value = "ResponseModel", description = "Response com.ums.model for each operation,every response will be shown by using this entity fields.")
public class Response {

    /** The success. */
    @ApiModelProperty(value = "Boolean value showing success in response,either true/false")
    private boolean success;

    /** The message. */
    @ApiModelProperty(value = "message to be shown in response", notes = "success/failure")
    private String message;

    /** The data. */
    @ApiModelProperty(value = "data object which will contain the resulting data")
    private Object data;

    /** The error code. */
    @ApiModelProperty(value = "response code.")
    private String errorCode;

    /** The extras. */
    @ApiModelProperty(value = "extras - to show if any extra information to be shown")
    private Map<String, Object> extras;

    /** The success code. */
    @ApiModelProperty(value = "successCode - to show if success")
    private String successCode;

    /** The param errors. */
    @ApiModelProperty(value = "paramErrors - to show params with errors on giving invalid request parametres")
    private List<ParamErrors> paramErrors;

    /**
     * Instantiates a new response.
     */
    public Response() {
    }

    /**
     * Instantiates a new response.
     *
     * @param success the success
     * @param message the message
     * @param data the data
     * @param errorCode the error code
     */
    public Response(Boolean success, String message, Object data, String errorCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errorCode = errorCode;
    }

    /**
     * Gets the extras.
     *
     * @return the extras
     */
    public Map<String, Object> getExtras() {
        if (extras == null) {
            extras = new HashMap<>();
        }
        return extras;
    }

    /**
     * Sets the extras.
     *
     * @param extras the extras to set
     */
    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

    /**
     * Checks if is success.
     *
     * @return true, if is success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success.
     *
     * @param success the new success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * Sets the error code.
     *
     * @param errorCode the new error code
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Gets the success code.
     *
     * @return the success code
     */
    public String getSuccessCode() {
        return successCode;
    }

    /**
     * Sets the success code.
     *
     * @param successCode the new success code
     */
    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
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
     * Sets the param errors.
     *
     * @param paramErrors the new param errors
     */
    public void setParamErrors(List<ParamErrors> paramErrors) {
        this.paramErrors = paramErrors;
    }

    /**
     * Normalize.
     *
     * @return the string
     */
    public String normalize() {
        JsonObject obj = new JsonObject();
        JsonArray array = new JsonArray();
        if (this.data != null) {
            JsonArray arry = JsonArray.readFrom(this.data.toString());
            obj.add("data", arry);
        }
        obj.add("success", this.success);
        obj.add("message", this.message);
        obj.add("successCode", this.successCode);
        obj.add("errorCode", this.errorCode);
        if (this.paramErrors != null) {
            for (ParamErrors paramError : this.paramErrors) {
                array.add(getParamErrors(paramError));
            }
            obj.add("paramErrors", array);
        }
        return obj.toString();
    }

    /**
     * Normalize obj.
     *
     * @return the string
     */
    public String normalizeObj() {
        JsonObject obj = new JsonObject();
        JsonArray array = new JsonArray();
        if (this.data != null) {
            JsonObject jsonObject = JsonObject.readFrom(this.data.toString());
            obj.add("data", jsonObject);
        } else {
            obj.add("data", new JsonObject());
        }
        obj.add("success", this.success);
        obj.add("message", this.message);
        obj.add("successCode", this.successCode);
        obj.add("errorCode", this.errorCode);
        if (this.paramErrors != null) {
            for (ParamErrors paramError : this.paramErrors) {
                array.add(getParamErrors(paramError));
            }
            obj.add("paramErrors", array);
        }
        return obj.toString();
    }

    /**
     * Gets the param errors.
     *
     * @param paramError the param error
     * @return the param errors
     */
    private JsonArray getParamErrors(ParamErrors paramError) {
        JsonObject jsonObject = new JsonObject();
        JsonArray array = new JsonArray();
        jsonObject.add("error", paramError.getError());
        jsonObject.add("paramName", paramError.getParamName());
        array.add(jsonObject);
        return array;
    }
}
