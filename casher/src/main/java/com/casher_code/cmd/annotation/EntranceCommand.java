package com.casher_code.cmd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)    //���浽�ֽ����ļ�����
@Target(ElementType.TYPE)     //˵���������ε�����
public @interface EntranceCommand {
}
