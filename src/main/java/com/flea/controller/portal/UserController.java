package com.flea.controller.portal;

import com.flea.common.Const;
import com.flea.common.ServerResponse;
import com.flea.pojo.UserOriginalInfo;
import com.flea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService userService;
    /**
     * 登录
     * */
    @RequestMapping(value = "/login.do")
    public ServerResponse login(HttpSession session, @RequestParam("phone_number") String phone_number,
                                @RequestParam("password") String password){
        ServerResponse serverResponse = userService.login(phone_number, password);
        if (serverResponse.isSuccess()){
            UserOriginalInfo userOriginalInfo = (UserOriginalInfo) serverResponse.getData();
            session.setAttribute(Const.CURRENTUSER, userOriginalInfo);
        }
        return serverResponse;
    }

    @RequestMapping(value = "/register.do")
    public ServerResponse register(HttpSession session, UserOriginalInfo userOriginalInfo){
        ServerResponse serverResponse = userService.register(userOriginalInfo);
        return serverResponse;
    }

}
