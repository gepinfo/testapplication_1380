package com.geppetto.testapplication.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geppetto.testapplication.apiAdapter.ApiAdapter;
import com.geppetto.testapplication.config.NewConstant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class SecurityController {

    @Autowired
    private ApiAdapter apiAdapter;



@PostMapping("/signup")
public ResponseEntity<Object> signup(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : signup");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.post(NewConstant.SECURITYURL + "/signup",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : signup");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PutMapping("/logout")
public ResponseEntity<Object> logout(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : logout");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.SECURITYURL + "/logout",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : logout");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PostMapping("/googlesignin")
public ResponseEntity<Object> googleLogin(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : googleLogin");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.post(NewConstant.SECURITYURL + "/googlesignin",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : googleLogin");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/getallusers")
public ResponseEntity<Object> getAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : getAllUser");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.SECURITYURL + "/getallusers",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : getAllUser");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/getuser/{id}")
public ResponseEntity<Object> getUserById( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : getUserById");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.SECURITYURL + "/getuser/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : getUserById");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/getallroles")
public ResponseEntity<Object> getAllRole(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : getAllRole");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.SECURITYURL + "/getallroles",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : getAllRole");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PutMapping("/updateuser")
public ResponseEntity<Object> updateUser(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : updateUser");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.SECURITYURL + "/updateuser",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : updateUser");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PutMapping("/updateuserimg")
public ResponseEntity<Object> updateuserimg(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : updateuserimg");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.SECURITYURL + "/updateuserimg",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : updateuserimg");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PostMapping("/saveroles")
public ResponseEntity<Object> saveRoles(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : saveRoles");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.post(NewConstant.SECURITYURL + "/saveroles",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : saveRoles");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@DeleteMapping("/deleteroles/{id}")
public ResponseEntity<Object> deleteRoles( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : deleteRoles");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.delete(NewConstant.SECURITYURL + "/deleteroles/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : deleteRoles");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@DeleteMapping("/deleteuser/{id}")
public ResponseEntity<Object> deleteUser( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into SecurityController : deleteUser");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.delete(NewConstant.SECURITYURL + "/deleteuser/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : deleteUser");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }





        @PostMapping("login")
        public ResponseEntity<Object> login(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response)throws Exception{
        try{
        log.info("Enter into  SecurityController.java:login");
        String servletPath = request.getContextPath();
        switch (servletPath) {
        case "/mobile":
        case "/web":
        ResponseEntity<Object> result=apiAdapter.post(NewConstant.SECURITYURL + "/login" ,object,request);
        Map<String, Object> responseBody = (Map<String,Object>) result.getBody();
        if (responseBody == null || !responseBody.containsKey("Userdetails")) {
            // Return a default Userdetails object if it is missing
            responseBody.put("Userdetails", new HashMap<String, Object>());
        }

        String idToken = (String) responseBody.get("idtoken");

        if (idToken == null || idToken.isEmpty()) {
        switch (servletPath) {
        case "/mobile":
        return ResponseEntity.ok().body("Userdetails: " + result.getBody());
        case "/web":
        //return ResponseEntity.ok().body("Userdetails: " + result.getBody());
        System.out.println("Signinresult-->"+result.getBody());
        System.out.println("SigninresponseBody-->"+responseBody);
        return ResponseEntity.ok().body(responseBody);
        default:
        return ResponseEntity.ok().body(null);
        }
        }else{
        int i = idToken.lastIndexOf('.');
        String withoutSignature = idToken.substring(0, i+1);
        Jwt<Header,Claims> headerClaimsJwt = Jwts.parser().parseClaimsJwt(withoutSignature);

        Map<String, Object> user = new HashMap<>();
        user.put("firstname", headerClaimsJwt.getBody().get("firstName"));
        user.put("lastname", headerClaimsJwt.getBody().get("lastName"));
        user.put("listOfRoles", headerClaimsJwt.getBody().get("role"));
        user.put("id", headerClaimsJwt.getBody().get("id"));
        user.put("username", headerClaimsJwt.getBody().get("sub"));
        user.put("email", headerClaimsJwt.getBody().get("email"));
        ResponseEntity<Object> authProxyResponse= apiAdapter.post(NewConstant.AUTHPROXYURL + "/proxy" ,user,request);
        Map<String, Object> res = new HashMap<>();
        res.put("Access", authProxyResponse.getBody());
        res.put("Userdetails", user);
        return ResponseEntity.ok(res);
        }
        default:
        String errorMessage = "Invalid servlet path: " + servletPath;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        } catch (Exception e) {
        log.info("Exit from  SecurityController.java: login");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        }


        @PutMapping("consent")
        public ResponseEntity<Object> consenet(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws Exception{
            log.info("Enter into SecurityController : consent");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          ResponseEntity<Object> result=apiAdapter.put(NewConstant.SECURITYURL + "/consent" ,object,request);
          Map<String, Object> responseBody = (Map<String,Object>) result.getBody();
        if (responseBody == null || !responseBody.containsKey("Userdetails")) {
            responseBody.put("Userdetails", new HashMap<String, Object>());
        }

        String idToken = (String) responseBody.get("idtoken");
        String loggedinDate = (String) responseBody.get("loggedinDate");
        int i = idToken.lastIndexOf('.');
        String withoutSignature = idToken.substring(0, i+1);
        Jwt<Header,Claims> headerClaimsJwt = Jwts.parser().parseClaimsJwt(withoutSignature);

        Map<String, Object> user = new HashMap<>();
        user.put("firstname", headerClaimsJwt.getBody().get("firstName"));
        user.put("lastname", headerClaimsJwt.getBody().get("lastName"));
        user.put("listOfRoles", headerClaimsJwt.getBody().get("role"));
        user.put("id", headerClaimsJwt.getBody().get("id"));
        user.put("username", headerClaimsJwt.getBody().get("sub"));
        user.put("email", headerClaimsJwt.getBody().get("email"));
        user.put("idtoken", idToken);
        user.put("loggedinDate", loggedinDate);
        
        ResponseEntity<Object> authProxyResponse= apiAdapter.post(NewConstant.AUTHPROXYURL + "/proxy" ,user,request);
        Map<String, Object> res = new HashMap<>();
        res.put("Access", authProxyResponse.getBody());
        res.put("Userdetails", user);
        return ResponseEntity.ok(res);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into SecurityController : consent");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            
        
        }
    }


    }

