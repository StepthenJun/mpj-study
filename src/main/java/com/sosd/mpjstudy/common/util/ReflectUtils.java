package com.sosd.mpjstudy.common.util;

import cn.hutool.core.util.ReflectUtil;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * 反射工具类. 提供调用getter/setter方法, 访问私有变量, 调用私有方法, 获取泛型类型Class, 被AOP过的真实类等工具函数.
 */
@SuppressWarnings("rawtypes")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ReflectUtils extends ReflectUtil {

  private static final String SETTER_PREFIX = "set";

  private static final String GETTER_PREFIX = "get";

  /** 调用Getter方法. 支持多级，如：对象名.对象名.方法 */
  @SuppressWarnings("unchecked")
  public static <E> E invokeGetter(Object obj, String propertyName) {
    Object object = obj;
    for (String name : StringUtils.split(propertyName, ".")) {
      String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(name);
      object = invoke(object, getterMethodName);
    }
    return (E) object;
  }

  /** 调用Setter方法, 仅匹配方法名。 支持多级，如：对象名.对象名.方法 */
  public static <E> void invokeSetter(Object obj, String propertyName, E value) {
    Object object = obj;
    String[] names = StringUtils.split(propertyName, ".");
    for (int i = 0; i < names.length; i++) {
      if (i < names.length - 1) {
        String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(names[i]);
        object = invoke(object, getterMethodName);
      } else {
        String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(names[i]);
        Method method = getMethodByName(object.getClass(), setterMethodName);
        invoke(object, method, value);
      }
    }
  }

  /**
   * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. eg. public UserDao extends
   * HibernateDao<User>
   *
   * @param clazz The class to introspect
   * @return the first generic declaration, or Object.class if cannot be determined
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <T> Class<T> getSuperClassGenericType(final Class clazz) {
    return getSuperClassGenericType(clazz, 0);
  }

  /**
   * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
   *
   * <p>如public UserDao extends HibernateDao<User,Long>
   *
   * @param clazz clazz The class to introspect
   * @param index the Index of the generic declaration,start from 0.
   * @return the index generic declaration, or Object.class if cannot be determined
   */
  @SuppressWarnings("rawtypes")
  public static Class getSuperClassGenericType(final Class clazz, final int index) {

    Type genType = clazz.getGenericSuperclass();

    if (!(genType instanceof ParameterizedType)) {
      log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
      return Object.class;
    }

    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

    if (index >= params.length || index < 0) {
      log.warn(
          "Index: "
              + index
              + ", Size of "
              + clazz.getSimpleName()
              + "'s Parameterized Type: "
              + params.length);
      return Object.class;
    }

    if (!(params[index] instanceof Class)) {
      log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
      return Object.class;
    }

    return (Class) params[index];
  }
}
