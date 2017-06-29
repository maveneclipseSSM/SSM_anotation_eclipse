package com.xywei.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理系统发生的异常
 * 
 * @author Administrator
 *
 */
public class ExceptionDeal implements HandlerExceptionResolver {

	private final Logger log = LoggerFactory.getLogger(ExceptionDeal.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String viewName = ClassUtils.getShortName(ex.getClass());

		log.error(viewName);
 		return new ModelAndView("500");
	}

}
