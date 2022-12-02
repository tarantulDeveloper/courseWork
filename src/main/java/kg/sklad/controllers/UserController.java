package kg.sklad.controllers;

import kg.sklad.entities.User;
import kg.sklad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/activation/{activation}")
    public String activateUser(@PathVariable(value = "activation") String code) {
        return userService.activateUser(code);
    }

    //Cookie part
    @GetMapping("/set-cookie")
    public ResponseEntity<?> setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("loved", "Bermet");
        cookie.setPath("/yep");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        response.setContentType("text/plain");
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/get-cookie")
    public ResponseEntity<?> getCookie(@CookieValue("loved") String data) {
        return ResponseEntity.ok().body(data);
    }

    //Headers part
    @GetMapping("/get-headers")
    public ResponseEntity<?> getHeaders(@RequestHeader Map<String, String> headers){
        return ResponseEntity.ok().body(headers);
    }
}
