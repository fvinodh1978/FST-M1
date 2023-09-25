package activities;

class CustomException extends Exception {
    private final String message;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

public class Activity8 {
    public static void main(String[] args) throws CustomException {
        Activity8 myActivity = new Activity8();
        //Send Null String
        myActivity.exceptionTest(null);
        //Send Valid String
        myActivity.exceptionTest("Valid Message Sent");
    }

    public void exceptionTest(String str) throws CustomException {
        try {
            if (str == null || str == "") {
                throw new CustomException("Please send valid String");
            } else {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}