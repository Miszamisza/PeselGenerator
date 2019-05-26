package com.peselgenerator.generator.front;

import com.peselgenerator.generator.controller.DataController;
import com.peselgenerator.generator.service.DataService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("pesel_generator")
public class FormPeselGenerator extends VerticalLayout {

    TextField textFieldDay = new TextField();
    Label labelday = new Label("Day: ");

    TextField textFieldMonth = new TextField();
    Label labelmonth = new Label("Month: ");

    TextField textFieldYear = new TextField();
    Label labelyear = new Label("Year: ");

    RadioButtonGroup<String> group = new RadioButtonGroup<>();

    Button button = new Button("Submit");

    @Autowired
    DataController dataController;

    public FormPeselGenerator() {
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(labelday, textFieldDay);

        HorizontalLayout h2 = new HorizontalLayout();
        h2.add(labelmonth, textFieldMonth);

        HorizontalLayout h3 = new HorizontalLayout();
        h3.add(labelyear, textFieldYear);
        group.setItems("Men", "Women");
        HorizontalLayout h4 = new HorizontalLayout();
        h4.add(group);

        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(button);

        button.addClickListener(clickEvent -> peselGenerator());
    }

    private void peselGenerator() {
        dataController.peselGenerator(Integer.parseInt(textFieldDay.getValue()),
                Integer.parseInt(textFieldMonth.getValue()),
                Integer.parseInt(textFieldYear.getValue()),
                group.getValue());
    }
}
