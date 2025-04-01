import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
class MessageService 
{
    public String getMessage() 
    {
        return "If you can't explain it simply, you don't understand it well enough.";
    }
}
public class Slip9_2 
{
    public static void main(String[] args) 
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageService.class);
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}

