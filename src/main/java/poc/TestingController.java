package poc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestingController {
    private final TestingService service;

    public TestingController(TestingService service) {
        this.service = service;
    }

    @RequestMapping("/testing")
    public @ResponseBody
    String testing() {
        return service.test();
    }
}
