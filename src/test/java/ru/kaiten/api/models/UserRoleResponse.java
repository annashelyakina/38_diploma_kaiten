package ru.kaiten.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRoleResponse {
    String  name, updated, created, id, uid;

    @JsonProperty("company_id")
    String companyId;
}
