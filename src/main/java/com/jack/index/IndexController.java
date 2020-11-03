package com.jack.index;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class IndexController {

    private static Map<Object,Object> map = new HashMap<>();
    private static Map<Object,Integer> sessionMap = new HashMap<>();

    @RequestMapping({"/"})
    @ResponseBody
    public Object index(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = session.getId();
        Integer cnt = sessionMap.get(id);
        if(Objects.isNull(cnt)){
            cnt = 0;
        }
        map.put(++cnt,cnt*cnt);

        sessionMap.put(id,cnt);
        return map;
    }

    @GetMapping("/testth")
    public String testth(Model model){
        String s = "LYY";
        model.addAttribute("s",s);
        return "index";
    }

}
