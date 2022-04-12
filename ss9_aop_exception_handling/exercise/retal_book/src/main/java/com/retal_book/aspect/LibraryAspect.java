package com.retal_book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;

import java.util.Arrays;

public class LibraryAspect {
    private static Integer numberCustomer = 0;

    @After("execution(* com.rental_book.controller.BookController(..))")
    public void logBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + methodName);
        System.out.println(" args : " + args);
    }

    @After("execution(* com.rental_book.controller.BorrowController(..))")
    public void logBorrow(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + method);
        System.out.println("args : " + args);
    }

    @AfterReturning(pointcut = "execution(public * com.rental_book.controller.BookController.*(..))")
    public void logViewers(JoinPoint joinPoint) {
        numberCustomer += 1;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + method);
        System.out.println("args : " + args);
        System.out.println("views : " + numberCustomer);
    }
}
