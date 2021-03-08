package org.geektimes.projects.user.web.controller;

import org.apache.commons.lang.StringUtils;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @description: 注册用户接口
 * @author: yaochaochen
 * @since: 2021/3/8
 */
@Path("/register")
public class RegisterController implements PageController {

    private final UserService userService = new UserServiceImpl(new DatabaseUserRepository());


    @POST
    @Path("/submit")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {


        //获取用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //校验用户名和密码是否输入
        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)) {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            user.setEmail(email);
            return userService.register(user) ? "success.jsp" : "error.jsp";
        }
        return "error.jsp";
    }
}
