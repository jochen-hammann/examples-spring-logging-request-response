package com.example.spring.logging.responserequest.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@ConfigurationProperties("common-request-logging-filter")
@Getter
@Setter
public class RequestLoggingFilterConfig
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    private boolean includeQueryString;
    private boolean includeHeaders;
    private boolean includePayload;
    private int maxPayloadLength;
    private String afterMessagePrefix;

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Beans] ==============================

    // -------------------- [Public Beans] --------------------

    @Bean
    public CommonsRequestLoggingFilter logFilter()
    {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(this.includeQueryString);
        filter.setIncludeHeaders(this.includeHeaders);
        filter.setIncludePayload(this.includePayload);
        filter.setMaxPayloadLength(this.maxPayloadLength);
        filter.setAfterMessagePrefix(this.afterMessagePrefix);

        return filter;
    }

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

}
