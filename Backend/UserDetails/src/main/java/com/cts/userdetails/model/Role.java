package com.cts.userdetails.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements Serializable {



    private long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roleName;

//    @ManyToOne(mappedby="roles",cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<User> user;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private User user_id;

//       @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userid")
//    @JsonIgnore
//    public User user;

}
