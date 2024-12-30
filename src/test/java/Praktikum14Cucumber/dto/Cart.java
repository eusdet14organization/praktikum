package Praktikum14Cucumber.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cart {
    private String nameProduct;
    private String amount;
    private String price;

    public Cart() {
    }

    public Cart(String nameProduct, String amount) {
        this.nameProduct = nameProduct;
        this.amount = amount;
    }

    public Cart(String nameProduct, String amount, String price) {
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.price = price;
    }

}
