package com.gofar.citzenswsclient.utils;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDto {

    private String cin;
    private String firstname;
    private String lastname;
    private String blood;
    private String job;
    private String father;
    private String mother;

    public Map<String, String> getKeyValues() {
        Map<String, String> map = new HashMap<>();
        map.put("firstname", this.firstname);
        map.put("lastname", this.lastname);
        map.put("blood", this.blood);
        map.put("job", this.job);
        map.put("father", this.father);
        map.put("mother", this.mother);

        return map;
    }
}
