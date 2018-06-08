package cn.roilat.study.j2ee.http.clientpool;

/**
 * HTTP璇锋眰鐩稿叧鐨勫父閲忕鐞嗙被 Created by guowei.lu on 2016-9-29.
 */
public abstract class HttpConstants {

    public static final String X_HMAC_AUTH_API_KEY_HEADER       = "apiKey";
    public static final String X_HMAC_AUTH_SIGNATURE_HEADER     = "X-Hmac-Auth-Signature";
    public static final String X_HMAC_AUTH_TIMESTAMP_HEADER     = "X-Hmac-Auth-Timestamp";
    public static final String X_HMAC_AUTH_VERSION_HEADER       = "X-Hmac-Auth-Version";
    public static final String X_HMAC_AUTH_IP_HEADER            = "X-Hmac-Auth-IP";
    public static final String X_HMAC_AUTH_MAC_HEADER           = "X-Hmac-Auth-MAC";
    public static final String X_HMAC_AUTH_ALGORITHM_HEADER     = "X-Hmac-Auth-Algorithm";
    public static final String X_HMAC_AUTH_ALGORITHM_MD5        = "md5";
    /**
     * 璇锋眰鍞竴闅忔満鏁帮紝鐢ㄤ簬闃叉缃戠粶閲嶆斁鏀诲嚮銆�
     */
    public static final String X_HMAC_AUTH_NONCE_HEADER         = "X-Hmac-Auth-Nonce";
    /************************************** OAUTH *******************************************/
    public static final String REQUEST_PARAMS_OAUTH_APPCODE     = "__appcode";
    public static final String REQUEST_PARAMS_OAUTH_ACCESSTOKEN = "__accesstoken";
    /**
     * Horizontal tab
     */
    public static final byte   HT                               = 9;

    /**
     * Equals '='
     */
    public static final byte EQUALS = 61;

    /**
     * Colon ':'
     */
    public static final byte COLON = 58;

    /**
     * Semicolon ';'
     */
    public static final byte SEMICOLON = 59;

    /**
     * Comma ','
     */
    public static final byte COMMA = 44;

    /**
     * Double quote '"'
     */
    public static final byte DOUBLE_QUOTE        = '"';
    /**
     * 璇锋眰缁熶竴瓒呮椂鏃堕棿
     */
    public static final int  HTTP_CLIENT_TIMEOUT = 5000;
}

