package model;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class College {

    private String CollegeName;
    private List<Department> departmentList;



}
