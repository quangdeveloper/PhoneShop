package vn.nsi.iphoneshop.util;


import org.apache.commons.lang3.RandomStringUtils;

public class GenerateCode {

    public static String generateOTP(){
        return RandomStringUtils.randomNumeric(6);
    }
}
