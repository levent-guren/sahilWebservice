package tr.gov.sg.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(-1)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String username = req.getHeader("username");
		String password = req.getHeader("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		if ("sg".equals(username) && "sg!123.".equals(password)) {
			chain.doFilter(request, response);
		} else {
			resp.sendError(401, "Unauthorized");
		}
	}

}
