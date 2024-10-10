package com.scm.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    
    private String content;

    @Builder.Default //ye add kiye kyunki error aa rha tha ki ye ignore krr dega
    private MessageType type = MessageType.blue;

}
