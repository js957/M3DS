package com.ynufrd.mddds.fileservice.exception;

import com.ynufrd.mddds.common.core.exception.BaseException;
import com.ynufrd.mddds.common.core.exception.ErrorType;

/**
 * Created by wjs on 2022/08/02
 */
public class MinioFileException extends BaseException {
    public MinioFileException() {
        super(MinioFileType.FILE_UPLOAD_FAILED);
    }

    public MinioFileException(String message) {
        super(MinioFileType.FILE_UPLOAD_FAILED, message);
    }

    public MinioFileException(ErrorType errorType, String message) {
        super(errorType, message);
    }
}
