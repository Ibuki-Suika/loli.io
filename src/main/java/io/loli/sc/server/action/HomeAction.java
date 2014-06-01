package io.loli.sc.server.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@Named
@RequestMapping(value = { "/" })
public class HomeAction {

    @RequestMapping(value = { "/" })
    public String index() {
        return "index";
    }

    @RequestMapping(value = { "/download" })
    public String download(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        List<String> list = new ArrayList<>();
        String current = getOs(userAgent);
        list.add("Windows");
        list.add("Mac");
        list.add("Linux");
        list.remove(current);
        request.setAttribute("list", list);
        request.setAttribute("current", current);
        return "download";
    }

    private String getOs(String userAgent) {
        if (userAgent.contains("Windows")) {
            return "Windows";
        } else if (userAgent.contains("Linux")) {
            return "Linux";
        } else if (userAgent.contains("Mac")) {
            return "Mac";
        } else {
            return "";
        }
    }
}