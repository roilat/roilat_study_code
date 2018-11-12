package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import cn.roilat.study.java.designmode.dynamicproxy.UserService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements UserService {
    /**  */
    private static final long serialVersionUID = -4926462802653404042L;
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m4;
    private static Method m0;

    public $Proxy0(InvocationHandler paramInvocationHandler) {
        super(paramInvocationHandler);
    }

    public final boolean equals(Object paramObject) {
        try {
            return ((Boolean) this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final String toString() {
        try {
            return (String) this.h.invoke(this, m2, null);
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final String getName(int paramInt) {
        try {
            return (String) this.h.invoke(this, m3, new Object[] { Integer.valueOf(paramInt) });
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final int getAge(int paramInt) {
        try {
            return ((Integer) this.h.invoke(this, m4, new Object[] { Integer.valueOf(paramInt) }))
                .intValue();
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

  public final int hashCode()
  {
    try
    {
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
            throw new UndeclaredThrowableException(localThrowable);
        }
  }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals",
                new Class[] { Class.forName("java.lang.Object") });
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("cn.roilat.study.java.designmode.dynamicproxy.UserService")
                .getMethod("getName", new Class[] { Integer.TYPE });
            m4 = Class.forName("cn.roilat.study.java.designmode.dynamicproxy.UserService")
                .getMethod("getAge", new Class[] { Integer.TYPE });
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
        } catch (NoSuchMethodException localNoSuchMethodException) {
            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
        }
    }
}

/* Location:           D:\WorkSpace\roilat\roilat-study\roilat-study-java\src\main\java\cn\roilat\study\java\designmode\dynamicproxy\jdk\
 * Qualified Name:     .Proxy0
 * JD-Core Version:    0.6.0
 */