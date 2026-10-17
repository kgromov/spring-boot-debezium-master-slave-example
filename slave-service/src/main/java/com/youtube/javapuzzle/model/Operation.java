package com.youtube.javapuzzle.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Operation {
    READ("r"),
    CREATE("c"),
    UPDATE("u"),
    DELETE("d");

    @JsonValue
    private final String operation;

    @JsonCreator
    public static Operation forValues(String operation) {
        return Stream.of(Operation.values())
                .filter(o -> o.operation.equals(operation))
                .findFirst()
                .orElse(null);
    }
}
