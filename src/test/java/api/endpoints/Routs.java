package api.endpoints;

public class Routs {

    //Base URL
    public static String Base_URL = "https://petstore.swagger.io/v2";

    //User Module
    public static String Post_URL = Base_URL + "/user";
    public static String Get_URL = Base_URL + "/user/{username}";
    public static String Update_URL = Base_URL + "/user/{username}";
    public static String Delete_URL = Base_URL + "/user/{username}";

    //Create different modules as per requirments.
}
