package com.frame;

import org.springframework.stereotype.Service;

//Shop�̶� �Լ��� 

@Service
public interface Shop<T> {
 public void itemClick(T t);
}
