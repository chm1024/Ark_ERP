package com.micolor.module.system.login.action;


import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.listener.SessionListener;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by geyupeng on 16/1/2.
 */

@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/")
public class ActionLogin extends BaseActionSupport {
    private String account;
    private String password;
    private boolean rememberMe;
    private String errorMsg;

    @Action(
            value = "login",
            results = {
                    @Result(name = "success", location = "main", type = "redirectAction"),
                    @Result(name = "error", location = "loginerror", type = "chain")
            }
    )
    @Override
    public String execute() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        //验证shiro
        UsernamePasswordToken token = new UsernamePasswordToken(account, password, rememberMe, super.getRequest().getRemoteHost());
        try {
            currentUser.login(token);
        } catch (IncorrectCredentialsException incorrectCredentialsException) {
            errorMsg = "账号[" + account + "]所输入的密码不正确";
            incorrectCredentialsException.printStackTrace();
            return ERROR;
        } catch (LockedAccountException lke) {
            lke.printStackTrace();
            errorMsg = "账号[" + account + "]已被锁定,请联系网站管理员";
            return ERROR;
        } catch (UnknownAccountException uae) {
            uae.printStackTrace();
            errorMsg = "系统中不存在账号[" + account + "],请联系网站管理员";
            return ERROR;
        } catch (ExcessiveAttemptsException excessiveAttemptsException) {
            errorMsg = "账号[" + account + "],已被限制登录1小时,请稍后重试.";
            excessiveAttemptsException.printStackTrace();
            return ERROR;
        } catch (AuthenticationException ae) {
            errorMsg = "账号[" + account + "],未能通过验证.";
            ae.printStackTrace();
            return ERROR;
        } catch (Exception e) {
            errorMsg = "奇怪的问题被捕捉到,信息:" + e.getMessage();
            e.printStackTrace();
            return ERROR;
        }

        if (currentUser.isAuthenticated()) {
            if (!SessionListener.isLogining(account)) {
                SessionListener.createUserSession(super.getRequest().getSession(),
                        account);
            } else {
                if (SessionListener.isOnline(super.getRequest().getSession())) {
                    //当前用户不在线,即session已经被剔除
                    SessionListener.removeUserSession(account);
                    SessionListener.createUserSession(super.getRequest().getSession(),
                            account);
                } else {
                    SessionListener.replaceUserSession(super.getRequest().getSession(),
                            account);
                }
            }
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}