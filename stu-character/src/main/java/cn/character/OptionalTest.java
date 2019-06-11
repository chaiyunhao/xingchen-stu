package cn.character;

import cn.character.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    public String getName(User u) {
        if (u == null)
            return "Unknown";
        return u.getName();
    }

    private User user;

    /**
     * Optional 改写
     * @param u
     * @return
     */
    public String getName2(User u) {
        return Optional.ofNullable(u)
                .map(user->user.getName())
                .orElse("Unknown");
    }

    public void setName(String name) throws IllegalArgumentException {

        this.user.setName(Optional.ofNullable(name).filter(User::isNameValid)
                .orElseThrow(()->new IllegalArgumentException("Invalid username.")));
    }


    public void testOptional(){
        /* of */
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("YanWei");
        //传入参数为null，抛出NullPointerException.
        //Optional<String> someNull = Optional.of(null);

        /*opNullable*/
        Optional empty = Optional.ofNullable(null);

        /*isPresent*/
        if (name.isPresent()) {
            System.out.println(name.get());//输出YanWei
        }

        /*get*/
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }

        /*ifPresent*/
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });

        /*orElse*/
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        /*orElseGet*/
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(String::new));

        /*orElseThrow*/
        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable ex) {
            System.out.println("error:" + ex.getMessage());
        }

        /*map*/
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        /*flatMap*/
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.get());

        /*filter*/
        List<String> names = Arrays.asList("YanWei","YanTian");
        for(String s:names)
        {
            Optional<String> nameLenLessThan7 = Optional.of(s).filter((value) -> value.length() < 7);
            System.out.println(nameLenLessThan7.orElse("The name is more than 6 characters"));
        }
    }

    public static void main(String[] args){
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.user = new User();
//        optionalTest.testOptional();
        optionalTest.setName("222");
//        optionalTest.user = null;
        Optional.of(optionalTest.user).ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.getName());
        });

    }


}

