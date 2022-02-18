//package uz.davrbank.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import uz.davrbank.demo.service.UserService;
//import uz.pdp.apprestjwt.service.MyAuthService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    @Autowired
//    JwtProvider jwtProvider;
//    @Autowired
//    UserService myAuthService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest,
//                                    HttpServletResponse httpServletResponse,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        //requestdan tokennni olish
//        String token = httpServletRequest.getHeader("Authorization");
//        //token bearerdan boshlanishini tekshirish
//        if (token!=null&&token.startsWith("Bearer")){
//            token=token.substring(7);
//            //validate token, buzilmagani,muddatini
//            boolean validateToken = jwtProvider.validateToken(token);
//            if (validateToken) {
//                //tokendan username oldik
//                String usernameFromToken = jwtProvider.getUsernameFromToken(token);
//                //username orqali details olindi
//                UserDetails userDetails = myAuthService.loadUserByUsername(usernameFromToken);
//                //userdetails orqali authentication yaratib oldik
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                System.out.println(SecurityContextHolder.getContext().getAuthentication());
//
//                //sistemaga kim kirganligini o'rnatdik
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//            }
//        }
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
//
//
//    }
//}
