package com.spring.rest.exception_handling;

import java.util.Objects;

public class EmployeeIncorrectData {

    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeIncorrectData other = (EmployeeIncorrectData) obj;
        return Objects.equals(this.info, other.info);
    }

    @Override
    public String toString() {
        return "EmployeeIncorrectData{" + "info=" + info + '}';
    }
}
