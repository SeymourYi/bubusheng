package com.example.demo.controller;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;

import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.Md5Util;
import com.example.demo.utils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class userController {
@Autowired
    private UserService userservice;
@PostMapping("/register")
public Result<String> register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){


          User u=userservice.findbyUserName(username);
          if(u==null){
              //可以注册
              userservice.register(username,password);
              return Result.success();
          }else {
              //不可以注册
              return Result.fail("用户名已经被占用");
          }
}
@PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
     User u=userservice.findbyUserName(username);
     if(u==null){
         return Result.fail("用户名错误");
     }else {
         if(Md5Util.getMD5String(password).equals(u.getPassword())){
             Map<String,Object> map=new HashMap<>();
             map.put("id",u.getId());
             map.put("username",u.getUsername());
             String token = JwtUtil.genToken(map);
             return Result.success(token);
         }
         return Result.fail("密码错误");
     }
}

@GetMapping("/userinfo")
public Result<User> UserInfo( String token){
//  Map<String,Object> map = JwtUtil.parseToken(token);
//  String username = (String)map.get("username");
   Map<String,Object> map = ThreadLocalUtil.get();
   String username = (String) map.get("username");
  User user=userservice.findbyUserName(username);
  return Result.success(user);
}
@PutMapping("/update")
    public Result<String> update(@RequestBody @Validated User user){
    userservice.update(user);
    return Result.success();
}
@PatchMapping("/updateAvtar")
public Result updateAvtar(@RequestParam @URL String avatarUrl){
   Map<String,Object> map=ThreadLocalUtil.get();
 Integer  id= (Integer) map.get("id");
userservice.updateAvatar(avatarUrl,id);
return Result.success();
}
@PatchMapping("/updatepwd")
public Result updatepwd(@RequestBody Map<String,String> params){
   String oldpwd = params.get("old_pwd");
   String newpwd = params.get("new_pwd");
   String repwd = params.get("re_pwd");
   if(!StringUtils.hasLength(oldpwd) || !StringUtils.hasLength(newpwd) || !StringUtils.hasLength(repwd)){
       return  Result.fail("缺少必要的参数");
   }
   Map<String,Object> map=ThreadLocalUtil.get();
   String username = (String) map.get("username");
  User user = userservice.findbyUserName(username);
    if (!user.getPassword().equals(Md5Util.getMD5String(oldpwd))) {
        return  Result.fail("原密码填写错误");
    }
    if (!repwd.equals(newpwd)) {
        return  Result.fail("两次密码不一致");

    }
    userservice.updatePwd(newpwd);
    return Result.success();
}
}
