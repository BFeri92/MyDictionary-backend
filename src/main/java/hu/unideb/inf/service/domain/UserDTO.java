package hu.unideb.inf.service.domain;

import hu.unideb.inf.enums.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Created by mates on 2017. 03. 22..
 */
public class UserDTO implements UserDetails,java.io.Serializable {

    private long id;
    private String username;
    private String password;
    private String email;
    private String birthDate;
    private LanguageDTO defaultLanguage;
    private UserStatus status;
    private Date registrationDate;
    private String country;
    private String city;
    private Boolean newsletter;
    private Integer maxWordGroup;
    private Integer maxWordInGroup;
    private List<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String password, String mail, String birthDate, LanguageDTO defaultLanguage, UserStatus status, Date registrationDate, String country, String city, Boolean newsletter, Integer maxWordGroup, Integer maxWordInGroup, List<RoleDTO> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = mail;
        this.birthDate = birthDate;
        this.defaultLanguage = defaultLanguage;
        this.status = status;
        this.registrationDate = registrationDate;
        this.country = country;
        this.city = city;
        this.newsletter = newsletter;
        this.maxWordGroup = maxWordGroup;
        this.maxWordInGroup = maxWordInGroup;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public LanguageDTO getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(LanguageDTO defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public Integer getMaxWordGroup() {
        return maxWordGroup;
    }

    public void setMaxWordGroup(Integer maxWordGroup) {
        this.maxWordGroup = maxWordGroup;
    }

    public Integer getMaxWordInGroup() {
        return maxWordInGroup;
    }

    public void setMaxWordInGroup(Integer maxWordInGroup) {
        this.maxWordInGroup = maxWordInGroup;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (RoleDTO r :getRoles()) {
            authorities.add(new GrantedAuthorityImpl(r.getName()));
        }
        return authorities;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != userDTO.id) return false;
        if (username != null ? !username.equals(userDTO.username) : userDTO.username != null) return false;
        return registrationDate != null ? registrationDate.equals(userDTO.registrationDate) : userDTO.registrationDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                '}';
    }
}
