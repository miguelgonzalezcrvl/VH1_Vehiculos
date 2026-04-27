package cl.duoc.La.ReinaBMW.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {

    private String marca;
    private String modelo;
    private Integer anio;
    private Double precio;
    private Integer stock;
}