package com.frame;

import org.springframework.stereotype.Service;

//Shop이란 함수에 

@Service
public interface Shop<T> {
 public void itemClick(T t);
}
