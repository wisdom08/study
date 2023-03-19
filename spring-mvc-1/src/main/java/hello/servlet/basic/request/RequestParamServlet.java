package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start ");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + ": " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end ");

        System.out.println("[단일 파라미터 조회] - start ");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        System.out.println("[단일 파라미터 조회] - end ");
        response.getWriter().write("ok");
    }
}
