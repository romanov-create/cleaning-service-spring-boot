package ua.od.vkomforte.config.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.od.vkomforte.domain.Customer;
import ua.od.vkomforte.dto.customerDTO.CustomerCreateDTO;
import ua.od.vkomforte.dto.customerDTO.CustomerDeleteDTO;
import ua.od.vkomforte.dto.customerDTO.CustomerReadDTO;
import ua.od.vkomforte.dto.customerDTO.CustomerUpdateDTO;

import java.util.List;

@Mapper (componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    CustomerReadDTO toReadDto(Customer customer );
    CustomerCreateDTO toSaveDto(Customer customer );
    CustomerUpdateDTO toUpdateDto(Customer customer );
    CustomerDeleteDTO toDeleteDto(Customer customer );
    List<CustomerReadDTO> toReadDtoList(List<Customer> customer);
    Customer toSaveCustomer(CustomerCreateDTO customerSaveDTO);
    Customer toReadCustomer(Customer customerReadDTO);
    Customer toUpdateCustomer(CustomerUpdateDTO customerUpdateDTO);
    Customer toDeleteCustomer(CustomerDeleteDTO customerDeleteDTO);
}
