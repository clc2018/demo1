import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hallo!";
    }

}