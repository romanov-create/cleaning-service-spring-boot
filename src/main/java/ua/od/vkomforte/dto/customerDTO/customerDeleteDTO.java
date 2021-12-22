package ua.od.vkomforte.dto.customerDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class customerDeleteDTO {
    @Schema(description = "Id of the customer.",
            example = "1",
            required = true)
    private long id;
    @Schema(description = "Customer is deleted?",
            example = "true",
            required = true)
    private Boolean isDeleted;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Boolean getDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted)
    {
        isDeleted = deleted;
    }
}
