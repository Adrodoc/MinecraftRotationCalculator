package de.adrodoc55.mrc;

import org.beanfabrics.swing.ModelSubscriberBeanInfo;

/**
 * @created by the Beanfabrics Component Wizard, www.beanfabrics.org
 */
public class MrcFrameBeanInfo extends ModelSubscriberBeanInfo {
  @Override
  protected Class<MrcFrame> getBeanClass() {
    return MrcFrame.class;
  }

  @Override
  protected boolean isPathBound() {
    return false;
  }
}
