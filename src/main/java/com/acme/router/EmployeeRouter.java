package com.acme.router;

import org.apache.camel.builder.RouteBuilder;

public class EmployeeRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:insert").log("Inserted new Book").beanRef("employeeMapper", "getMap")
            .to("sqlComponent:{{sql.insertEmployee}}");

        from("direct:select").to("sqlComponent:{{sql.getAllEmployees}}")
            .beanRef("employeeMapper", "readEmployees").log("${body}");
    }

}