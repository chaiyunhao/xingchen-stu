package cn.character.model;

import lombok.Data;

import java.util.Optional;


@Data
public class User {
    private String name;



    public static Boolean isNameValid(String name){

        return Boolean.TRUE;
    }


}
