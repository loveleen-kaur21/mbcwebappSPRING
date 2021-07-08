package net.codejava.mbcwebapp;

public interface CustomApplicationRepository {
    public Application findByEmail(String email);
}
