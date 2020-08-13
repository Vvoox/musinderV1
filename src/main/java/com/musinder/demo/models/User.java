package com.musinder.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.musinder.demo.enumerations.Gender;
import com.musinder.demo.enumerations.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDay;
    private Gender gender;
    private String image;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(unique = true)
    private String email ;
    private String number;
    private Role role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties("user")
    private Collection<Music> musicCollection;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties("user")

    private Collection<Movie> movieCollection;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties("user")
    private Collection<Serie> serieCollection;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_" + role)); // ROLE_  : just a prefix , Spring build a prefix for every role its just a syntx ,for exemple if your role is USER then your authority(role) is ROLE_USER

        return list;    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
