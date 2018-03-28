package cn.javass.chapter6.web.controller.paramtype;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/method/param/annotation")
public class PathVariableTypeController {
    
    @RequestMapping(value="/users/{userId}/topics/{topicId}/params/{param3}")
    public String test(
            @PathVariable(value="userId") int userId, 
            @PathVariable(value="topicId") int topicId,
            @PathVariable(value = "param3") String param3
            ) {
        
        System.out.println(userId + ", " + topicId + ", " + param3.toString());
        
        return "success";
    }

    @RequestMapping(value="/users/{userId}/topics/{topicId}")
    public String test2(
            @PathVariable(value="userId") int userId,
            @PathVariable(value="topicId") int topicId
    ) {

        System.out.println(userId + ", " + topicId);
        return "success";
    }

}
