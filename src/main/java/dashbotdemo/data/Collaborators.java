package dashbotdemo.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class Collaborators {
    
    @RequestMapping("collaborators")
    public ValueDto collaborators() {
	return new ValueDto(2);
    }
}
