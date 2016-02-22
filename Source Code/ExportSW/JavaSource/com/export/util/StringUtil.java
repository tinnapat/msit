package com.export.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StringUtil {

    private static Logger logger = LogManager.getLogger(StringUtil.class);

    /* Encoding */
    public static final String ENCODING = "UTF-8";


    /* emailCheck return value*/
    public final static int VALID = 0;
    public final static int SYNTAX_ERR = 1;
    public final static int INVALID_CHAR = 2;


    /* Email check error codes */

    public final static int NO_ATMARK = 3;
    public final static int EXCESS_ATMARK = 4;


    /* hankaku characters */

    final static char HTL = '~';  // tilde
    final static char HNSTART = '0';
    final static char HNEND = '9';
    final static char HAM = '@';  // atmark
    final static char HPR = '.';  // period
    final static char HEM = '!';  // exclamation mark

    /**
     * check the param is composed of hankaku numbers
     * @return true : the param is composed of hankaku numbers<br>
     *		   false: not composed
     */

    public static boolean isNumber(String s) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch < HNSTART || ch > HNEND) {

                return false;

            }

        }

        return true;

    }

    /**
     * check the param is composed of letter or digit
     * @return true : the param is composed of letter or digit<br>
     *		   false: not composed
     */
    public static boolean isLetterOrDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9'))) {
                return false;
            }
        }
        return true;
    }

    /**
     * RFC822 Mail Address Validator
     *
     * RFC822 addr-spec is complex and over-spec for us.
     * I add following some conditions to reject.
     *	  control-code \0 - \31
     *	  quoted-string or pair
     *	  snum-concatinated domain string like 192.163.1.250
     *	  sharpsign-leading domain string like #[nnn.nnn.nnn.nnn]
     *
     * now, the logic becomes very simple. :-)
     *
     * @param str pseudo string
     * @see <A href="http://www.csl.sony.co.jp/rfc/cache/rfc822.txt.html"> RFC822 </A>
     */
    public static int emailCheck(String s) {
        boolean atmark = false; // a flag meaning atmark found or not
        boolean period = false; // a flag meaning last char is period

        if (s.indexOf("@") == -1) {
            return NO_ATMARK;
        }

        if (s.indexOf("@", s.indexOf("@") + 1) > -1) {
            return EXCESS_ATMARK;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == HAM) {
                if (atmark				  // atmark can appear only once
                        || period				  // local-part cannot end with period
                        || i == 0				  // cannot start with atmark
                        || i == s.length() - 1)	  // cannot end with atmark
                    return SYNTAX_ERR;
                atmark = true;
                period = true;	// tricky code; domain cannot start with period
            }
            else if (ch == HPR) {
                if (period				  // period cannot appear continuously
                        || i == 0				  // cannot start with period
                        || i == s.length() - 1)	  // cannot end with period
                    return SYNTAX_ERR;
                period = true;
            }
            else if (ch > HTL
                    || ch < HEM			// including space charcter :-)
                    || ch == '('
                    || ch == ')'
                    || ch == '<'
                    || ch == '>'
                    || ch == '['
                    || ch == ']'
                    || ch == ','
                    || ch == ';'
                    || ch == ':'
                    || ch == '\\'
                    || ch == '"') {      // illegal charcters
                return INVALID_CHAR;
            }
            else if (ch == '#' && atmark) {	// # cannot appear in domain part
                return INVALID_CHAR;
            }
            else {						// It seems to be valid char,
                period = false;
            }
        }

        // if there is no atmark, atmark == false	 :-)
        // if there a period is not found then it is an error.
        return (atmark & s.indexOf(HPR) > 0 ? VALID : SYNTAX_ERR);
    }

    /**
     * password string validator
     */
    public static boolean passwordCheck(String s) {
        if (s.length() < 5 || s.length() > 21) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < HEM || ch > HTL) {  // if between "!" and "~" , OK.
                return false;
            }
        }
        return true;
    }

    /**
     * Boundary line check.
     * The following ASCII characters are considered illegal:<br>
     * ! " ' ( ) , : ; < = > [ \ ^ ] `
     *
     * @param <code>String</code> s
     * @return <code>boolean</code> returns true if valid, false if not
     */
    public static boolean boundaryLineCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < HEM || ch > HTL // Should be between "!" and "~" , OK.
                    || ch == '!' || ch == '"'
                    || ch == '\'' || ch == '('
                    || ch == ')' || ch == ','
                    || ch == ':' || ch == ';'
                    || ch == '<' || ch == '='
                    || ch == '>' || ch == '['
                    || ch == '\\' || ch == ']'
                    || ch == '^' || ch == '`'
                    || ch == ' '
            ) {
                return false;//invalid
            }
        }
        return true;
    }

    /**
     */
    public static String utfAutoToUnicode(String s) {
        try {
            return new String(s.getBytes("ISO8859_1"), "UTF-8");
        }
        catch (Exception ex) {
            return s;
        }
    }

    /**
     */
    public static String getHashedString(String s) {
        MessageDigest md5Digest;
        int unsigned;
        String hexString;
        StringBuffer hashedString = new StringBuffer();
        try {
            md5Digest = MessageDigest.getInstance("MD5");
            md5Digest.update(s.getBytes());
            byte[] md5Hash = md5Digest.digest();
            for (int i = 0; i < md5Hash.length; i++) {
                unsigned = 0xff & md5Hash[i];
                hexString = Integer.toHexString(unsigned);
                if (hexString.length() == 1) {
                    hashedString.append("0");
                    hashedString.append(hexString);
                }
                else {
                    hashedString.append(hexString);
                }
            }
            return (new String(hashedString));
        }
        catch (Exception ex) {
            return s;
        }
    }

    /**
     */
    public static String htmlEncode(String s) {
        char[] buffer = s.toCharArray();
        StringBuffer newString = new StringBuffer(buffer.length + 30);
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == '<') {
                newString.append("&lt;");
            }
            else if (buffer[i] == '>') {
                newString.append("&gt;");
            }
            else if (buffer[i] == '"') {
                newString.append("&quot;");
            }
            else if (buffer[i] == '&') {
                newString.append("&amp;");
            }
            else if (buffer[i] == ' ') {
                newString.append("&nbsp;");
            }
            else if (buffer[i] == '\n') {
                newString.append("<br>");
            }
            else
                newString.append(buffer[i]);
        }
        return newString.toString();
    }
    
    /**
     * This method will perform html encoding on the String input and break lines after the column length specified
     * @param String The string to be encoded
     * @param int the coloumn length for line breaks
     * @return String the encoded String
     */
    public static String htmlEncode(String s, int col) {
        char[] buffer = s.toCharArray();
        StringBuffer newString = new StringBuffer(buffer.length + 30);
        for (int i = 0; i < buffer.length; i++) {
            if (((i % col) == 0) && (i != 0)) {
                newString.append("<br>");
            }
            if (buffer[i] == '<') {
                newString.append("&lt;");
            }
            else if (buffer[i] == '>') {
                newString.append("&gt;");
            }
            else if (buffer[i] == '"') {
                newString.append("&quot;");
            }
            else if (buffer[i] == '&') {
                newString.append("&amp;");
            }
            else if (buffer[i] == ' ') {
                newString.append("&nbsp;");
            }
            else if (buffer[i] == '\n') {
                newString.append("<br>");
            }
            else
                newString.append(buffer[i]);
        }
        return newString.toString();
    }

    /**
     *
     */
    public static String htmlEncodeForHidden(String s) {
        char[] buffer = s.toCharArray();
        StringBuffer newString = new StringBuffer(buffer.length + 30);
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == '&') {
                newString.append("&amp;");
            }
            else
                newString.append(buffer[i]);
        }
        return newString.toString();
    }

    /**
     * validate Date.
     * @param astrDD Day
     * @param astrMM Month
     * @param astrYYYY Year
     * @return true if valid.
     */
    public static boolean isValidDate(String astrDD, String astrMM, String astrYYYY) {
        SimpleDateFormat formatter;
        java.util.Date dt;
        try {
            formatter = new SimpleDateFormat("yyyyMMdd");
            formatter.setLenient(false); //Strict interpretation!
            dt = formatter.parse(astrYYYY + astrMM + astrDD);
            return true;
        }
        catch (java.text.ParseException e) {
            return false;
        }
        finally {
            formatter = null;
            dt = null;
        }
    }

    /**
     * validate GIF extension.
     * @param astrFileURL URL extension to be .gif only
     * @return true if valid.
     */
    public static boolean isValidGIFExt(String astrFileURL) {
        try {
            return (astrFileURL.toLowerCase().endsWith(".gif")) ?true:false;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * validate HTML extension.
     * @param astrFileURL URL extension to be .htm/.html only
     * @return true if valid.
     */
    public static boolean isValidHTMLExt(String astrFileURL) {
        try {
            return (astrFileURL.toLowerCase().endsWith(".htm") || astrFileURL.toLowerCase().endsWith(".html")) ?true:false;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * validate telephone number.
     * @param <code>String</code> astrTelNo Must contain 12 characters
     * in the format - "999-999-9999"
     *
     * @return true if valid.
     */
    public static boolean isValidTelPhoneNo(String astrTelNo) {
        try {
            if ((astrTelNo.charAt(3) == '-') && (astrTelNo.charAt(7) == '-')) {
                return isValidTelPhoneNo(astrTelNo.substring(0, 3),
                        astrTelNo.substring(4, 7), astrTelNo.substring(8));
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * validate telephone number.
     * @param astrTel1 Must contain 3 characters
     * @param astrTel2 Must contain 3 characters
     * @param astrTel3 Must contain 4 characters
     * @return true if valid.
     */
    public static boolean isValidTelPhoneNo(String astrTel1, String astrTel2, String astrTel3) {
        try {
            return (Integer.parseInt(astrTel1) > 0 && astrTel1.length() == 3 && Integer.parseInt(astrTel2) > 0 && astrTel2.length() == 3 && Integer.parseInt(astrTel3) > 0 && astrTel3.length() == 4) ? true:false;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * validate Time.
     * @param astrHH Hours value between 0 and 24
     * @param astrMM Minutes value between 0 and 60
     * @param astrSS Seconds value between 0 and 60
     * @return true if valid.
     */
    public static boolean isValidTime(String astrHH, String astrMM, String astrSS) {
        try {
            int iHH = Integer.parseInt(astrHH);
            int iMM = Integer.parseInt(astrMM);
            int iSS = Integer.parseInt(astrSS);
            return (iHH >= 0 && iHH < 24 && iMM >= 0 && iMM < 60 && iSS >= 0 && iSS < 60)?true:false;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * validate URL.
     * @param astrURL URL
     * @return true if valid.
     */
    public static boolean isValidURL(String astrURL) {
        URL url;
        try {
            url = new java.net.URL(astrURL);
            return true;
        }
        catch (MalformedURLException e) {
            return false;
        }
        finally {
            url = null;
        }
    }

   /**
     * getByteLength()
     * This method will return length of a string in bytes after encoding
     * using the ENCODING specified.
     *
     * @param astrTmp - String of whose length is to be determined.
     *
     * @return int Length of the string being passed.
     */
    public static int getByteLength(String astrTmp) throws java.io.UnsupportedEncodingException {
        return astrTmp.getBytes(ENCODING).length;
    }

    /**
     * checkLength()
     * This method takes return true in case length of the string being passed
     * is equal to the reqired length (passed as second parameter).
     *
     * @param astrTmp - String of whose length is to be checked.
     * @param int - length to compare with.
     * @return boolean - Returns <code>true</code> in case length of string is
     *                      equal to the second argument passed else returns <code>false</code>
     */
    public static boolean checkLength(String astrTmp, int nLength) throws java.io.UnsupportedEncodingException {
        return getByteLength(astrTmp) == nLength;
    }

    /**
     * This method checks for either less than / equals or greater than for String passed
     * against the length supplied as per the operation id.
     *
     * @param <code> String </code> astrAttrib, whose length is to be checked.
     * @param <code> int </code> nLength,length to compare with.
     * @param <code> int </code> nOperator,operation id.
     * @return <code> boolean </code>
     */
    public static boolean checkLength(String astrAttrib, int nLength, int nOperator)
            throws java.io.UnsupportedEncodingException {
        boolean bResult = true;
        switch (nOperator) {
            case 0:
                bResult = (getByteLength(astrAttrib) < nLength);
                break;
            case 1:
                bResult = (getByteLength(astrAttrib) == nLength || getByteLength(astrAttrib) < nLength);
                break;
            case 2:
                bResult = getByteLength(astrAttrib) == nLength;
                break;
            case 3:
                bResult = getByteLength(astrAttrib) > nLength;
                break;
            case 4:
                bResult = (getByteLength(astrAttrib) == nLength || getByteLength(astrAttrib) > nLength);
                break;
        }
        return bResult;
    }

    /**
     * Compare any two given dates.
     *
     * @param astrDD1 day part of first date
     * @param astrMM1 month part of the first date
     * @param astrYYYY1 year part ofr the first date
     * @param astrDD2 day part of second date
     * @param astrMM21 month part of the second date
     * @param astrYYYY2 year part ofr the second date
     * @return -1 if Date1 < Date2, 1 if Date1 > Date2, 0 if Date1 = Date2.
     */
    public static int compareDates(String astrDD1, String astrMM1, String astrYYYY1, 
    		String astrDD2, String astrMM2, String astrYYYY2) {

        int nDD1, nDD2, nMM1, nMM2, nYYYY1, nYYYY2;
        nYYYY2 = Integer.parseInt(astrYYYY2);
        nYYYY1 = Integer.parseInt(astrYYYY1);
        if (nYYYY2 > nYYYY1)
            return -1;
        else if (nYYYY2 < nYYYY1)
            return 1;
        nMM1 = Integer.parseInt(astrMM1);
        nMM2 = Integer.parseInt(astrMM2);
        if (nMM2 > nMM1)
            return -1;
        else if (nMM2 < nMM1)
            return 1;
        nDD1 = Integer.parseInt(astrDD1);
        nDD2 = Integer.parseInt(astrDD2);
        if (nDD2 > nDD1)
            return -1;
        else if (nDD2 < nDD1)
            return 1;
        return 0;
    }

    /**
     * Compare any two given times.
     *
     * @param astrDD1 day part of first date
     * @param astrMM1 month part of the first date
     * @param astrYYYY1 year part ofr the first date
     * @param astrDD2 day part of second date
     * @param astrMM21 month part of the second date
     * @param astrYYYY2 year part ofr the second date
     * @return -1 if Date1 < Date2, 1 if Date1 > Date2, 0 if Date1 = Date2.
     */
    public static int compareTimes(String astrDD1, String astrMM1, String astrYYYY1, 
    		String astrDD2, String astrMM2, String astrYYYY2) {

        int nDD1, nDD2, nMM1, nMM2, nYYYY1, nYYYY2;
        nYYYY2 = Integer.parseInt(astrYYYY2);
        nYYYY1 = Integer.parseInt(astrYYYY1);
        if (nYYYY2 > nYYYY1)
            return -1;
        else if (nYYYY2 < nYYYY1)
            return 1;
        nMM1 = Integer.parseInt(astrMM1);
        nMM2 = Integer.parseInt(astrMM2);
        if (nMM2 > nMM1)
            return -1;
        else if (nMM2 < nMM1)
            return 1;
        nDD1 = Integer.parseInt(astrDD1);
        nDD2 = Integer.parseInt(astrDD2);
        if (nDD2 > nDD1)
            return -1;
        else if (nDD2 < nDD1)
            return 1;
        return 0;
    }

    public static String forHidden(String s) {

        char[] buffer = s.toCharArray();

        StringBuffer newString = new StringBuffer(buffer.length + 30);

        for (int i = 0; i < buffer.length; i++) {

            if (buffer[i] == '<') {
                newString.append("&lt;");
            }
            else if (buffer[i] == '>') {
                newString.append("&gt;");
            }
            else if (buffer[i] == '"') {
                newString.append("&quot;");
            }
            else if (buffer[i] == '&') {
                newString.append("&amp;");
            }
            else

                newString.append(buffer[i]);

        }

        return newString.toString();

    }

    public static String escapeQuote(String s) {

        StringBuffer newStr = new StringBuffer();

        char[] buffer = s.toCharArray();

        for (int counter = 0; counter < buffer.length; counter++) {

            if (buffer[counter] == '\'')

                newStr.append("\\");

            newStr.append(buffer[counter]);

        }

        return newStr.toString();

    }

    /**
     * This method is used to split the parameter string from the struts-config file.
	 * The method will return an array of string elements form the 3rd element onwards for
	 * the convinience of the developer as the first two elements are used at other places.
     *
     * @param param		parameter
     * @param delim		the delimeter
     * @return String[] array of all parameter from the third position onwards
     */

    public static String[] getActionParameters(String param, String delim) {

        int position = 2;
        String[] parameters = splitParameters(param, delim);

        if (position > parameters.length - 1) {
            logger.debug("Position is greater than element in parameters");
            return null;
        }

        String[] result = new String[parameters.length - position];
        int index = 0;
        for (int i = position; i < parameters.length; i++) {
            result[index] = parameters[i];
            index++;
        }

        return result;

    }

    /**
     * split parameter by given delimeter
     *
     * @param param		parameter
     * @param delim		the delimeter
     * @return String array of all parameter
     */

    public static String[] splitParameters(String param, String delim) {

        StringTokenizer stk = new StringTokenizer(param, delim);
        int count = stk.countTokens();
        String[] result = new String[count];
        for (int i = 0; i < result.length; i++) {

            result[i] = stk.nextToken();
        }
        return result;

    }

    /**



     * split parameter by given delimeter and a give position
     *
     * @param param		parameter
     * @param delim		the delimeter
     * @param position	the postion of parameter after split
     * @return String of parameter
     */

    public static String splitParameters(String param, String delim, int position) {

        String[] result = splitParameters(param, delim);

        return result[position];

    }

    /** Method for replace specific string with given string
     *
     *	@param aString	original String
     *	@param aMatch	old String
     *	@param aReplace new String
     *	@return a new string resulting from replacing all occurrences of aMatch in aString with aReplace.
     */

    public static String replaceString(String aString, String aMatch, String aReplace) {

        String first = "";
        String result = "";
        int index = 0;
        int length = aMatch.length();
        if (aString == null || aMatch == null || aReplace == null) {
            //throw new NullPointerException();
            return aString;
        }
        while ((index = aString.indexOf(aMatch)) != -1) {
            first = aString.substring(0, index);
            aString = aString.substring(index + length);
            result = result + first + aReplace;
        }
        result = result + aString;
        return result;
    }

    /**
     *	use to check null and "" of the given String
     *	@return true if String is not null and not equal "" ,otherwise return false
     */

    public static boolean isValidString(String s) {
        if ((s != null) && !s.equals("")) {
            return true;
        }
        else
            return false;
    }

    /** Check blank string of the given String array
     *	@return true if one of the element in array is null and equal ""
     */

    public static boolean isBlank(String[] checkedString) {
        for (int i = 0; i < checkedString.length; i++) {
            if (checkedString[i] == null || checkedString[i].equals("")) {
                return true;
            }
        }
        return false;
    }

    /** Check blank string of the given String array
     *	@return true if every element in array is null and equal ""
     */

    public static boolean isAllBlank(String[] checkedString) {

        boolean flag = true;
        for (int i = 0; i < checkedString.length; i++) {
            String temp = checkedString[i];
            if ((checkedString[i] != null) && (!checkedString[i].equals(""))) {
                return false;
            }
        }
        return true;
    }


	public static String wordSegment(String source,int maxLength) {

		if (maxLength < 0) {
			  maxLength = 0;
		}
		StringBuffer out = new StringBuffer();
		BreakIterator boundary = BreakIterator.getWordInstance();
		boundary.setText(source);
		int start = boundary.first();

		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

			  String sub = source.substring(start,end);
			  if (sub.charAt(0) != ' ') {
				//if specify maxlength
				if(maxLength > 0){
					StringBuffer bufResult = new StringBuffer();
					StringBuffer buf = new StringBuffer();
					int subLength = sub.length();
					int count = 0;
					int i = 0;
					for (i=0; i < subLength; i++ ) {
						  count++;
						  //if word exceed maxlength
						  if (count == maxLength) {
								count = 0;
								buf.append(sub.charAt(i));
								StringBuffer tempBuf = new StringBuffer();
								tempBuf.append(StringUtil.htmlEncode( buf.toString() ));
								buf = tempBuf;
								if ( i != subLength - 1 ) {
									  buf.append("<br>");
								}

								bufResult.append(buf.toString());
								buf = new StringBuffer();
						  } else {
								buf.append(sub.charAt(i));
						  }

					}
					//append the rest of the word
					if (count < maxLength) {
						  StringBuffer tempBuf = new StringBuffer();
						  tempBuf.append(StringUtil.htmlEncode( buf.toString() ));
						  buf = tempBuf;
						  bufResult.append(buf.toString());
					}
					out.append(bufResult.toString());
				}else{//if not specify maxlength
					out.append(StringUtil.htmlEncode(sub));
				}
			  } else {
					out.append(sub.charAt(0));
					if (sub.length() > 1){
						out.append(StringUtil.htmlEncode(sub.substring(1)));
					}					
			  }
		}
		return out.toString();
	}

	public static String formatDecimal(String source, int maxFraction, Locale locale){
		double value = 0;
		try {
			value  = Double.parseDouble(source);
		}catch (Exception e) {
			logger.debug("cannot parse double");
		}
		
		DecimalFormat df;
		if(locale != null){
			df = (DecimalFormat)NumberFormat.getInstance(locale);
		}else{
			df = (DecimalFormat)NumberFormat.getInstance();
		}
		StringBuffer fraction = new StringBuffer();
		for (int i=0; i<maxFraction; i++) {
			if(i==0){
				fraction.append('.');
			}
			fraction.append('0');
		}
		df.applyPattern ("##,##0" + fraction.toString());

		return df.format(value);
	}

	public static String[] trimMultiList(String[] arr) {
		logger.debug("Enter trim Multilist");
		ArrayList arrList = new ArrayList();

		int size = arr.length;
		logger.debug("Size =" + size);
		for (int i=0; i<size; i++){
			logger.debug("arr(" + i + ")=" + arr[i] + "<");
			if (!(((String)arr[i]).trim().equals(""))){
				arrList.add(arr[i]);
			}
		}
		String[] foo = new String[0];
		return (String[])(arrList.toArray(foo));
	}
	
	/**
	 * Test two String for equality.
	 * <p>
	 * If only one of the two String is null, they are considered not equal. If both String are null, they
	 * are considered equal. 
	 * @param s1, s2 String to be tested for equality. 
	 * @return true - If two String are equal, otherwise false.
	 */
	public static boolean isEqual(String s1, String s2) {
		if ((s1 == null) && (s2 != null)) {
			return false;
		}
		if ((s1 != null) && (s2 == null)) {
			return false;
		}
		if ((s1 == null) && (s2 == null)) {
			return true;
		}
		return s1.equals(s2);
	}
	
	/**
	 * Join array elements with a string.
	 * <p>
	 * Returns a string containing a string representation of all the array elements in the same order, 
	 * with the glue string between each element. 
	 * @param glue Glue string
	 * @param pieces Array which its elements to be joined.
	 * @return string containing a string representation of all the array elements in the same order, 
	 * with the glue string between each element 
	 */
	public static String join(String glue, Object[] pieces) {
		int length = pieces.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(pieces[i]);
			if (i < length - 1) {
				sb.append(glue);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Perform null safe trim on given String.
	 * @param s Strign to be trim.
	 * @return trimmed String.
	 */
	public static String trim(String s) {
		if (s != null) {
			return s.trim();
		}
		return null;
	}
	
	/**
	 * Convert a Set of object to a set of String.
	 * <p>
	 * This method perform toString on each element of given Set of object. 
	 * @param objectSet Set of object.
	 * @return Set of String.
	 */
	public static Set toStringSet(Set objectSet) {
		logger.debug("Enter toStringSet: " + objectSet);
		if (objectSet == null) {
			return null;
		}
		
		Set result = new HashSet();
		for (Iterator i = objectSet.iterator(); i.hasNext(); ) {
			Object element = i.next();
			result.add(element.toString());
		}
		return result;
	}

}
