package me.majiajie.okhttp.f;

import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp工具类<p>
 * 所有请求全都采用异步
 */
public class OkHttpUtil
{
    private OkHttpUtil() {}

    private final static OkHttpClient mOkHttpClient;

    private static Headers mHeader;

    private static final MediaType TYPE_DEFUALT = MediaType.parse("application/x-www-form-urlencoded");

    private static final MediaType TYPE_JSON = MediaType.parse("application/json");

    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    private static final int TIME_OUT = 25_000;

    static
    {
        SSLContext  sslContext = null;
        try {
            sslContext = setCertificates(new FileInputStream("E:\\github\\web\\okhttp\\src\\main\\resources\\server.cer"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslContext.getSocketFactory())
                .build();
    }

    /**
     *
     * @param request
     * @param callback
     */
    public static void doPost(Request request, OkHttpCallBack callback)
    {

    }

    public static void doPost(String url,Map<String,String> bodyParams, OkHttpCallBack callback)
    {
        buildPostRequest(url,bodyParams,callback);
    }

    private static void buildPostRequest(String url,Map<String,String> bodyParams, OkHttpCallBack callback)
    {
        String body = encodeParameters(bodyParams,DEFAULT_PARAMS_ENCODING);

        RequestBody requestBody = RequestBody.create(TYPE_DEFUALT,body);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        asynchronous(request,callback);
    }

    public static void asynchronous(Request request,OkHttpCallBack callback){
        Call call = mOkHttpClient.newCall(request);

        try {
            callback.onResponse(call,call.execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对数据进行编码，并转成HTTP传递参数的格式
     * @param params            键值对参数
     * @param paramsEncoding    编码
     * @return  转换完成的字符串
     */
    private static String encodeParameters(Map<String, String> params, String paramsEncoding)
    {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.delete(encodedParams.length()-1,encodedParams.length()).toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }


    /**
     * 用自签名证书生成SSLContext
     * @param certificates
     * @return
     */
    private static SSLContext setCertificates(InputStream... certificates)
    {
        SSLContext sslContext = null;
        try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates)
            {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                if (certificate != null){
                    certificate.close();
                }
            }

            SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);

            sslContext.init(null,trustManagerFactory.getTrustManagers(),new SecureRandom());

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return sslContext;
    }
}
