package com.ofocompany.common.net

import android.text.TextUtils;

import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *@author ofo
 *
 */
public class SysParameters {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private String ver;
    private int id;
    private String token;
    private LinkedHashMap<String, Object> mParams = new LinkedHashMap<String, Object>();

    public SysParameters(String ver, int id, String token) {
        this.ver = ver;
        this.id = id;
        this.token = token;
    }

    public String getVer() {
        return ver;
    }
    public int getId() {
        return id;
    }
    public String getToken() {
        return token;
    }

    public void setParams(LinkedHashMap<String, Object> params) {
        this.mParams = params;
    }

    /**
     * json style
     *
     */
    public void add(String key, String value) {
        this.mParams.put(key, value);
    }
    
    public void add(String key, int value) {
        this.mParams.put(key,  String.valueOf(value));
    }
    
    public void add(String key, long value) {
        this.mParams.put(key, String.valueOf(value));
    }
    
    public void add(String key, Object value) {
        this.mParams.put(key, value.toString());
    }

    public Object get(String key) {
        return this.mParams.get(key);
    }

    public void remove(Stirn key) {
        if (mParams.containsKey(key)) {
            this.mParams.remove(key);
            this.mParams.remove(this.mParams.get(key));
        }
    }

    public boolean containsKey(String value) {
        return this.mParams.containsKey(value);
    }

    public int size() {
        return this.params.size();
    }

    /**
     * 返回url
     */
    public String encodeUrl() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String key : this.mParams.keySet()) {
            if (first) first = false;
            else sb.append("&");

          Object value = this.mParams.get(key);
            if ((value instanceof String)) {
                String param = (String)value;
                if (!TextUtils.isEmpty(param)) {
                    try {
                        sb.append(URLEncoder.encode(key, "UTF-8") + "=" + 
                        URLEncoder.encode(param, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * return parameters
     */
    public List<BasicNameValuePair> getBasicNameValuePairs() {
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        for (String key : this.mParams.keySet()) {
            Object value = this.mParams.get(key);
            if ((value instanceof String)) {
                String param = (String)value;
                BasicNameValuePair bParam = new BasicNameValuePair(key, param);
                list.add(bParam);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "{ver="+ver+", id="+id+", token="+token+"}"+mParams.toString();
    }
}
