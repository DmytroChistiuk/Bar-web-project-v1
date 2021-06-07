<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <error-page>
        <error-code>404</error-code>
        <location>/WEB-INF/jsp/error-404.jsp</location>
    </error-page>
    <error-page>
        <error-code>500</error-code>
        <location>/WEB-INF/jsp/error-500.jsp</location>
    </error-page>
    <error-page>
        <error-code>403</error-code>
        <location>/WEB-INF/jsp/error-403.jsp</location>
    </error-page>
</web-app>