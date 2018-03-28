package cn.javass.chapter6.web.controller.paramtype;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import cn.javass.chapter6.model.UserModel;

@Controller
@RequestMapping("/method/param/annotation")
//1、在控制器类头上添加@SessionAttributes注解
@SessionAttributes(value = {"user"}, types={})    //① 标识 模型对象中名字如果是“user”将存储在会话范围，并自动暴露到模型数据中
public class SessionAttributeController {

    //2、@ModelAttribute注解的方法 进行表单引用对象的创建
    @ModelAttribute("user")    //② 如果模型数据中没有名字为user的对象，调用该方法并存储到模型数据中
    public UserModel initUser() {
        return new UserModel();
    }
    //3、@RequestMapping注解方法的 @ModelAttribute注解的参数进行命令对象的绑定
    @RequestMapping("/session1")   //③ 首先查找模型数据中是否有user对象，有直接使用，没有则创建一个，并将请求参数绑定到该对象上
    public String session1(@ModelAttribute("user") UserModel user, ModelMap model, WebRequest request, SessionStatus status) {
        System.out.println(user == model.get("user"));
        user.setUsername("zhang");
        return "success";
    }
    //4、通过SessionStatus的setComplete()方法清除@SessionAttributes指定的会话数据
    @RequestMapping("/session2")   //③
    public String session(@ModelAttribute("user") UserModel user, ModelMap model, WebRequest request, SessionStatus status) {
        System.out.println(user == request.getAttribute("user", WebRequest.SCOPE_SESSION));
        System.out.println(user == model.get("user"));
        System.out.println(user);
        if(true) { //④如果会话可以终止了，就 标识会话结束，可以清理掉会话数据了
            status.setComplete();
        }
        return "success";
    }
}
