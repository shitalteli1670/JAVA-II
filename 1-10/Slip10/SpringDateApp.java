import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component

class DateService {

    public String getCurrentDate() {

        return "Current Date: " + LocalDate.now();

    }

}


public class SpringDateApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DateService.class);

        DateService dateService = context.getBean(DateService.class);

        System.out.println(dateService.getCurrentDate());

    }

}