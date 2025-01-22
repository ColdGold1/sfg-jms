package org.example.cold.sfgjms.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String message;
}


