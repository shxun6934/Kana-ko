package smartphoneapp_project.kanazawaapp_2017.Event;

import java.lang.reflect.Array;

public class Event {
    private String title;
    private String dates;
    private String description;

    public Event(String title, String dates, String description){
        super();

        this.title = title;
        this.dates = dates;
        this.description = description;
    }

    public String getName(){
        return this.title;
    }

    public String getHobby(){
        return this.dates;
    }

    public String getDetails(){
        return this.description;
    }
}
