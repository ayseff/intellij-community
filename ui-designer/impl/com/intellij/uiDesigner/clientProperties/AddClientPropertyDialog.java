package com.intellij.uiDesigner.clientProperties;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.uiDesigner.clientProperties.ClientPropertiesManager;
import com.intellij.uiDesigner.UIDesignerBundle;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author yole
 */
public class AddClientPropertyDialog extends DialogWrapper {
  private JTextField myPropertyNameTextField;
  private JRadioButton myStringRadioButton;
  private JRadioButton myIntegerRadioButton;
  private JRadioButton myDoubleRadioButton;
  private JRadioButton myBooleanRadioButton;
  private JPanel myRootPanel;
  private JPanel myGroupPanel;

  public AddClientPropertyDialog(Project project) {
    super(project, false);
    init();
    setTitle(UIDesignerBundle.message("client.property.add.title"));
    myGroupPanel.setBorder(IdeBorderFactory.createTitledHeaderBorder(UIDesignerBundle.message("client.properties.type.header")));
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myRootPanel;
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return myPropertyNameTextField;
  }

  public ClientPropertiesManager.ClientProperty getEnteredProperty() {
    String className;
    if (myStringRadioButton.isSelected()) {
      className = String.class.getName();
    }
    else if (myIntegerRadioButton.isSelected()) {
      className = Integer.class.getName();
    }
    else if (myDoubleRadioButton.isSelected()) {
      className = Double.class.getName();
    }
    else {
      className = Boolean.class.getName();
    }
    return new ClientPropertiesManager.ClientProperty(myPropertyNameTextField.getText(), className);
  }
}
