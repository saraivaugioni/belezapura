package com.ugioni.belezapura.utils;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SqlHelperException")
@ApplicationException(rollback = true)
public class SqlHelperException extends WebApplicationException {

    private static final long serialVersionUID = 1L;

    public SqlHelperException(String message, Response.Status... status) {
        super(message, 104);
    }
}