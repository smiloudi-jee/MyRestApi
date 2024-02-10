package iut.montreuil.config.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class InfrastructureLogConfig {

    private final static Logger logger = LoggerFactory.getLogger(InfrastructureLogConfig.class);
    private final Predicate<Object[]> isNull = (s) -> s != null;

    @Before("execution(public * iut.montreuil.infrastructure.adapter.repository.*.*(..))")
    public void beforeDaoMethod(JoinPoint joinPoint) {
        logger.info("LOG BEFORE DAO METHODE");

        final List<Object> args =
                Arrays.asList(isNull.test(joinPoint.getArgs()) ? joinPoint.getArgs() : new Object[0]) ;
        final Stream<Object> object = args.stream().filter(arg -> arg != null);

        final StringBuffer listArgs = new StringBuffer();

        object.forEach((p) -> listArgs.append(p.toString()+" "));

        logger.info("Method called : " + joinPoint.getSignature().getName());
        logger.info("Method called with args : " + listArgs.toString());
    }

    @AfterReturning(pointcut = "execution(public * iut.montreuil.infrastructure.adapter.repository.*.*(..))", returning = "result")
    public Object logDaoMethodAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("logDaoMethodAfterReturning() is running!");

        final List<Object> args =
                Arrays.asList(isNull.test(joinPoint.getArgs()) ? joinPoint.getArgs() : new Object[0]) ;
        final Stream<Object> object = args.stream().filter( arg -> arg != null);

        final StringBuffer listArgs = new StringBuffer();

        object.forEach((p) -> listArgs.append(p.toString()+" "));

        final StringBuffer listNamesArgs = new StringBuffer();
        final MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        final List<String> parameterNames =
                Arrays.asList(isNull.test(signature.getParameterNames()) ? signature.getParameterNames() : new String[0]) ;
        final Stream<String> streamParameterNames = parameterNames.stream().filter( s -> s != null);

        streamParameterNames.forEach((s) -> listNamesArgs.append(s.toString()+" "));

        logger.info("Method called : " + joinPoint.getSignature().getName());
        logger.info("Method called with listNamesArgs : " + listNamesArgs.toString() );
        logger.info("Method called with args : " + listArgs.toString());
        logger.info("Method returned value is : " + result);
        logger.info("******");

        return joinPoint.getThis();
    }
}
