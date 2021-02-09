package io.fewNeurons.springboot.expose;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExposeController {

	@RequestMapping("/conect")
	public String Connect() {
		return "conectando";
	}
}
