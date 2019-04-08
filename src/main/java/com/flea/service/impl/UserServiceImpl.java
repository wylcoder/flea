package com.flea.service.impl;

import com.flea.common.ServerResponse;
import com.flea.dao.UserOriginalInfoMapper;
import com.flea.pojo.UserOriginalInfo;
import com.flea.service.IUserService;
import com.flea.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserOriginalInfoMapper userOriginalInfoMapper;

    @Override
    public ServerResponse login(String phone_number, String password) {
        /**
         * 检查用户名是否存在
         * */
        int result = userOriginalInfoMapper.checkPhoneNumber(phone_number);
        if (result == 0){
            return ServerResponse.serverResponseByError("用户不存在");
        }
        /**
         * 根据用户名和密码查找用户
         * */
        UserOriginalInfo userOriginalInfo = userOriginalInfoMapper.selectUserInfoByphoneNumberAndPassword(phone_number, MD5Utils.MD5Encode(password,"utf-8"));
        if (userOriginalInfo == null){
            return ServerResponse.serverResponseByError("密码错误");
        }
        userOriginalInfo.setPassword("");
        return ServerResponse.serverResponseBySuccess(userOriginalInfo);
    }

    @Override
    public ServerResponse register(UserOriginalInfo userOriginalInfo) {
        int result = userOriginalInfoMapper.checkPhoneNumber(userOriginalInfo.getPhoneNumber());
        if (result != 0){
            return ServerResponse.serverResponseByError("号码存在");
        }
        userOriginalInfo.setPassword(MD5Utils.MD5Encode(userOriginalInfo.getPassword(), "utf-8"));
        int count = userOriginalInfoMapper.insert(userOriginalInfo);
        if (count > 0){
            return ServerResponse.serverResponseBySuccess("注册成功");
        }else {
            return ServerResponse.serverResponseByError("注册失败");
        }
    }
}
