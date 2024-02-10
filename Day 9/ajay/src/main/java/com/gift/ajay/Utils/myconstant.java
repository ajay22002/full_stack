package com.gift.ajay.Utils;

import java.util.*;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.*;
import org.springframework.http.HttpMethod;

public class myconstant
{

    // ADMIN
    public static final String AUTH="/api/v1/auth";
    public static final String USERS="/api/v1/users";
    public static final String REGISTER="/register";
    public static final String LOGIN="/login";

    // USER
    public static final String GIFTS="/api/v1/users/gift";
    public static final String LIST="/list";
    public static final String DELETEUSER="/delete";
    public static final String UPDATEUSER="/update";
    
    
    // GIFT
    public static final String SHOWGIFT="/all";
    public static final String ADDGIFT="/add";
    public static final String DELETEGIFT= "/delete";
    public static final String UPDATEGIFT= "/update";

    // CART
    public static final String CART = "/api/v1/users/cart";
    public static final String SHOWCART= "/all";
    public static final String ADDCART= "/add";
    public static final List<String> ORGINS=Arrays.asList("http://localhost:4000");
    public static final List<String> HEADERS=Arrays.asList(AUTHORIZATION, CONTENT_TYPE);
    public static final List<String> METHODS=Arrays.asList(GET.name(),POST.name(),PUT.name(),PATCH.name(),DELETE.name(), HttpMethod.HEAD.name());
    
    // SWAGGER
    public static final String SWAGGER_LOCALHOST_URL="http://localhost:8181";
    public static final String SWAGGER_SECURITY_SCHEME_NAME="bearerAuth";
    public static final String SWAGGER_SCHEME="bearer";
    public static final String SWAGGER_BEARER_FORMAT="JWT";
    public static final String SWAGGER_DESCRIPTION="Produce a Json Web Token.";

}