package com.bnpinnovation.hazelcast.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@Getter
public class Coffee implements Serializable {
    private String coffeeName;
    public Coffee(String coffeeName) {
        this.coffeeName = coffeeName;
    }
}
