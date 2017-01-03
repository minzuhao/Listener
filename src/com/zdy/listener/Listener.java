package com.zdy.listener; /**
 * Created by zdy on 2017/1/3 0003.
 */

import com.zdy.entity.User;
import com.zdy.util.SessionUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

import static com.zdy.util.SessionUtil.getUsersBySessionId;

@WebListener()
public class Listener implements HttpSessionListener {
    private int userNumber=0;
    public Listener() {
    }
    public void sessionCreated(HttpSessionEvent se) {
      userNumber++;
      se.getSession().getServletContext().setAttribute("userNumber",userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      userNumber--;
      se.getSession().getServletContext().setAttribute("userNumber",userNumber);
      ArrayList<User> userList=null;
      userList=(ArrayList<User>)se.getSession().getServletContext().getAttribute("userList");
      if (getUsersBySessionId(userList,se.getSession().getId())!=null){
          userList.remove(getUsersBySessionId(userList,se.getSession().getId()));
      }
    }
}
