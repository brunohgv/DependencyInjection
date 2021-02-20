package com.brunohgv.models;

import com.brunohgv.annotations.Link;

public class SimpleController {

    SimpleService service;

    @Link
    public SimpleController(SimpleService service) {
        this.service = service;
    }

    public SimpleService getService() {
        return service;
    }

}
