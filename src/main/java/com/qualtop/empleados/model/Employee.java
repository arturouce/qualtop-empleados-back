package com.qualtop.empleados.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Setter
@Getter
@Accessors(chain = true)
@Document(collection = "Employee")
public class Employee {

    @Id
    @JsonSerialize(using=ToStringSerializer.class)
    private ObjectId id;
    private String nombre;
    private String noEmpleado;
    private BigDecimal sueldo;
    private String empresa;
}
