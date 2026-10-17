package com.youtube.javapuzzle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
