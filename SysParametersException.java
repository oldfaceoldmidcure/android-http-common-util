package com.ofocompany.common.net;

/**
 * @author ofo
 */
public class SysParametersException extends Exception {

    public static final int Error_code_unknow = 0;
    public static final int Error_code_request_failed = 1;
    public static final int Error_code_connection_failed = 2;
    public static final int Error_code_parameters_exception = 3;

    private int errorCode = 0;

    public SysParametersException() {
    }


    @Deprecated
    public SysParametersException(String message) {
        super(message);
    }

    public SysParametersException(int errorCode) {
        switch (errorCode) {
            case Error_code_request_failed:
                errorCode = Error_code_request_failed;
                break;
            case Error_code_connection_failed:
                errorCode = Error_code_connection_failed;
                break;
            case Error_code_parameters_exception:
                errorCode = Error_code_parameters_exception;
                break;
        }
    }

    @Deprecated
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public SysParametersException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public SysParametersException(Throwable throwable) {
        super(throwable);
    }
}