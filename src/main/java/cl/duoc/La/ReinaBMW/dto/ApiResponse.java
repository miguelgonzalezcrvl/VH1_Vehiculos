package cl.duoc.La.ReinaBMW.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;
}