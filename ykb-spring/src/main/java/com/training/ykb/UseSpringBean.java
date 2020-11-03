package com.training.ykb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UseSpringBean {


    @Autowired
    private SpringBean1       sb1;

    private final SpringBean1 sb2;

    private SpringBean1       sb3;


    @Autowired
    public UseSpringBean(final SpringBean1 sb2) {
        this.sb2 = sb2;
    }

    @Autowired
    public void wireSprBean(final SpringBean1 sb3) {
        this.sb3 = sb3;

    }

    @PostConstruct
    public void init() {
        this.sb1.execute();
    }

    @PreDestroy
    public void name() {
        System.out.println("destroy");
    }

    public void xyz() {
        this.sb1.execute();
    }

    @Scheduled(fixedDelay = 10_000)
    public void sch() {
        System.out.println("use schedule");
    }

}
