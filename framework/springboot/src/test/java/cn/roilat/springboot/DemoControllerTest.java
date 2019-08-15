/**
 * 
 */
package cn.roilat.springboot;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author roilat-D DemoControllerTest.java
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/?id=100").content("Hello, Get Body")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string(Is.is("100: Hello, Get Body")));
	}
}