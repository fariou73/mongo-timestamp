package org.mongo.timestamp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mongo.timestamp.config.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Aspect
public class LoggingAspect {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Pointcut("within(org.mongo.timestamp..*)")
    public void mongoWriteBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "mongoWriteBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error(applicationProperties.getMessage().getConnectionUnreachable());
    }
}
