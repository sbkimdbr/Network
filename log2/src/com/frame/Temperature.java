package com.frame;

import org.springframework.stereotype.Service;

@Service
public interface Temperature<T> {
	
	public void status(T t);

}
