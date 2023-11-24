package com.gofar.citzenswsclient.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class CitizenDto {

    private String cin;
    private String firstname;
    private String lastname;
    private String blood;

    public Map<String, String> getKeyValues() {
        Map<String, String> map = new HashMap<>();
        map.put("firstname", this.firstname);
        map.put("lastname", this.lastname);
        map.put("blood", this.blood);

        return map;
    }
}
