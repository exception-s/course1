package CollectionObjects;

import CollectionObjects.Objects.Organization;

import java.io.Serializable;

public class Request implements Serializable {
    private final User user;
    private final String[] input;
    private Organization org;

    public Request(User user, String[] input, Organization org) {
        this.user = user;
        this.input = input;
        this.org = org;
    }

    public Request(User user, String[] input) {
        this.user = user;
        this.input = input;
    }

    public User getUser() {
        return user;
    }

    public String[] getInput() {
        return input;
    }

    public Organization getOrg() {
        return org;
    }
}
