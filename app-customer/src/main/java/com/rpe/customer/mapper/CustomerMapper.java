package com.rpe.customer.mapper;

import com.rpe.customer.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequest source);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapDateToString")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "mapDateToString")
    CustomerResponse toCustomerResponse(Customer source);

    Card toCard(CardRequest source);

    @Named("mapDateToString")
    default String mapDateToString(LocalDateTime dateTime) {
        return Optional.ofNullable(dateTime).map(LocalDateTime::toString)
                .orElse(null);
    }

}
