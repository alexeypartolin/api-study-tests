package backend.helpers;

public class EndpointsContollers {
    // Контроллер для https://petstore.swagger.io/#/user/getUserByName
    public static class UserController {
        public static class Post {

        }

        public static class Get {
            public static String getUserByName(String userName) {
                return "/user/" + userName;
            }
        }
    }

    // Контроллер для https://petstore.swagger.io/v2/store/order/*
    public static class OrderController {
        public static class Get {
            public static String getOrderById(Integer orderId) {
                return "/store/order/" + orderId;
            }}
    }

    //https://petstore.swagger.io/#/pet/getPetById
    public static class PetController {
        public static  class Get {
            public static String getPetById(String id) {
                return "/pet/" + id;
            }
        }
    }
}


