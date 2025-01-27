package com.saran.SplitEasy.RestModel;

import java.util.List;

public class GroupWrapper {
    private String groupName;
    private int createdUserId;
    private List<Integer> groupMembers;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public List<Integer> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMmbers(List<Integer> groupMembers) {
        this.groupMembers = groupMembers;
    }
}
