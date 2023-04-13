package org.example.web.dto;

import org.example.app.services.DeleteByFieldConstraint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

/**
 * Created by a.sosnina on 12/17/2022.
 */
public class BookRemoveByField {

    @DeleteByFieldConstraint
    private String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}