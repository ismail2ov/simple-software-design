package com.paradigmadigital.coupling;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class User {

    public String name;

    public String getName() {
        return Objects.requireNonNullElse(name, "not initiaized");
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

}
