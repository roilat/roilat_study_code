package cn.roilat.framework.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.roilat.framework.result.ResponseResult;
import cn.roilat.framework.result.ResultCodeEnum;

/****************
 * 统一异常处理，拦截controller层
 * @author jie.liu
 *
 */
@Aspect
@Component
public class CommonExceptionHandler {
	
	public static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	//com包及其子包下所有以Controller结尾的类下的所有方法
	@Pointcut("execution(* cn.roilat.*Controller.*(..))")
	public void exceptionPointcutController(){}
	
	@Pointcut("execution(* cn.roilat..*Impl.*(..))")
	public void exceptionPointcutService(){}
	
	@Around("exceptionPointcutController()")
	public Object handlerException(ProceedingJoinPoint pjp){
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			result = ResponseResult.fail(ResultCodeEnum.COMMON_EXCEPTION);
		}
		logger.info("返回结果为：||||"+result.toString());
		return result ;
	}
}