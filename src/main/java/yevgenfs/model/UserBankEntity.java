package yevgenfs.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_bank", schema = "mydb", catalog = "")
public class UserBankEntity {
    private Integer userIduser;
    private Integer numberOfBankAccount;
    private UserEntity userByUserIduser;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_iduser")
    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @Basic
    @Column(name = "number_of_bank_account")
    public Integer getNumberOfBankAccount() {
        return numberOfBankAccount;
    }

    public void setNumberOfBankAccount(Integer numberOfBankAccount) {
        this.numberOfBankAccount = numberOfBankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBankEntity that = (UserBankEntity) o;
        return Objects.equals(userIduser, that.userIduser) &&
                Objects.equals(numberOfBankAccount, that.numberOfBankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIduser, numberOfBankAccount);
    }

    @OneToOne
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false)
    public UserEntity getUserByUserIduser() {
        return userByUserIduser;
    }

    public void setUserByUserIduser(UserEntity userByUserIduser) {
        this.userByUserIduser = userByUserIduser;
    }

    public UserBankEntity() {
    }

    public UserBankEntity(Integer userIduser, Integer numberOfBankAccount) {
        this.userIduser = userIduser;
        this.numberOfBankAccount = numberOfBankAccount;

    }

    @Override
    public String toString() {
        return String.format("%-11d %-11d" , userIduser , numberOfBankAccount );
    }

}
