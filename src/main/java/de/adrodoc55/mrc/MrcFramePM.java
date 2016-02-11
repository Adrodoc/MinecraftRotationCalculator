package de.adrodoc55.mrc;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;
import org.beanfabrics.support.Operation;
import org.beanfabrics.support.Validation;
import org.beanfabrics.validation.ValidationState;

public class MrcFramePM extends AbstractPM {

  TextPM template = new TextPM();
  IntegerPM accuracy = new IntegerPM();
  IntegerPM radius = new IntegerPM();
  TextPM result = new TextPM();

  OperationPM calculate = new OperationPM();

  public MrcFramePM() {
    template.setMandatory(true);
    radius.setMandatory(true);
    accuracy.setMandatory(true);
    result.setEditable(false);
    PMManager.setup(this);
  }

  @Operation
  public void calculate() {
    int r = radius.getInteger();
    int a = accuracy.getInteger();
    String template = this.template.getText();

    StringBuilder sb = new StringBuilder();
    for (int rym = -a / 2; rym < 360 - a; rym += a) {
      int ry = rym + a;
      String result = RotationCalculator.insertCoords(template, r, rym, ry);
      sb.append(result);
      sb.append('\n');
    }
    String result = sb.toString();
    this.result.setText(result);
  }

  @Validation(path = "calculate")
  public ValidationState canCalculate() {
    if (!accuracy.isValid())
      return new ValidationState("Accuracy is invalid");
    if (!radius.isValid())
      return new ValidationState("Radius is invalid");
    if (!template.isValid())
      return new ValidationState("You need to specify a template");
    return null;
  }

}
