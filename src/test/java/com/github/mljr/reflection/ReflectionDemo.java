package com.github.mljr.reflection;

import com.github.annotation.Cache;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.scanners.TypeElementsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionDemo {

    @Test
    public void testReflection() throws Exception {
        String packageName = "com.github.service";

        ConfigurationBuilder builder = new ConfigurationBuilder()
                .filterInputsBy(new FilterBuilder().includePackage(packageName))
                .addUrls(ClasspathHelper.forPackage(packageName))
                .setScanners(new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new TypeElementsScanner(), new SubTypesScanner());
        Reflections ref = new Reflections(builder);

        System.out.println("class ---------------------------");
        Set<Class<?>> classes = ref.getTypesAnnotatedWith(Cache.class);
        for (Class<?> c : classes) {
            Cache cache = c.getAnnotation(Cache.class);
            System.out.println(Arrays.toString(cache.names()));
        }

        System.out.println("method --------------------------");
        Set<Method> methods = ref.getMethodsAnnotatedWith(Cache.class);
        for (Method m : methods) {
            Cache cache = m.getAnnotation(Cache.class);
            System.out.println(Arrays.toString(cache.names()));
        }

        System.out.println("测试成功了!");

    }
}
