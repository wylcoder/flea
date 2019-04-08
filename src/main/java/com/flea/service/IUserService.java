package com.flea.service;

import com.flea.common.ServerResponse;
import com.flea.pojo.UserOriginalInfo;

public interface IUserService {
    ServerResponse login(String phone_number, String password);

    ServerResponse register(UserOriginalInfo userOriginalInfo);
}
