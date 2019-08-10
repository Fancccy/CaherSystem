package com.casher_code.cmd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)    //保存到字节码文件当中
@Target(ElementType.TYPE)     //说明可以修饰到类上
public @interface EntranceCommand {
}
