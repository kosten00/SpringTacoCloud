package ru.vasilev.tacocloud.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {

    @NotNull
    private String name;

    @Size(min = 5, message = "You must choose at least 1 ingredient.")
    private List<String> ingredients;
}
