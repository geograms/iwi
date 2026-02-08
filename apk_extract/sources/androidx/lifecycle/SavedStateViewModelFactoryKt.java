package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import v0.f;
import x0.g;

/* loaded from: classes.dex */
public final class SavedStateViewModelFactoryKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    private static final List<Class<?>> VIEWMODEL_SIGNATURE;

    static {
        List<Class<?>> listAsList = Arrays.asList(Application.class, SavedStateHandle.class);
        g.t(listAsList, "asList(this)");
        ANDROID_VIEWMODEL_SIGNATURE = listAsList;
        List<Class<?>> listSingletonList = Collections.singletonList(SavedStateHandle.class);
        g.t(listSingletonList, "singletonList(element)");
        VIEWMODEL_SIGNATURE = listSingletonList;
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) throws SecurityException {
        g.u(cls, "modelClass");
        g.u(list, "signature");
        Object[] constructors = cls.getConstructors();
        g.t(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            g.t(parameterTypes, "constructor.parameterTypes");
            List listJ0 = f.J0(parameterTypes);
            if (g.g(list, listJ0)) {
                return constructor;
            }
            if (list.size() == listJ0.size() && listJ0.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        g.u(cls, "modelClass");
        g.u(constructor, "constructor");
        g.u(objArr, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
        }
    }
}
