package com.shy.util;


import java.io.IOException;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 加密
 * @author Administrator
 *
 */
public class EncryptUtil {
    private static Log log = LogFactory.getLog(EncryptUtil.class);

    //~ Methods ================================================================

    public static String encode(String text, String algorithm) {
        byte[] unencodedText = text.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            log.error("Exception: " + e);

            return text;
        }

        md.reset();

        md.update(unencodedText);

        // now calculate the hash
        byte[] cryptograph = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < cryptograph.length; i++) {
            if (((int) cryptograph[i] & 0xff) < 0x10) {
                buf.append('0');
            }

            buf.append(Long.toString((int) cryptograph[i] & 0xff, 16));
        }

        return buf.toString();
    }

    /**
     * Encode a string using Base64 encoding. Used when storing passwords
     * as cookies.
     *
     * This is weak encoding in that anyone can use the decodeString
     * routine to reverse the encoding.
     *
     * @param str
     * @return String
     */
    @SuppressWarnings("restriction")
	public static String encodeString(String str)  {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        return encoder.encodeBuffer(str.getBytes()).trim();
    }

    /**
     * Decode a string using Base64 encoding.
     *
     * @param str
     * @return String
     */
    @SuppressWarnings("restriction")
	public static String decodeString(String str) {
        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
        try {
            return new String(dec.decodeBuffer(str));
        } catch (IOException io) {
        	throw new RuntimeException(io.getMessage(), io.getCause());
        }
    }
}

