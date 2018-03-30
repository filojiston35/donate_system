/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Yusuf
 */
public class HashPassword {
    
    public String HashPassword(String password) throws NoSuchAlgorithmException
    {
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] b=md.digest();
        StringBuffer sb=new StringBuffer();
        for(byte b1:b)
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        
        return sb.toString();
    }
}
