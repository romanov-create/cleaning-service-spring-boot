package ua.od.vkomforte.dto.customerDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import ua.od.vkomforte.domain.Order;

public class customerUpdateDTO {
    @Schema(description = "Id of the customer.",
            example = "1",
            required = true)
    private long id;
    @Schema(description = "Name of the customer.",
            example = "Billy",
            required = true)
    private String firstName;
    @Schema(description = "Last name of the customer.",
            example = "Wonky",
            required = true)
    private String lastName;
    @Schema(description = "Phone number of the customer.",
            example = " 937-99-92",
            required = true)
    private String phone;

    @Schema(description = "Order of the customer.",
            example = "№ Order",
            required = true)
    private Order order;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
