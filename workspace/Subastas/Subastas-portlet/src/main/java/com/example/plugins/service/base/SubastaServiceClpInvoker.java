package com.example.plugins.service.base;

import com.example.plugins.service.SubastaServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubastaServiceClpInvoker {
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;

    public SubastaServiceClpInvoker() {
        _methodName36 = "getBeanIdentifier";

        _methodParameterTypes36 = new String[] {  };

        _methodName37 = "setBeanIdentifier";

        _methodParameterTypes37 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            return SubastaServiceUtil.getBeanIdentifier();
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            SubastaServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
