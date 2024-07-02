package com.RelacionOneToOne.OneToOne.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @Column(name = "order_details")
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Sobrescribir método toString()
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetails='" + orderDetails + '\'' +
                // Puedes agregar más campos aquí si es necesario
                '}';
    }
}

