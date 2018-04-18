package cn.javass.chapter6.web.controller.paramtype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.javass.chapter6.model.SchoolInfoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.javass.chapter6.model.DataBinderTestModel;
import cn.javass.chapter6.model.UserModel;


/**@ModelAttribute 用法： 绑定请求参数到命令对象
 *
 * ①和②有同名的命令对象，那 Spring Web MVC 内部如何处理的呢：
 * (1、首先执行@ModelAttribute 注解的方法，准备视图展示时所需要的模型数据；@ModelAttribute 注解方法形式参数规则和@RequestMapping 规则一样，如可以有@RequestParam 等；
 * (2、执行@RequestMapping 注解方法，进行模型绑定时首先查找模型数据中是否含有同名对象，如果有直接使用，如果没有通过反射创建一个，因此②处的 user 将使用①处返回的命令对象。即②处的 user 等于①处的 user。
 * */
@Controller
@RequestMapping("/method/param/annotation")
public class ModelAttributeTypeController {

//   ModelAttribute： 二、暴露表单引用对象为模型数据
    /**代码会在执行功能处理方法之前执行，并将其自动添加到模型对象中在功能处理方法中
     * 调用 Model 入参的containsAttribute("cityList")将会返回 true
     */
    @ModelAttribute("cityList")
    public List<String> cityList() {
        return Arrays.asList("北京", "山东");
    }

    @ModelAttribute("user")  //①
    public UserModel getUser(@RequestParam(value="username", defaultValue="") String username) {
        //TODO 去数据库根据用户名查找用户对象
        UserModel user = new UserModel();
        user.setUsername("bryant");
        user.setRealname("zhang");
        return user;
    }

//  ModelAttribute：  一、绑定请求参数到命令对象
    @RequestMapping(value="/model1") //②
    public String test1(@ModelAttribute("user") UserModel user, Model model) {
        System.out.println(model.containsAttribute("cityList"));
        System.out.println(user);
        return "success";
    }
    
//    http://localhost:8080/springmvc-chapter6/method/param/annotation/model2/username=wang?username=zhang&bool=yes&schooInfo.specialty=computer&hobbyList[0]=program&hobbyList[1]=music&map[key1]=value1&map[key2]=value2&state=blocked
    @RequestMapping(value="/model2/{username}")
    public String test2(@ModelAttribute("model") DataBinderTestModel model) {
        System.out.println(model);
        return "success";
    }

//    三、暴露@RequestMapping 方法返回值为模型数据
    @RequestMapping(value="/model3")
    public @ModelAttribute("user3") UserModel test3(@ModelAttribute("user2") UserModel user) {

        user.setUsername("鳌拜");
        user.setPassword("888888");
        user.setRealname("苏完瓜尔佳氏");

        UserModel user2 = new UserModel();
        user2.setUsername("rose");
        user2.setPassword("123456");
        user2.setRealname("zhang");
        user2.setSchoolInfo(new SchoolInfoModel("Tsinghua","University","Software"));

//        return user;
        return user2;
    }

    
    @RequestMapping(value="/model4")
    public String test4(@ModelAttribute UserModel user4, Model model) {
        System.out.println(model.containsAttribute("userModel"));
        System.out.println(model.containsAttribute("user4"));
        return "success";
    }
    @RequestMapping(value="/model5")
    public String test5(UserModel user, Model model) {
        System.out.println(model.containsAttribute("userModel"));
        return "success";
    }
    @RequestMapping(value="/model6")
    public @ModelAttribute List<String> test6() {
        return Arrays.asList("山东", "北京");
    }
    @RequestMapping(value="/model7")
    public @ModelAttribute List<UserModel> test7() {
        return Arrays.asList(new UserModel(), new UserModel());
    }
    
    @RequestMapping(value="/model8")
    public @ModelAttribute Map<String, UserModel> test8() {
        HashMap map1 = new HashMap<String, UserModel>();
        UserModel user8 = new UserModel();
        user8.setUsername("hahaha");
        user8.setPassword("111111");
        user8.setRealname("hehehe");
        map1.put("user8",user8);
        return map1 ;
    }
}
