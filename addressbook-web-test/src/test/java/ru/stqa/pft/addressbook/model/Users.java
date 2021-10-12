package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserInfo> {

    private Set<UserInfo> delegate;

    public Users(Users users) {
        this.delegate = new HashSet<UserInfo>(users.delegate);
    }

    public Users() {
        this.delegate = new HashSet<UserInfo>();
    }

    public Users(Collection<UserInfo> users) {
        this.delegate = new HashSet<UserInfo>(users);
    }

    public Users with(UserInfo user) {
        Users users = new Users(this);
        users.add(user);
        return users;
    }

    public Users without(UserInfo user) {
        Users users = new Users(this);
        users.remove(user);
        return users;
    }

    @Override
    protected Set<UserInfo> delegate() {
        return delegate;
    }
}
