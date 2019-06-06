package cn.roilat.framework.core.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonLogingHandler {
	public static final Logger logger = LoggerFactory.getLogger(CommonLogingHandler.class);
	
	@Pointcut("execution(* cn.roilat.modules.**.controller.*.*(..))")
	public void controllerMethod() {};
	//ProceedingJoinPoint
	//@Before("controllerMethod()")
	public void beforeLogging(JoinPoint point){
		System.out.println("==========前置通知begin============="); 
		/*//拦截的类名称
		String className = point.getTarget().getClass().getName();
		//拦截的方法名称
		String methodName = point.getSignature().getName();
		//拦截的参数
		Object[] arguments = point.getArgs();
		System.out.println("className:"+className);
		System.out.println("methodName:"+methodName);
		for(int i=0;i<arguments.length;i++){
			System.out.println("arg:"+arguments[i]+"、");
		}*/
		System.out.println("==========前置通知end============="); 
	}
	//@Around("exceptionPointcut()")
	public Object aroundLogging(ProceedingJoinPoint pjp){
		return null;
	}
	
	/**
	 *后置切入点  
	 *@param thisJoinPoint
	 *@throws Throwable void
	 */
	//@After ("controllerMethod()")
	public void afterLoging(JoinPoint thisJoinPoint) throws Throwable {
		System.out.println("==========后置通知begin=================");
		/*//拦截的类名称
		String className = thisJoinPoint.getTarget().getClass().getName();
		//拦截的方法名称
		String methodName = thisJoinPoint.getSignature().getName();
		//拦截的参数
		Object[] arguments = thisJoinPoint.getArgs();
		
		//处理参数名称
		StringBuffer argBuf = new StringBuffer();
		int i = 0;
		for (Object argument : arguments) {
			if (null == argument)
				return;
			String argClassName = argument.getClass().getSimpleName();
			if (i > 0) {
				argBuf.append(", ");
			}
			argBuf.append(argClassName + " arg" + ++i);
		}

		StringBuffer messageBuf = new StringBuffer();
		messageBuf.append("After executing " + className + "." + methodName + "("
				+ argBuf.toString() + ") method");
		messageBuf
				.append("\n-------------------------------------------------------------------------------\n");

		if (logger.isDebugEnabled()) {
			logger.debug(messageBuf.toString());
		}*/
		
		System.out.println("==========后置通知end=================");
	}
	
	
}
