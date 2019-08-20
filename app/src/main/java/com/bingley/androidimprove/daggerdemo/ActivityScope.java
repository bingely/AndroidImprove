package com.bingley.androidimprove.daggerdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *
 * 作用是限定被它标记的对象生命周期与对应的Activity相同
 *  @Scope：标记局部单例；@Retention ：指定了它是运行时注解,就是说注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在.
 * @author bingley
 * @date 2019/8/20.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
