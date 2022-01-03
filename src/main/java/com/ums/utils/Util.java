/*
 * FileName: Util.java
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
package com.ums.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.ums.common.ErrorCode;
import com.ums.common.Response;
import com.ums.resource.impl.CommonException;


/**
 * The Class Util.
 */
public class Util {

    /** The Constant VALID_EMAIL_ADDRESS_REGEX. */
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Instantiates a new util.
     */
    private Util() {
        throw new IllegalStateException("Util class");
    }

    /**
     * Turf exception.
     *
     * @param e the e
     * @return the response
     */
    public static Response turfException(CommonException e) {
        Response responseObj;
        responseObj = new Response();
        responseObj.setMessage(e.getMessage());
        responseObj.setErrorCode(e.getErrorCode());
        responseObj.setSuccess(false);
        responseObj.setParamErrors(e.getParamErrors());
        return responseObj;
    }

    /** The map. */
    static HashMap<String, Integer> map = new HashMap<>();

    /**
     * Validate.
     *
     * @param emailStr the email str
     * @return true, if successful
     */
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    /**
     * Check proposal number.
     *
     * @param proposalNumber the proposal number
     * @param partnerId the partner id
     * @return the map
     */
    public static Map<String, Integer> checkProposalNumber(Integer proposalNumber, String partnerId) {
        if (proposalNumber != 0 && !Strings.isNullOrEmpty(partnerId)) {
            map.put("proposalNumber", proposalNumber);
        }
        return map;
    }

    /**
     * Check time diff.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return the string
     * @throws ParseException the parse exception
     */
    public static String checkTimeDiff(String startDate, String endDate) throws ParseException {
        String time = null;
        String seconds = null;
        String minutes = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        long diff = date2.getTime() - date1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        if (diffSeconds == 0) {
            diffSeconds = 00;
        }
        if (diffMinutes == 0) {
            diffMinutes = 00;
        }
        if (diffHours == 0) {
            diffHours = 00;
        }
        seconds = String.valueOf(diffSeconds);
        minutes = String.valueOf(diffMinutes);
        time = String.valueOf(diffHours) + ":" + minutes + ":" + seconds;
        return time;
    }

    /**
     * Adds the hours.
     *
     * @param time1 the time 1
     * @param time2 the time 2
     * @return the string
     * @throws ParseException the parse exception
     */
    public static String addHours(String time1, String time2) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1 = null;
        Date date2 = null;
        long sum = 0;
        if (time1 == null) {
            date2 = timeFormat.parse(time2);
            sum = date2.getTime();
        } else {
            date1 = timeFormat.parse(time1);
            date2 = timeFormat.parse(time2);
            sum = date1.getTime() + date2.getTime();
        }

        String date3 = timeFormat.format(new Date(sum));
        return date3;

    }

    /**
     * Gets the proposal number.
     *
     * @return the proposal number
     */
    public static String getProposalNumber() {
        String alphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 6; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Gets the utc date.
     *
     * @param date1 the date 1
     * @return the utc date
     * @throws ParseException the parse exception
     */
    public static Date getUtcDate(String date1) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = dateFormat.parse(date1);

        // DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss:SSS z");

        // Date string with zone information
        // String dateString = "08/03/2019T16:20:17:717 UTC+05:30";

        // Instance with given zone
        // ZonedDateTime zdtInstanceAtOffset = ZonedDateTime.parse(dateString, DATE_TIME_FORMATTER);

        // Instance in UTC
        // ZonedDateTime zdtInstanceAtUTC = zdtInstanceAtOffset.withZoneSameInstant(ZoneOffset.UTC);

        // Formatting to string
        // String dateStringInUTC = zdtInstanceAtUTC.format(DATE_TIME_FORMATTER);

        // System.out.println(zdtInstanceAtOffset);
        // System.out.println(zdtInstanceAtUTC);
        // System.out.println(dateStringInUTC);

        // Convert ZonedDateTime to instant which is in UTC
        // System.out.println(zdtInstanceAtOffset.toInstant());
        return date;
    }
    public static String getDateResponse(Date date1) throws ParseException {
    	
    	DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String formattedDate = formatter1.format(date1);
    	return formattedDate;
    }

    /**
     * Multipart to file.
     *
     * @param multipart the multipart
     * @return the file
     */
    public static File multipartToFile(MultipartFile multipart) {
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();
        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath() + File.separator + multipart.getOriginalFilename());
        try {
            multipart.transferTo(serverFile);
        } catch (IllegalStateException | IOException e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR, e, null);
        }
        return serverFile;
    }

    /**
     * Gets the last week.
     *
     * @return the last week
     */
    public static Date getLastWeek() {
        GregorianCalendar dayBeforeThisWeek = new GregorianCalendar();
        int dayFromMonday = (dayBeforeThisWeek.get(Calendar.DAY_OF_WEEK) + 7 - Calendar.MONDAY) % 7;
        dayBeforeThisWeek.add(Calendar.DATE, -dayFromMonday - 1);
        return dayBeforeThisWeek.getTime();
    }

    /**
     * Gets the today in CST.
     *
     * @return the today in CST
     */
    public static Date getTodayInCST() {
        SimpleDateFormat cstCdtFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        cstCdtFormat.setTimeZone(TimeZone.getTimeZone("America/Regina"));
        String s = cstCdtFormat.format(new Date());
        try {
            return formatter.parse(s);
        } catch (ParseException e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR, e, null);
        }
    }

    /**
     * Convert postgres date format.
     *
     * @param startDate the start date
     * @return the date
     */
    public static Date convertPostgresDateFormat(String startDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(startDate);
        } catch (ParseException e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR, e, null);
        }
    }

    /**
     * Gets the current date.
     *
     * @return the current date
     */
    public static Date getCurrentDate() {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        isoFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        String date1 = isoFormat.format(date);
        try {
            date = isoFormat.parse(date1);
        } catch (ParseException e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR, e, null);
        }
        return date;
    }

    /**
     * Gets the days.
     *
     * @param day the day
     * @return the days
     */
    public static Date getDays(long day) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime days = today.minusDays(day);
        Date date = new Date();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");

        // Format LocalDateTime
        String formattedDateTime = days.format(formatter1);
        try {
            date = isoFormat.parse(formattedDateTime);
        } catch (ParseException e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR, e, null);
        }
        return date;
    }

    /**
     * Checks if is null or empty.
     *
     * @param c the c
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(final Collection<?> c) {
        return c == null || c.isEmpty();
    }

    /**
     * Creates the random number.
     *
     * @param len the len
     * @return the long
     */
    public final static long createRandomNumber(long len) {
        if (len > 18)
            throw new IllegalStateException("To many digits");
        long tLen = (long) Math.pow(10, len - 1) * 9;
        long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

        String tVal = number + "";
        if (tVal.length() != len) {
            throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
        }
        return number;
    }

    /**
     * Gets the alpha numeric string.
     *
     * @return the alpha numeric string
     */
    public static String getAlphaNumericString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(6);
        // sb.append(Calendar.getInstance().get(Calendar.YEAR));
        for (int i = 0; i < 6; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Generate coupon.
     *
     * @return the string
     */
    public static String generateCoupon() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(6);
        // sb.append(Calendar.getInstance().get(Calendar.YEAR));
        for (int i = 0; i < 10; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Generate recept.
     *
     * @return the string
     */
    public static String generateRecept() {
        String AlphaNumericString = "0123456789" + "0123456789" + "0123456789";
        StringBuilder sb = new StringBuilder(6);
        // sb.append(Calendar.getInstance().get(Calendar.YEAR));
        for (int i = 0; i < 10; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Generate order id.
     *
     * @return the string
     */
    public static String generateOrderId() {
        String OrderId;
        // String countryCode="QS";
        int num = 00000000;
        DecimalFormat df = new DecimalFormat("00");
        String year;
        String month;
        String day;

        // Getting the current date value
        LocalDate currentdate = LocalDate.now();
        // System.out.println("Current date: "+currentdate);

        // Getting the current day
        day = df.format(currentdate.getDayOfMonth());

        // Getting the current month
        month = df.format(currentdate.getMonth().getValue());
        // getting the current year
        String s = String.valueOf(currentdate.getYear());
        year = s.substring(2, 4);

        // OrderId=countryCode+year+month+day+num;
        OrderId = year + month + day + num;

        return OrderId;
    }
    
    
    public static String generateCustomerId() {
        
        
        String customerId;
        String num = "0000000";
        DecimalFormat df = new DecimalFormat("00");
        DecimalFormat cCode = new DecimalFormat("000");
        String year;
        String month;
        String day;
       // String id="CustId_";

        // Getting the current date value
        LocalDate currentdate = LocalDate.now();
        // System.out.println("Current date: "+currentdate);

        // Getting the current day
        day = df.format(currentdate.getDayOfMonth());
        

        // Getting the current month
        month = df.format(currentdate.getMonth().getValue());
        // getting the current year
        String s = String.valueOf(currentdate.getYear());
        year = s.substring(2, 4);

        customerId=year+month+day+num;
        //OrderId = year + month + day + num;

        
        /* String OrderId;
        String num = "0000000";
        DecimalFormat df = new DecimalFormat("00");
        DecimalFormat cCode = new DecimalFormat("000");
        String year;
        String month;
        String day;
        String countryCodeNew;
        
        // Getting the current date value
        LocalDate currentdate = LocalDate.now();
        // System.out.println("Current date: "+currentdate);
        
        // Getting the current day
        day = df.format(currentdate.getDayOfMonth());
        
        countryCodeNew = cCode.format(Integer.parseInt(countryCode));
        
        // Getting the current month
        month = df.format(currentdate.getMonth().getValue());
        // getting the current year
        String s = String.valueOf(currentdate.getYear());
        year = s.substring(2, 4);
        
         OrderId=countryCodeNew+year+month+day+num;
        //OrderId = year + month + day + num;
        */
        
        
        
        
        return customerId;
    }
    

    /**
     * Creates the pagination.
     *
     * @param pageSize the page size
     * @param pageNumber the page number
     * @param sortOrder the sort order
     * @param sortKey the sort key
     * @param sort the sort
     * @return the pageable
     */
    public static Pageable createPagination(int pageSize, int pageNumber, String sortOrder, String sortKey, Sort sort) {
        /*
         * if (!TextUtil.isEmpty(sortKey)) { sort = new
         * Sort(sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC :
         * Sort.Direction.ASC, sortKey); } if (TextUtil.isEmpty(sortKey)) { sort = new
         * Sort("desc".equalsIgnoreCase("desc") ? Sort.Direction.DESC :
         * Sort.Direction.ASC, "createdDate"); } Pageable pageRequest = new
         * PageRequest(pageNumber, pageSize, sort);
         */
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("createdDate").descending());
        return pageRequest;
    }
}
