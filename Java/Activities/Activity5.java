package activities;
abstract class Book {
    String title;
    abstract void setTitle(String title);
    String getTitle(){
        return title;
    }
}

class MyBook extends Book {
    public void setTitle(String title) {
        this.title = title;
    }
}
public class Activity5 {
    public static void main(String[] args) {
        String title = "Hover Car Racer";
        Book newNovel = new MyBook();
        //Set title
        newNovel.setTitle(title);

        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }
}
