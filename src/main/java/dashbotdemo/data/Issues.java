package dashbotdemo.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class Issues {
    
    @RequestMapping("issues")
    public ValueDto issues() {
	return new ValueDto(0);
    }
    
}
