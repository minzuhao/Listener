package com.zdy.listener; /**
 * Created by zdy on 2017/1/3 0003.
 */

import com.zdy.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.zdy.util.SessionUtil.getUsersBySessionId;

@WebListener()
public class ServletRequestListener implements javax.servlet.ServletRequestListener {


    private ArrayList<User> userList;
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        userList = (ArrayList<User>)servletRequestEvent.getServletContext().getAttribute("userList");
        if (userList==null){
            userList=new ArrayList<User>();
        }
        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();
        String sessionId=request.getSession().getId();
        if (getUsersBySessionId(userList,sessionId)==null){
            User user=new User();
            user.setSessionId(sessionId);
            user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIp(request.getRemoteAddr());
            userList.add(user);
        }
        servletRequestEvent.getServletContext().setAttribute("userList",userList);
    }

}
