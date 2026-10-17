package com.youtube.javapuzzle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@NoArgsConstructor
@Getter
@Setter
public abstract class GenericChangeEvent<T> {
    private T before;
    private T after;
    @JsonProperty("op")
    private Operation operation;
    @JsonProperty("source")
    private ConnectorMetadata metadata;

    @JsonIgnore
    public boolean deleted() {
        return operation == Operation.DELETE || (isNull(after) && nonNull(before));
    }
}
