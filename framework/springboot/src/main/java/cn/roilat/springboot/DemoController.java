/**
 * 
 */
package cn.roilat.springboot;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author roilat-D DemoController.java
 */
@RestController
public class DemoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRequest(@RequestParam("id") String id, @RequestBody String body) {
		return id + ": " + body;
	}
}
