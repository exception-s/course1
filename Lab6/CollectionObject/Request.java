package CollectionObject;

import CollectionObject.Objects.Organization;

import java.io.Serializable;

public class Request implements Serializable {
    private final String[] input;
    private Organization org;
    public Request(String[] input, Organization org) {
        this.input = input;
        this.org = org;
    }

    public Request(String[] input) {
        this.input = input;
    }

    public String[] getInput() {
        return input;
    }

    public Organization getOrg() {
        return org;
    }
}
