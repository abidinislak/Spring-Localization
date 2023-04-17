package com.restApiLocalization.localization.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
@Component

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {


        String language = request.getHeader("Accept-language");
        if (language == null || language.isEmpty()) return Locale.forLanguageTag("en");

        Locale local = Locale.forLanguageTag(language);

        if (LanguageConfig.LOCALES.contains(local)) return local;
        return Locale.forLanguageTag("en");

    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
