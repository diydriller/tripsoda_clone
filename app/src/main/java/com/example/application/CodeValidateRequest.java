package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CodeValidateRequest extends StringRequest {
    final static private String url="http://dhrhd080.cafe24.com/CodeValidate.php";
    private Map<String,String> parameters;

    public CodeValidateRequest(String userCode, Response.Listener<String> listener){
        super(Method.POST,url,listener,null);
        parameters=new HashMap<>();
        parameters.put("userCode",userCode);
    }
    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
