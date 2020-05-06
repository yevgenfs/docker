package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "mydb", catalog = "")
public class UserEntity {
    private Integer iduser;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Collection<TiketEntity> tiketsByIduser;
    private UserBankEntity userBankByIduser;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iduser")
    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(iduser, that.iduser) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, phoneNumber, firstName, lastName);
    }

    @OneToMany(mappedBy = "userByUserIduser")
    public Collection<TiketEntity> getTiketsByIduser() {
        return tiketsByIduser;
    }

    public void setTiketsByIduser(Collection<TiketEntity> tiketsByIduser) {
        this.tiketsByIduser = tiketsByIduser;
    }

    @OneToOne(mappedBy = "userByUserIduser")
    public UserBankEntity getUserBankByIduser() {
        return userBankByIduser;
    }

    public void setUserBankByIduser(UserBankEntity userBankByIduser) {
        this.userBankByIduser = userBankByIduser;
    }

    public UserEntity() {
    }

    public UserEntity(Integer iduser, String phoneNumber, String firstName, String lastName) {
        this.iduser = iduser;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String toString() {
        return String.format("%-11d %-45s %-45s %-45s", iduser , phoneNumber ,firstName , lastName );
    }
}
