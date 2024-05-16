package org.spring.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SampleController {
	
	private final SampleService sampleService;
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println(sampleService);
		System.out.println(sampleService.sayHello());
		System.out.println("Hello......");
	}

}
