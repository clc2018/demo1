import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(path="/")
    public String hello() {
        return "Hallo!";
    }

}