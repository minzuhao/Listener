package com.zdy.util;

import com.zdy.entity.User;

import java.util.ArrayList;

/**
 * Created by zdy on 2017/1/3 0003.
 */
public class SessionUtil {

    public static Object getUsersBySessionId(ArrayList<User> userList,String sessionId) {
        for (int i=0;i<userList.size();i++){
            User user=userList.get(i);
            if (user.getSessionId().equals(sessionId)){
                return user;
            }
        }
        return null;
    }
}
