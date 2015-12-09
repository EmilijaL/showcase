package org.omnifaces.showcase.validators;

import java.io.Serializable;

import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class ValidateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp="^(?=\\s*\\S).*$", message = "Please enter value") // not empty
	@Size(min = 6, groups = MyValidationGroup.class, message = "Please enter at least 6 characters")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}