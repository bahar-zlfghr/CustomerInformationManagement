package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "Customer")
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CustomerNumberSequence"),
                    @Parameter(name = "initial_value", value = "10000001"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer customerNO;

    @Getter
    @Setter
    private String customerType;
}
