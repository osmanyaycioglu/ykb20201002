package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Scheduled(fixedDelay = 10_000)
    public void sch() {
        System.out.println("schedule");
    }

    @Autowired
    private Environment env;

    @Value("${process.type}")
    private int         proType;

    @Bean
    @Qualifier("second")
    public UseSpringBean secondUse() {
        UseSpringBean springBeanLoc = new UseSpringBean(new SpringBean1());
        return springBeanLoc;
    }

    @Bean
    @Qualifier("third")
    public UseSpringBean thirdUse() {
        UseSpringBean springBeanLoc = new UseSpringBean(new SpringBean1());
        return springBeanLoc;
    }

    @Bean
    public IProcess createProcess() {
        switch (this.proType) {
            case 1:
                return new Process1();
            case 2:
                return new Process2();
            case 3:
                return new Process3();
            default:
                return new Process1();
        }
    }

    //    @Bean
    //    public IProcess createProcess() {
    //        String propertyLoc = this.env.getProperty("process.type");
    //        int parseIntLoc = Integer.parseInt(propertyLoc);
    //        switch (parseIntLoc) {
    //            case 1:
    //                return new Process1();
    //            case 2:
    //                return new Process2();
    //            case 3:
    //                return new Process3();
    //            default:
    //                return new Process1();
    //        }
    //    }

}
