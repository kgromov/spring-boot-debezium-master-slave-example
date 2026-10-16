package com.youtube.javapuzzle.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.stream.Stream;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerChanges {
    private Long id;
    @JsonProperty("full_name")
    private String fullName;
    private String email;
    @JsonProperty("__op")
    private Operation operation;
    @JsonProperty("__deleted")
    private boolean deleted;

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
}
