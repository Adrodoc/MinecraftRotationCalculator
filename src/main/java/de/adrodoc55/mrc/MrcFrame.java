package de.adrodoc55.mrc;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.beanfabrics.IModelProvider;
import org.beanfabrics.Link;
import org.beanfabrics.ModelProvider;
import org.beanfabrics.ModelSubscriber;
import org.beanfabrics.Path;
import org.beanfabrics.View;
import org.beanfabrics.swing.BnButton;
import org.beanfabrics.swing.BnTextArea;
import org.beanfabrics.swing.BnTextField;

/**
 * The MrcFrame is a {@link View} on a {@link de.adrodoc55.mrc.MrcFramePM}.
 *
 * @created by the Beanfabrics Component Wizard, www.beanfabrics.org
 */
@SuppressWarnings("serial")
public class MrcFrame extends JFrame implements View<de.adrodoc55.mrc.MrcFramePM>, ModelSubscriber {
  private final Link link = new Link(this);
  private ModelProvider localModelProvider;
  private JPanel paramPanel;
  private JScrollPane scrollPane;
  private BnTextArea bntxtrResult;
  private BnTextField bntxtfldAccuracy;
  private JLabel lblAccuracy;
  private JLabel lblRadius;
  private BnTextField bntxtfldRadius;
  private JLabel lblTemplate;
  private BnTextField bntxtfldTemplate;
  private BnButton bnbtnCalculate;

  /**
   * Constructs a new <code>MrcFrame</code>.
   */
  public MrcFrame() {
    super("Minecraft Rotation Calculator v0.1 - by Adrodoc55");
    init();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 500);
    setLocationRelativeTo(null);
  }

  private void init() {
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(getParamPanel(), BorderLayout.NORTH);
    getContentPane().add(getScrollPane(), BorderLayout.CENTER);
  }

  /**
   * Returns the local {@link ModelProvider} for this class.
   *
   * @return the local <code>ModelProvider</code>
   * @wbp.nonvisual location=10,430
   */
  protected ModelProvider getLocalModelProvider() {
    if (localModelProvider == null) {
      localModelProvider = new ModelProvider(); // @wb:location=10,430
      localModelProvider.setPresentationModelType(de.adrodoc55.mrc.MrcFramePM.class);
    }
    return localModelProvider;
  }

  /** {@inheritDoc} */
  public de.adrodoc55.mrc.MrcFramePM getPresentationModel() {
    return getLocalModelProvider().getPresentationModel();
  }

  /** {@inheritDoc} */
  public void setPresentationModel(de.adrodoc55.mrc.MrcFramePM pModel) {
    getLocalModelProvider().setPresentationModel(pModel);
  }

  /** {@inheritDoc} */
  public IModelProvider getModelProvider() {
    return this.link.getModelProvider();
  }

  /** {@inheritDoc} */
  public void setModelProvider(IModelProvider modelProvider) {
    this.link.setModelProvider(modelProvider);
  }

  /** {@inheritDoc} */
  public Path getPath() {
    return this.link.getPath();
  }

  /** {@inheritDoc} */
  public void setPath(Path path) {
    this.link.setPath(path);
  }

  private JPanel getParamPanel() {
    if (paramPanel == null) {
      paramPanel = new JPanel();
      paramPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
      GridBagLayout gbl_paramPanel = new GridBagLayout();
      gbl_paramPanel.columnWidths = new int[] {0, 200, 0};
      gbl_paramPanel.columnWeights = new double[] {0.0, 0.0, 1.0};
      gbl_paramPanel.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0};
      paramPanel.setLayout(gbl_paramPanel);
      GridBagConstraints gbc_lblAccuracy = new GridBagConstraints();
      gbc_lblAccuracy.insets = new Insets(0, 0, 5, 5);
      gbc_lblAccuracy.anchor = GridBagConstraints.EAST;
      gbc_lblAccuracy.gridx = 0;
      gbc_lblAccuracy.gridy = 0;
      paramPanel.add(getLblAccuracy(), gbc_lblAccuracy);
      GridBagConstraints gbc_bntxtfldAccuracy = new GridBagConstraints();
      gbc_bntxtfldAccuracy.insets = new Insets(0, 0, 5, 5);
      gbc_bntxtfldAccuracy.fill = GridBagConstraints.HORIZONTAL;
      gbc_bntxtfldAccuracy.gridx = 1;
      gbc_bntxtfldAccuracy.gridy = 0;
      paramPanel.add(getBntxtfldAccuracy(), gbc_bntxtfldAccuracy);
      GridBagConstraints gbc_lblRadius = new GridBagConstraints();
      gbc_lblRadius.anchor = GridBagConstraints.EAST;
      gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
      gbc_lblRadius.gridx = 0;
      gbc_lblRadius.gridy = 1;
      paramPanel.add(getLblRadius(), gbc_lblRadius);
      GridBagConstraints gbc_bntxtfldRadius = new GridBagConstraints();
      gbc_bntxtfldRadius.insets = new Insets(0, 0, 5, 5);
      gbc_bntxtfldRadius.fill = GridBagConstraints.HORIZONTAL;
      gbc_bntxtfldRadius.gridx = 1;
      gbc_bntxtfldRadius.gridy = 1;
      paramPanel.add(getBntxtfldRadius(), gbc_bntxtfldRadius);
      GridBagConstraints gbc_lblTemplate = new GridBagConstraints();
      gbc_lblTemplate.anchor = GridBagConstraints.EAST;
      gbc_lblTemplate.insets = new Insets(0, 0, 5, 5);
      gbc_lblTemplate.gridx = 0;
      gbc_lblTemplate.gridy = 2;
      paramPanel.add(getLblTemplate(), gbc_lblTemplate);
      GridBagConstraints gbc_bntxtfldTemplate = new GridBagConstraints();
      gbc_bntxtfldTemplate.gridwidth = 3;
      gbc_bntxtfldTemplate.insets = new Insets(0, 0, 5, 0);
      gbc_bntxtfldTemplate.fill = GridBagConstraints.HORIZONTAL;
      gbc_bntxtfldTemplate.gridx = 1;
      gbc_bntxtfldTemplate.gridy = 2;
      paramPanel.add(getBntxtfldTemplate(), gbc_bntxtfldTemplate);
      GridBagConstraints gbc_bnbtnCalculate = new GridBagConstraints();
      gbc_bnbtnCalculate.insets = new Insets(0, 0, 0, 5);
      gbc_bnbtnCalculate.anchor = GridBagConstraints.WEST;
      gbc_bnbtnCalculate.gridx = 1;
      gbc_bnbtnCalculate.gridy = 3;
      paramPanel.add(getBnbtnCalculate(), gbc_bnbtnCalculate);
    }
    return paramPanel;
  }

  private JScrollPane getScrollPane() {
    if (scrollPane == null) {
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getBntxtrResult());
    }
    return scrollPane;
  }

  private BnTextArea getBntxtrResult() {
    if (bntxtrResult == null) {
      bntxtrResult = new BnTextArea();
      bntxtrResult.setPath(new Path("this.result"));
      bntxtrResult.setModelProvider(getLocalModelProvider());
    }
    return bntxtrResult;
  }

  private BnTextField getBntxtfldAccuracy() {
    if (bntxtfldAccuracy == null) {
      bntxtfldAccuracy = new BnTextField();
      bntxtfldAccuracy.setPath(new Path("this.accuracy"));
      bntxtfldAccuracy.setModelProvider(getLocalModelProvider());
      bntxtfldAccuracy.setText("accuracy");
    }
    return bntxtfldAccuracy;
  }

  private JLabel getLblAccuracy() {
    if (lblAccuracy == null) {
      lblAccuracy = new JLabel("Accuracy");
    }
    return lblAccuracy;
  }

  private JLabel getLblRadius() {
    if (lblRadius == null) {
      lblRadius = new JLabel("Radius");
    }
    return lblRadius;
  }

  private BnTextField getBntxtfldRadius() {
    if (bntxtfldRadius == null) {
      bntxtfldRadius = new BnTextField();
      bntxtfldRadius.setPath(new Path("this.radius"));
      bntxtfldRadius.setModelProvider(getLocalModelProvider());
    }
    return bntxtfldRadius;
  }

  private JLabel getLblTemplate() {
    if (lblTemplate == null) {
      lblTemplate = new JLabel("Template");
    }
    return lblTemplate;
  }

  private BnTextField getBntxtfldTemplate() {
    if (bntxtfldTemplate == null) {
      bntxtfldTemplate = new BnTextField();
      bntxtfldTemplate.setPath(new Path("this.template"));
      bntxtfldTemplate.setModelProvider(getLocalModelProvider());
    }
    return bntxtfldTemplate;
  }

  private BnButton getBnbtnCalculate() {
    if (bnbtnCalculate == null) {
      bnbtnCalculate = new BnButton();
      bnbtnCalculate.setPath(new Path("this.calculate"));
      bnbtnCalculate.setModelProvider(getLocalModelProvider());
      bnbtnCalculate.setText("Calculate");
    }
    return bnbtnCalculate;
  }
}
