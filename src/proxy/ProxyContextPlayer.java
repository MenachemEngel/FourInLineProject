package proxy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProxyContextPlayer implements java.lang.reflect.InvocationHandler{

    private Object obj;
    private static PrintWriter pw;
    private DateTimeFormatter dtf;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new ProxyContextPlayer(obj));
    }

    private ProxyContextPlayer(Object obj) {
        this.obj = obj;
        try {
            pw = new PrintWriter("ProxyLog");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            pw.println(dtf.format(LocalDateTime.now()) + ": before method " + method.getName());
            if (args != null) {
                for (Object o : args) {
                    pw.println(dtf.format(LocalDateTime.now()) + ":    [" + o.getClass() + ", " + args.toString() + "]");
                }
            }
            result = method.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
            pw.println(dtf.format(LocalDateTime.now()) + ": after method " + method.getName());
        }
        return result;
    }

    public static void close(){
        pw.close();
    }
}
