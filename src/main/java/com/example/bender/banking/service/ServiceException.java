// //////////////////////////////////////
// BMC Software, Inc.
// Confidential and Proprietary
// Copyright (c) BMC Software, Inc. 2013
// All Rights Reserved.
// //////////////////////////////////////
package com.example.bender.banking.service;


/**
 * Root of hierarchy of data access exceptions.
 */

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * See {@link Exception#Exception()}.
     */
    public ServiceException() {
    }

    /**
     * See {@link Exception#Exception(String)}.
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * See {@link Exception#Exception(String, Throwable)}.
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * See {@link Exception#Exception(Throwable)}.
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }


}
