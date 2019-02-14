/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Random;

import java.util.Random;

/**
 *
 * @author HaiDang
 */
public class RandomString {

    final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rd = new Random();
    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
