package dashbotdemo.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class Stargazers {
    
    @RequestMapping("stargazers")
    public ValueDto stargazers() {
	return new ValueDto(7);
    }
}
