package org.omnifaces.showcase.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.showcase.model.ExampleEntity;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class CommandScriptBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> hashFragments;
	private List<ExampleEntity> exampleEntities;

	@PostConstruct
	public void init() {
		hashFragments = new ArrayList<>();
	}

	public void addHashFragment() {
		hashFragments.add(Faces.getRequestParameter("hashFragment"));
	}

	public void loadLazyData() {
		exampleEntities = new ArrayList<>();
		exampleEntities.add(new ExampleEntity(1L, "Amsterdam"));
		exampleEntities.add(new ExampleEntity(2L, "Frankfurt"));
		exampleEntities.add(new ExampleEntity(3L, "London"));
	}

	public List<String> getHashFragments() {
		return hashFragments;
	}

	public List<ExampleEntity> getExampleEntities() {
		return exampleEntities;
	}

}