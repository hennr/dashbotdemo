package dashbotdemo.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class Forks {

    @RequestMapping("/forks")
    public ValueDto forks() {
        return new ValueDto(2);
    }
}
