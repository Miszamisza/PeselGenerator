package com.peselgenerator.generator.front;

import com.peselgenerator.generator.controller.DataController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@Route("pesel_check")
public class FormPeselCheck extends VerticalLayout {

    private TextField textFieldPesel = new TextField();
    private Label labelPesel = new Label("Pesel: ");

    private Button button = new Button("Submit");


    @Autowired
    DataController dataController;

    public FormPeselCheck() {
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(labelPesel, textFieldPesel);

        add(h1);
        add(button);

        button.addClickListener(clickEvent -> peselCheck());
    }

    private void peselCheck() {
        dataController.peselCheck(Long.parseLong(textFieldPesel.getValue()));
    }
}
