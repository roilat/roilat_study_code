
package cn.start.roilat.spring.beans;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyCachableService {

	
	public String getResponseWithoutCache(String key){
		System.out.println("---------do getResponseWithoutCache---------");
		return "hello---" + key + ",the currentTime is " + System.currentTimeMillis();
	}
	@Cacheable
	public String getResponseWithCache(String key){
		System.out.println("---------Do getResponseWithCache---------");
		return "hello---" + key + ",the currentTime is " + System.currentTimeMillis();
	}
}

