package com.medicalabuseprevention.requestdto;

/**
 *
 * @author harpreetsi
 */
public class PrescriptionUpdateRequest {

  private Long id;
  private boolean provided;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isProvided() {
    return provided;
  }

  public void setProvided(boolean provided) {
    this.provided = provided;
  }
}
