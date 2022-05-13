package edu.uoc.backendteam.paracasa.config.filter;

public class Constants {


    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "https://multimedia.europarl.europa.eu";
    public static final String SUPER_SECRET_KEY = "ca88b06a-8140-449f-820c-7a8a01c24391";
    public static final long TOKEN_EXPIRATION_TIME = 60*60*1000; // 1 hora
}
