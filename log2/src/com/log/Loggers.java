package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.Temp;




@Service
@Aspect
public class Loggers {

	

			private Logger temp_log =
			        Logger.getLogger("temp"); 
				
			private Logger work_log =
					Logger.getLogger("work");
			
			private Logger user_log = 

					Logger.getLogger("user"); 

					private Logger data_log = 

					Logger.getLogger("data"); 

					
			
			@Before("execution(* com.*biz.TempBiz*(..))")

			public void logging1(JoinPoint jp) {
            Object[]args = jp.getArgs();
            Temp ttemp = (Temp)args[0];
       temp_log.debug(jp.getSignature().getName()+","+ttemp.getId()+","+ttemp.getTemp());
			

			
			}
	
			@Before("execution(* com.*MainController.*(..))")

			public void logging2(JoinPoint jp) {

			work_log.debug(jp.getSignature().getName());

			
			}
			
			
			
			
			

			
//			
//			private Logger user_log = 
//					Logger.getLogger("user"); 
//			
//			
//			private Logger data_log = 
//					Logger.getLogger("data"); 
//	        


		
			//main 이 돌아가면 로그를 찍는다
			//biz가 실행되면 로그를 찍을 것이다.
//			@Before("execution(* com.biz.*ShopBiz.*(..))")
//
//			public void logging1(JoinPoint jp) {
//
//		    Object[] args =jp.getArgs();
//		    Click click = (Click)args[0];
//			data_log.debug(jp.getSignature().getName()+","+click.getId()+","+click.getItem()+","+
//		    click.getPrice()+","+click.getAge()+","+click.getGender());
//					
//			
//
//			}
//			
//			@Before("execution(* com.biz.CarBiz.*(..))")
//
//			public void logging3(JoinPoint jp) {
//
//		    Object[] args =jp.getArgs();
//		    CarStatus cstatus = (CarStatus)args[0];
//			car_log.debug(jp.getSignature().getName()+","+cstatus.getId()+","+cstatus.getSpeed()+","+
//					cstatus.getTemp()+","+cstatus.getOiltemp()+","+cstatus.getRpm());
//					
//			
//
//			}
			
			
			
			
			
}

