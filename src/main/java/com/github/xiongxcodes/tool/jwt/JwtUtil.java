package com.github.xiongxcodes.tool.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    public static void main(String[] args) {
        String ddString = JwtUtil.createJwt("aaaa", "bbbb", new HashMap<String, Object>(), 600l, "abcdefgsfsdfsdfds");
        System.out.println(ddString);

        // HttpUtil.

        // System.out.println(JwtUtil.parseJwt(ddString));
    }

    public static Claims parseJwt(String token, String secretKey) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims;
    }

    public static String createJwt(String id, String subject, Map<String, Object> claims, Long expirationTime,
        String secretKey) {
        // 1.设置失效时间
        long nowTime = System.currentTimeMillis();// 当前毫秒
        expirationTime = nowTime + expirationTime * 1000;
        // 2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder();
        // 3.根据map设置claims
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        // 当设置的是整个map时，就需放在最前面，下面的setId等参数才会有效，否则会把前面set的值置空
        jwtBuilder.setHeader(header);
        jwtBuilder.setClaims(claims);
        jwtBuilder.setId(id);
        jwtBuilder.setSubject(subject);
        jwtBuilder.setIssuedAt(new Date(nowTime));// 设置当前时间
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);// 设置加密方式
        jwtBuilder.setExpiration(new Date(expirationTime));// 设置过期时间
        // 4.创建token
        String token = jwtBuilder.compact();
        return token;
    }
}
