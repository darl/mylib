package ru.darlz.mylib.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 15.02.12 23:31
 */
public class Test implements EntryPoint {
    public void onModuleLoad() {

        System.out.println("TEST!!!!!!!!!!");
        IButton button = new IButton();
        button.setTitle("Click!");

        button.addClickHandler(new ClickHandler(){

            @Override
            public void onClick(ClickEvent event)
            {
                SC.say("Hello World! :)");
            }

        });

        button.show();
    }
}
