package org.workspace7.cloudnative.demos.service2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kameshs
 */
@Data
public class HelloResponse {

    private List<String> responses = new ArrayList<>();
}
