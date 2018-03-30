/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import bean.SignIn;
import com.mycompany.model.mavenproject5.BloodDonors;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yusuf
 */
public class signInFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

     @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;
        SignIn session=(SignIn)req.getSession().getAttribute("SignIn");
        String url=req.getRequestURI();
        String contextPath=req.getContextPath();
        if(session ==null || !session.isLoggedIn())
        {
           if(url.indexOf("main.xhtml")>=0 || url.indexOf("signUp.xhtml")>=0)
           {
            chain.doFilter(request, response);
           }
           else if(url.indexOf("logout.xhtml")>=0)
           {
               resp.sendRedirect(contextPath+"/secured/main.xhtml");
           }
           else
           {              
               resp.sendRedirect(contextPath+"/secured/main.xhtml");
           }
            
        }
        else
        {
            if(url.indexOf("signUp.xhtml")>=0)
            {
                resp.sendRedirect(contextPath+"/secured/donorProfile.xhtml");
            }
            else if(url.indexOf("logout.xhtml")>=0)
            {
                req.getSession().removeAttribute("SignIn");
                resp.sendRedirect(req.getServletContext().getContextPath()+"/secured/main.xhtml");
            }
            chain.doFilter(request, response);
        }
        
    }

    @Override
    public void destroy() {
       
    }
    
}
