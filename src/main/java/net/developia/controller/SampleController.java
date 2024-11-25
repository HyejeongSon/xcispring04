package net.developia.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/sample/*")
public class SampleController {

   @GetMapping("/all")
   public void doAll() {
      log.info("do all can access everybody");
   }
   @GetMapping("/member")
   public void doMember() {
      log.info("login member");
   }
   @GetMapping("/admin")
   public void doAdmin() {
      log.info("admin only");
   }
   
   /* 아래부분 @PreAuthorize로 대체
    * 	<security:intercept-url pattern="/sample/all" access="permitAll"/>
		<security:intercept-url pattern="/sample/member" access="hasRole('ROLE_MEMBER')"/>
		<security:intercept-url pattern="/sample/admin" access="hasRole('ROLE_ADMIN')"/>
		servelt-context에 namespace security 체크 후 아래 추가
		<security:global-method-security pre-post-annotations="enabled" secured-annotations="enabled"/>
    */
   @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
   @GetMapping("/annoAdmin")
   public String doAdmin2() {
      log.info("admin only (annation)");
      return "sample/admin";
   }
}