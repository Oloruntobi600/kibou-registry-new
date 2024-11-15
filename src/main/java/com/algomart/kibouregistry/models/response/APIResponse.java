package com.algomart.kibouregistry.models.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class APIResponse {
    private String status;
    private String message;
    private Object data;

//    public APIResponse(String status, String message, Object data) {
//        this.status = status;
//        this.message = message;
//        this.data = data;
//    }
}