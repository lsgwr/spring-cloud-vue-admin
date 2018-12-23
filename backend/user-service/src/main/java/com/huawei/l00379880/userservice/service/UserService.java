package com.huawei.l00379880.userservice.service;

import com.huawei.l00379880.userservice.client.AuthServiceClient;
import com.huawei.l00379880.userservice.dao.UserDao;
import com.huawei.l00379880.userservice.dto.LoginDTO;
import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.userservice.entity.JWT;
import com.huawei.l00379880.userservice.entity.User;
import com.huawei.l00379880.common.exception.CommonException;
import com.huawei.l00379880.common.exception.ErrorCode;
import com.huawei.l00379880.userservice.util.BPwdEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthServiceClient authServiceClient;

    public User createUser(User user){
      return  userDao.save(user);
    }

    public User getUserInfo(String username){
        return userDao.findByUsername(username);
    }
    public RespDTO login(String username , String password){
       User user= userDao.findByUsername(username);
       if(null==user){
           throw new CommonException(ErrorCode.USER_NOT_FOUND);
       }
       if(!BPwdEncoderUtils.matches(password,user.getPassword())){
           throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
       }

        JWT jwt = authServiceClient.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);
        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return RespDTO.onSuc(loginDTO);
    }
}
