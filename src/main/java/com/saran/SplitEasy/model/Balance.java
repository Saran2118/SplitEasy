package com.saran.SplitEasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int balanceId;

    private int groupId;

    @Column(nullable = false)
    private int owesUser;

    @Column(nullable = false)
    private int owesToUser;

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getOwesUser() {
        return owesUser;
    }

    public void setOwesUser(int owesUser) {
        this.owesUser = owesUser;
    }

    public int getOwesToUser() {
        return owesToUser;
    }

    public void setOwesToUser(int owesToUser) {
        this.owesToUser = owesToUser;
    }
}
