package com.alex.loginjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;

/**
 * @author alex
 * @version 1.0
 * @description: JWT工具类
 * @date 2023/1/19 14:39
 */
public final class JwtUtil {

    /**
     * 这个密钥是防止JWT被篡改的关键，绝不能泄露 *
     */
    private final static String secretKey = "abbaaaaddd11234";

    /**
     * 过期时间目前设置为2天，这个配置虽业务需求而定 *
     */
    private final static Duration expiration = Duration.ofHours(2);

    /**
     * 生成JWT *
     * @param userName 用户名
     * @return JWT token
     */
    public static String generate(String userName){

        // 过期时间
        Date expiryDate = new Date(System.currentTimeMillis()+expiration.toMillis());
        return Jwts.builder()
                .setSubject(userName)       // 将username 放进JWT
                .setIssuedAt(new Date())    // 设置JWT签发时间
                .setExpiration(expiryDate)  // 设置过期时间
                .signWith(SignatureAlgorithm.HS512,secretKey) // 设置加密算法和密钥
                .compact();
    }

    /**
     * 解析JWT *
     * @param token
     * @return 解析成功返回Claims对象，解析失败返回null
     */
    public static Claims parse(String token){
        // 如果是空字符串
        if(StringUtils.isEmpty(token)){
            return null;
        }
        Claims claims = null;
        // 解析失败了会抛出异常，所以我们要捕捉一下，token过期、token非法都会导致解析失败
        try{
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (JwtException e){
            // 这里应该用日志输出，为了方便演示就直接打印了
            System.err.println("解析失败");
        }
        return claims;

    }

}
