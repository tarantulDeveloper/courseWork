package kg.sklad.models;

public class MyError {
    private int statusCode;
    private String message;

    public MyError(int statusCode, String messsage) {
        this.statusCode = statusCode;
        this.message = messsage;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMesssage() {
        return message;
    }

    public void setMesssage(String messsage) {
        this.message = messsage;
    }
}
