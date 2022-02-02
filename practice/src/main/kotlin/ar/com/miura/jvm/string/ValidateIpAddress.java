package ar.com.miura.jvm.string;

public class ValidateIpAddress {

    private static final String NONE = "Neither";
    private static final String V4 = "IPv4";
    private static final String V6 = "IPv6";

    public String validIPAddress(String queryIP) {

        if (queryIP==null || queryIP.equals("")) {
            return NONE;
        }

        if (queryIP.indexOf(".")>=0) {
            long count = queryIP.chars().filter(ch -> ch == '.').count();
            if (count==3) {
                return validateV4(queryIP);
            }
        } else {
            long count = queryIP.chars().filter(ch -> ch == ':').count();
            if (count==7) {
                return validateV6(queryIP);
            }

        }

        return NONE;

    }

    private String validateV4(String ip) {

        String[] splitted = ip.split("\\.");

        if (splitted.length!=4) {
            return NONE;
        }

        for(String string:splitted) {

            if (string.length()==0 || string.length()>=4) {
                return NONE;
            }

            if (string.charAt(0)=='0' && string.length()!=1) {
                return NONE;
            }

            for(char c:string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return NONE;
                }
            }

            Integer parsed = Integer.parseInt(string);
            if (parsed<=-1||parsed>=256) {
                return NONE;
            }
        }

        return V4;
    }

    private String validateV6(String ip) {

        String[] nums = ip.split("\\:");

        if (nums.length!=8) {
            return NONE;
        }

        String hexDigits = "0123456789abcdefABCDEF";
        for(String num:nums) {
            if (num.length()==0 || num.length()>=5) {
                return NONE;
            }
            for(char aChar:num.toCharArray()) {
                if (hexDigits.indexOf(aChar)==-1) {
                    return NONE;
                }
            }
        }
        return V6;
    }
}
